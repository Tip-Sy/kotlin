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

package kotlin.text

import java.util.ArrayList
import java.util.regex.Pattern as NativePattern
import java.util.regex.Matcher
import kotlin.properties.Delegates

private val TODO: Nothing get() = throw UnsupportedOperationException()

public trait FlagEnum {
    public val value: Int
    public val mask: Int
}
public fun Iterable<FlagEnum>.toInt(): Int =
        this.fold(0, { value, option -> value or option.value })
public fun <T: FlagEnum> fromInt(value: Int, allValues: Array<T>): Set<T> =
        allValues.filter({ value and it.mask == it.value }).toSet()


public enum class PatternOption(override val value: Int, override val mask: Int = value) : FlagEnum {
    // common
    IGNORE_CASE : PatternOption(NativePattern.CASE_INSENSITIVE)
    MULTILINE : PatternOption(NativePattern.MULTILINE)

    //jvm-specific
    LITERAL : PatternOption(NativePattern.LITERAL)
    UNICODE_CASE: PatternOption(NativePattern.UNICODE_CASE)
    UNIX_LINES: PatternOption(NativePattern.UNIX_LINES)
    COMMENTS: PatternOption(NativePattern.COMMENTS)
    DOT_MATCHES_ALL: PatternOption(NativePattern.DOTALL)
    CANON_EQ: PatternOption(NativePattern.CANON_EQ)
}

/* in JS
public enum class PatternOptions(val value: String) {
    IGNORE_CASE : PatternOptions("i")
    MULTILINE : PatternOptions("m")
}
*/

public data class MatchGroup(val value: String, val range: IntRange)

public trait MatchGroupCollection : Collection<MatchGroup?> {
    public fun get(index: Int): MatchGroup?
}

public trait MatchResult {
    public val range: IntRange
    public val value: String
    public val groups: MatchGroupCollection
    // TODO: Should we have groupCount (equals groups.size()-1)?

    public fun next(): MatchResult?
}


public class Pattern ( /* visibility? */ val nativePattern: NativePattern) {

    public constructor(pattern: String, options: Set<PatternOption>): this(NativePattern.compile(pattern, options.toInt()))
    public constructor(pattern: String, vararg options: PatternOption) : this(pattern, options.toSet())

    public val pattern: String
        get() = nativePattern.pattern()

    public val options: Set<PatternOption> = fromInt(nativePattern.flags(), PatternOption.values())

    public fun matches(input: CharSequence): Boolean = nativePattern.matcher(input).matches()

    public fun match(input: CharSequence): MatchResult? = nativePattern.matcher(input).findNext(0)

    public fun matchAll(input: CharSequence): Sequence<MatchResult> = sequence({ match(input) }, { match -> match.next() })

    public fun replace(input: CharSequence, replacement: String): String = nativePattern.matcher(input).replaceAll(replacement)
    public fun replace(input: CharSequence, evaluator: (MatchResult) -> String): String = TODO

    public fun split(input: CharSequence, limit: Int = 0): List<String> = nativePattern.split(input, limit).asList() // TODO: require(limit>=0)

    public override fun toString(): String = nativePattern.toString()

    companion object {
        public fun fromLiteral(literal: String): Pattern = Pattern(literal, PatternOption.LITERAL)
        public fun escape(literal: String): String = NativePattern.quote(literal)
        public fun escapeReplacement(literal: String): String = Matcher.quoteReplacement(literal)
    }

}

public fun String.toPattern(vararg options: PatternOption): Pattern = Pattern(this, *options)
public fun String.toPattern(options: Set<PatternOption>): Pattern = Pattern(this, options)




private fun Matcher.findNext(from: Int): MatchResult? {
    if (!find(from))
        return null

    // TODO: If we need MatchResult to be thread safe we must lock everything, or call this.toMatchResult early
    var matchResult: java.util.regex.MatchResult = this

    return object: MatchResult {
        override val range: IntRange
            get() = matchResult.range()
        override val value: String
            get() = matchResult.group()

        override val groups: MatchGroupCollection = object : MatchGroupCollection {
            override fun size(): Int = matchResult.groupCount() + 1
            override fun isEmpty(): Boolean = false
            override fun contains(o: Any?): Boolean = o is MatchGroup? && this.any({ it == o })
            override fun containsAll(c: Collection<Any?>): Boolean = c.all({contains(it)})

            override fun iterator(): Iterator<MatchGroup?> = indices.sequence().map { this[it] }.iterator()
            override fun get(index: Int): MatchGroup? {
                val range = matchResult.range(index)
                return if (range.start >= 0)
                    MatchGroup(matchResult.group(index), range)
                else
                    null
            }
        }


        override fun next(): MatchResult? {
            if (this@findNext === matchResult)
                matchResult = this@findNext.toMatchResult()
            return this@findNext.findNext(matchResult.end())
        }
    }
}

private fun java.util.regex.MatchResult.range(): IntRange = start()..end()-1
private fun java.util.regex.MatchResult.range(groupIndex: Int): IntRange = start(groupIndex)..end(groupIndex)-1
