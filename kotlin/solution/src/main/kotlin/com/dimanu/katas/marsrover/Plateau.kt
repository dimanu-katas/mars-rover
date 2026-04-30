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
        val x = Math.floorMod(position.x, width)
        val y = Math.floorMod(position.y, height)
        return Position(x, y)
    }
}