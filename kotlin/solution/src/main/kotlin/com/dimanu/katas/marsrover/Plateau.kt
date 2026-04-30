package com.dimanu.katas.marsrover

class Plateau(private val width: Int, private val height: Int) {
    companion object {
        fun withDefaultSize(): Plateau = Plateau(width = 10, height = 10)
    }

    fun nextPositionFor(currentPosition: Position, currentOrientation: Orientation): Position {
        return when (currentOrientation) {
            Orientation.NORTH -> currentPosition.up()
            Orientation.EAST -> currentPosition.right()
            Orientation.SOUTH -> currentPosition.down()
            Orientation.WEST -> currentPosition.left()
        }
    }
}