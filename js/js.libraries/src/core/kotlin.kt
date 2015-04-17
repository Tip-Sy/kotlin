package kotlin

import java.util.*

deprecated("Use arrayOf() instead.")
library
public fun <T> array(vararg value : T): Array<T> = noImpl
library
public fun <T> arrayOf(vararg value : T): Array<T> = noImpl

// "constructors" for primitive types array

deprecated("Use doubleArrayOf() instead.")
library
public fun doubleArray(vararg content : Double): DoubleArray    = noImpl
library
public fun doubleArrayOf(vararg content : Double): DoubleArray    = noImpl

deprecated("Use floatArrayOf() instead.")
library
public fun floatArray(vararg content : Float): FloatArray       = noImpl
library
public fun floatArrayOf(vararg content : Float): FloatArray       = noImpl

deprecated("Use longArrayOf() instead.")
library
public fun longArray(vararg content : Long): LongArray          = noImpl
library
public fun longArrayOf(vararg content : Long): LongArray          = noImpl

deprecated("Use intArrayOf() instead.")
library
public fun intArray(vararg content : Int): IntArray             = noImpl
library
public fun intArrayOf(vararg content : Int): IntArray             = noImpl

deprecated("Use charArrayOf() instead.")
library
public fun charArray(vararg content : Char): CharArray          = noImpl
library
public fun charArrayOf(vararg content : Char): CharArray          = noImpl

deprecated("Use shortArrayOf() instead.")
library
public fun shortArray(vararg content : Short): ShortArray       = noImpl
library
public fun shortArrayOf(vararg content : Short): ShortArray       = noImpl

deprecated("Use byteArrayOf() instead.")
library
public fun byteArray(vararg content : Byte): ByteArray          = noImpl
library
public fun byteArrayOf(vararg content : Byte): ByteArray          = noImpl

deprecated("Use booleanArrayOf() instead.")
library
public fun booleanArray(vararg content : Boolean): BooleanArray = noImpl
library
public fun booleanArrayOf(vararg content : Boolean): BooleanArray = noImpl

deprecated("Use toArray() instead.")
library("copyToArray")
public fun <reified T> Collection<T>.copyToArray(): Array<T> = noImpl
library("copyToArray")
public fun <reified T> Collection<T>.toArray(): Array<T> = noImpl
