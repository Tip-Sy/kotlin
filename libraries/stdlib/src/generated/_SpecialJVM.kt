package kotlin

//
// NOTE THIS FILE IS AUTO-GENERATED by the GenerateStandardLib.kt
// See: https://github.com/JetBrains/kotlin/tree/master/libraries/stdlib
//

import kotlin.platform.*
import java.util.*

import java.util.Collections // TODO: it's temporary while we have java.util.Collections in js

/**
 * Returns a list that wraps the original array
 */
public fun <T> Array<out T>.asList(): List<T> {
    return Arrays.asList(*this)
}

/**
 * Returns a list that wraps the original array
 */
public fun BooleanArray.asList(): List<Boolean> {
    return object : AbstractList<Boolean>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Boolean)
        override fun iterator(): Iterator<Boolean> = this@asList.iterator()
        override fun get(index: Int): Boolean = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Boolean)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Boolean)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun ByteArray.asList(): List<Byte> {
    return object : AbstractList<Byte>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Byte)
        override fun iterator(): Iterator<Byte> = this@asList.iterator()
        override fun get(index: Int): Byte = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Byte)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Byte)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun CharArray.asList(): List<Char> {
    return object : AbstractList<Char>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Char)
        override fun iterator(): Iterator<Char> = this@asList.iterator()
        override fun get(index: Int): Char = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Char)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Char)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun DoubleArray.asList(): List<Double> {
    return object : AbstractList<Double>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Double)
        override fun iterator(): Iterator<Double> = this@asList.iterator()
        override fun get(index: Int): Double = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Double)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Double)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun FloatArray.asList(): List<Float> {
    return object : AbstractList<Float>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Float)
        override fun iterator(): Iterator<Float> = this@asList.iterator()
        override fun get(index: Int): Float = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Float)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Float)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun IntArray.asList(): List<Int> {
    return object : AbstractList<Int>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Int)
        override fun iterator(): Iterator<Int> = this@asList.iterator()
        override fun get(index: Int): Int = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Int)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Int)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun LongArray.asList(): List<Long> {
    return object : AbstractList<Long>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Long)
        override fun iterator(): Iterator<Long> = this@asList.iterator()
        override fun get(index: Int): Long = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Long)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Long)
    }
}

/**
 * Returns a list that wraps the original array
 */
