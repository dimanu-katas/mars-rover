package com.dimanu.katas.marsrover

class Plateau(
    private val width: Int,
    private val height: Int,
    private val obstacles: Array<Position> = emptyArray(),
) {
    companion object {
        fun withDefaultSize(obstacles: Array<Position> = emptyArray()): Plateau = Plateau(width = 10, height = 10, obstacles = obstacles)
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
