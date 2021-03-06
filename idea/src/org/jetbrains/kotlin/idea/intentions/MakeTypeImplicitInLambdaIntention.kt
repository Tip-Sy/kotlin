/*
 * Copyright 2010-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.idea.intentions

import com.intellij.openapi.editor.Editor
import org.jetbrains.kotlin.psi.JetFunctionLiteralExpression
import org.jetbrains.kotlin.psi.JetPsiFactory
import org.jetbrains.kotlin.lexer.JetTokens

public class MakeTypeImplicitInLambdaIntention : JetSelfTargetingIntention<JetFunctionLiteralExpression>(
        "make.type.implicit.in.lambda", javaClass()) {
    override fun isApplicableTo(element: JetFunctionLiteralExpression, caretOffset: Int): Boolean {
        val openBraceOffset = element.getLeftCurlyBrace().getStartOffset()
        val closeBraceOffset = element.getRightCurlyBrace()?.getStartOffset()
        val arrow = element.getFunctionLiteral().getArrowNode()
        if (arrow != null && !(openBraceOffset < caretOffset && caretOffset < arrow.getStartOffset() + 2) &&
            caretOffset != closeBraceOffset) return false
        else if (arrow == null && caretOffset != openBraceOffset + 1 && caretOffset != closeBraceOffset) return false
        return hasExplicitReturnType(element) || hasExplicitReceiverType(element) || hasExplicitParamType(element)
    }

    override fun applyTo(element: JetFunctionLiteralExpression, editor: Editor) {
        val functionLiteral = element.getFunctionLiteral()
        val oldParameterList = functionLiteral.getValueParameterList()

        val psiFactory = JetPsiFactory(element)
        if (hasExplicitReturnType(element)) {
            val childAfterParamList = oldParameterList?.getNextSibling()
            val arrow = functionLiteral.getArrowNode()?.getPsi()
            val childBeforeArrow = arrow?.getPrevSibling()
            functionLiteral.deleteChildRange(childAfterParamList, childBeforeArrow)
            val whiteSpaceBeforeArrow = psiFactory.createWhiteSpace()
            functionLiteral.addBefore(whiteSpaceBeforeArrow, arrow)
        }

        if (hasExplicitReceiverType(element)) {
            val childAfterBrace = functionLiteral.getLBrace()?.getNextSibling()
            val childBeforeParamList = oldParameterList?.getPrevSibling()
            functionLiteral.deleteChildRange(childAfterBrace, childBeforeParamList)
        }

        if (oldParameterList?.getParameters() != null && hasExplicitParamType(element)) {
            val parameterString = oldParameterList!!.getParameters().map({ parameter ->
                                                                             parameter.getNameIdentifier()!!.getText()
                                                                         }).makeString(", ", "(", ")")
            val newParameterList = psiFactory.createParameterList(parameterString)
            oldParameterList.replace(newParameterList)
        }

        if (!hasExplicitParamType(element)) {
            val currentParamList = element.getFunctionLiteral().getValueParameterList()
            val firstChild = currentParamList?.getFirstChild()
            if (firstChild?.getNode()?.getElementType() == JetTokens.LPAR) firstChild!!.delete()
            val lastChild = currentParamList?.getLastChild()
            if (lastChild?.getNode()?.getElementType() == JetTokens.RPAR) lastChild!!.delete()
        }
    }

    private fun hasExplicitReturnType(element: JetFunctionLiteralExpression): Boolean {
        return element.hasDeclaredReturnType()
    }

    private fun hasExplicitReceiverType(element: JetFunctionLiteralExpression): Boolean {
        return element.getFunctionLiteral().getReceiverTypeReference() != null
    }

    private fun hasExplicitParamType(element: JetFunctionLiteralExpression): Boolean {
        val parameters = element.getFunctionLiteral().getValueParameterList()?.getParameters()
        if (parameters == null) return false
        var hasExplicitParamType = false
        for (param in parameters) {
            if (param.getTypeReference() != null) hasExplicitParamType = true
            if (param.getNameIdentifier()?.getText() == null) return false
        }
        return hasExplicitParamType
    }
}
