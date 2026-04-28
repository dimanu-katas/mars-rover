package com.dimanu.katas.marsrover

enum class Orientation(private var value: String) {
    NORTH(value = "N"),
    EAST(value = "E"),
    SOUTH(value = "S"),
    WEST(value = "W"),
    ;

    fun turnRight(): Orientation = when (this) {
        NORTH -> EAST
        EAST -> SOUTH
        SOUTH -> WEST
        WEST -> NORTH
    }

    fun turnLeft(): Orientation = when (this) {
        NORTH -> WEST
        EAST -> NORTH
        SOUTH -> EAST
        WEST -> SOUTH
    }

    override fun toString(): String = value
}
