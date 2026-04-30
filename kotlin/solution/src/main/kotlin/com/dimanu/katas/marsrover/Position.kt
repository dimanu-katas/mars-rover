package com.dimanu.katas.marsrover

class Position(val x: Int, val y: Int) {
    companion object {
        private const val STEP_SIZE = 1
    }

    fun up(): Position = Position(x = x + STEP_SIZE, y = y)
    fun right(): Position = Position(x = x, y = y + STEP_SIZE)
    fun down(): Position = Position(x = x - STEP_SIZE, y = y)
    fun left(): Position = Position(x = x, y = y - STEP_SIZE)

    override fun toString(): String = "$x:$y"

    override fun equals(other: Any?): Boolean = other is Position && other.x == x && other.y == y

    override fun hashCode(): Int = 31 * x + y
}
