package com.dimanu.katas.marsrover

class Plateau(private val width: Int, private val height: Int) {
    companion object {
        fun withDefaultSize(): Plateau = Plateau(width = 10, height = 10)
    }

    fun nextPositionFor(currentPosition: Position, currentOrientation: Orientation): Position {
        val movedPosition = when (currentOrientation) {
            Orientation.NORTH -> currentPosition.up()
            Orientation.EAST -> currentPosition.right()
            Orientation.SOUTH -> currentPosition.down()
            Orientation.WEST -> currentPosition.left()
        }
        return wrapOnEdge(movedPosition)
    }

    private fun wrapOnEdge(position: Position): Position {
        val x = if (position.x >= width) 0 else if (position.x < 0) width - 1 else position.x
        val y = if (position.y >= height) 0 else if (position.y < 0) height -1 else position.y
        return Position(x, y)
    }
}