public fun ShortArray.asList(): List<Short> {
    return object : AbstractList<Short>(), RandomAccess {
        override fun size(): Int = this@asList.size()
        override fun isEmpty(): Boolean = this@asList.isEmpty()
        override fun contains(o: Any?): Boolean = this@asList.contains(o as Short)
        override fun iterator(): Iterator<Short> = this@asList.iterator()
        override fun get(index: Int): Short = this@asList[index]
        override fun indexOf(o: Any?): Int = this@asList.indexOf(o as Short)
        override fun lastIndexOf(o: Any?): Int = this@asList.lastIndexOf(o as Short)
    }
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun <T> Array<out T>.binarySearch(element: T, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun ByteArray.binarySearch(element: Byte, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun CharArray.binarySearch(element: Char, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun DoubleArray.binarySearch(element: Double, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun FloatArray.binarySearch(element: Float, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun IntArray.binarySearch(element: Int, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun LongArray.binarySearch(element: Long, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Searches array or range of array for provided element index using binary search algorithm. Array is expected to be sorted.
 */
public fun ShortArray.binarySearch(element: Short, fromIndex: Int = 0, toIndex: Int = size()): Int {
    return Arrays.binarySearch(this, fromIndex, toIndex, element)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun <T> Array<out T>.copyOf(): Array<T> {
    return Arrays.copyOf(this, size()) as Array<T>
}

/**
 * Returns new array which is a copy of the original array
 */
public fun BooleanArray.copyOf(): BooleanArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun ByteArray.copyOf(): ByteArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun CharArray.copyOf(): CharArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun DoubleArray.copyOf(): DoubleArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun FloatArray.copyOf(): FloatArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun IntArray.copyOf(): IntArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun LongArray.copyOf(): LongArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun ShortArray.copyOf(): ShortArray {
    return Arrays.copyOf(this, size())
}

/**
 * Returns new array which is a copy of the original array
 */
public fun <T> Array<out T>.copyOf(newSize: Int): Array<T?> {
    return Arrays.copyOf(this, newSize) as Array<T?>
}

/**
 * Returns new array which is a copy of the original array
 */
public fun BooleanArray.copyOf(newSize: Int): BooleanArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun ByteArray.copyOf(newSize: Int): ByteArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun CharArray.copyOf(newSize: Int): CharArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun DoubleArray.copyOf(newSize: Int): DoubleArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun FloatArray.copyOf(newSize: Int): FloatArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun IntArray.copyOf(newSize: Int): IntArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun LongArray.copyOf(newSize: Int): LongArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of the original array
 */
public fun ShortArray.copyOf(newSize: Int): ShortArray {
    return Arrays.copyOf(this, newSize)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun <T> Array<out T>.copyOfRange(from: Int, to: Int): Array<T> {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun BooleanArray.copyOfRange(from: Int, to: Int): BooleanArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun ByteArray.copyOfRange(from: Int, to: Int): ByteArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun CharArray.copyOfRange(from: Int, to: Int): CharArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun DoubleArray.copyOfRange(from: Int, to: Int): DoubleArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun FloatArray.copyOfRange(from: Int, to: Int): FloatArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun IntArray.copyOfRange(from: Int, to: Int): IntArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun LongArray.copyOfRange(from: Int, to: Int): LongArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Returns new array which is a copy of range of original array
 */
public fun ShortArray.copyOfRange(from: Int, to: Int): ShortArray {
    return Arrays.copyOfRange(this, from, to)
}

/**
 * Fills original array with the provided value
 */
public fun <T> Array<out T>.fill(element: T): Array<out T> {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun BooleanArray.fill(element: Boolean): BooleanArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun ByteArray.fill(element: Byte): ByteArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun CharArray.fill(element: Char): CharArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun DoubleArray.fill(element: Double): DoubleArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun FloatArray.fill(element: Float): FloatArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun IntArray.fill(element: Int): IntArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun LongArray.fill(element: Long): LongArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Fills original array with the provided value
 */
public fun ShortArray.fill(element: Short): ShortArray {
    Arrays.fill(this, element)
    return this
}

/**
 * Returns a list containing all elements that are instances of specified type parameter R
 */
public inline fun <reified R> Array<*>.filterIsInstance(): List<R> {
    return filterIsInstanceTo(ArrayList<R>())
}

/**
 * Returns a list containing all elements that are instances of specified type parameter R
 */
public inline fun <reified R> Iterable<*>.filterIsInstance(): List<R> {
    return filterIsInstanceTo(ArrayList<R>())
}

/**
 * Returns a sequence containing all elements that are instances of specified type parameter R
 */
public inline fun <reified R> Sequence<*>.filterIsInstance(): Sequence<R> {
    return FilteringSequence(this, true, { it is R }) as Sequence<R>
}


deprecated("Migrate to using Sequence<T> and respective functions")
/**
 * Returns a stream containing all elements that are instances of specified type parameter R
 */
public inline fun <reified R> Stream<*>.filterIsInstance(): Stream<R> {
    return FilteringStream(this, true, { it is R }) as Stream<R>
}

/**
 * Returns a list containing all elements that are instances of specified class
 */
public fun <R> Array<*>.filterIsInstance(klass: Class<R>): List<R> {
    return filterIsInstanceTo(ArrayList<R>(), klass)
}

/**
 * Returns a list containing all elements that are instances of specified class
 */
public fun <R> Iterable<*>.filterIsInstance(klass: Class<R>): List<R> {
    return filterIsInstanceTo(ArrayList<R>(), klass)
}

/**
 * Returns a sequence containing all elements that are instances of specified class
 */
public fun <R> Sequence<*>.filterIsInstance(klass: Class<R>): Sequence<R> {
    return FilteringSequence(this, true, { klass.isInstance(it) }) as Sequence<R>
}


deprecated("Migrate to using Sequence<T> and respective functions")
/**
 * Returns a stream containing all elements that are instances of specified class
 */
public fun <R> Stream<*>.filterIsInstance(klass: Class<R>): Stream<R> {
    return FilteringStream(this, true, { klass.isInstance(it) }) as Stream<R>
}

/**
 * Appends all elements that are instances of specified type parameter R to the given *destination*
 */
public inline fun <reified R, C : MutableCollection<in R>> Array<*>.filterIsInstanceTo(destination: C): C {
    for (element in this) if (element is R) destination.add(element)
    return destination
}

/**
 * Appends all elements that are instances of specified type parameter R to the given *destination*
 */
public inline fun <reified R, C : MutableCollection<in R>> Iterable<*>.filterIsInstanceTo(destination: C): C {
    for (element in this) if (element is R) destination.add(element)
    return destination
}

/**
 * Appends all elements that are instances of specified type parameter R to the given *destination*
 */
public inline fun <reified R, C : MutableCollection<in R>> Sequence<*>.filterIsInstanceTo(destination: C): C {
    for (element in this) if (element is R) destination.add(element)
    return destination
}


deprecated("Migrate to using Sequence<T> and respective functions")
/**
 * Appends all elements that are instances of specified type parameter R to the given *destination*
 */
public inline fun <reified R, C : MutableCollection<in R>> Stream<*>.filterIsInstanceTo(destination: C): C {
    for (element in this) if (element is R) destination.add(element)
    return destination
}

/**
 * Appends all elements that are instances of specified class to the given *destination*
 */
public fun <C : MutableCollection<in R>, R> Array<*>.filterIsInstanceTo(destination: C, klass: Class<R>): C {
    for (element in this) if (klass.isInstance(element)) destination.add(element as R)
    return destination
}

/**
 * Appends all elements that are instances of specified class to the given *destination*
 */
public fun <C : MutableCollection<in R>, R> Iterable<*>.filterIsInstanceTo(destination: C, klass: Class<R>): C {
    for (element in this) if (klass.isInstance(element)) destination.add(element as R)
    return destination
}

/**
 * Appends all elements that are instances of specified class to the given *destination*
 */
public fun <C : MutableCollection<in R>, R> Sequence<*>.filterIsInstanceTo(destination: C, klass: Class<R>): C {
    for (element in this) if (klass.isInstance(element)) destination.add(element as R)
    return destination
}


deprecated("Migrate to using Sequence<T> and respective functions")
/**
 * Appends all elements that are instances of specified class to the given *destination*
 */
public fun <C : MutableCollection<in R>, R> Stream<*>.filterIsInstanceTo(destination: C, klass: Class<R>): C {
    for (element in this) if (klass.isInstance(element)) destination.add(element as R)
    return destination
}

/**
 * Sorts array or range in array inplace
 */
public fun <T> Array<out T>.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun ByteArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun CharArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun DoubleArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun FloatArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun IntArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun LongArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

/**
 * Sorts array or range in array inplace
 */
public fun ShortArray.sort(fromIndex: Int = 0, toIndex: Int = size()): Unit {
    Arrays.sort(this, fromIndex, toIndex)
}

