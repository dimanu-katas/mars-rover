package com.dimanu.katas.marsrover

class MarsRover {
    companion object {
        fun deploy(): MarsRover = MarsRover()
    }

    private var orientation = Orientation.NORTH
    private var position = Position(0, 0)

    fun position(): String = "$position:$orientation"

    fun turnRight() {
        orientation = orientation.turnRight()
    }

    fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    fun moveForward() {
        position = when (orientation) {
            Orientation.NORTH -> position.up()
            Orientation.EAST -> position.right()
            Orientation.SOUTH -> position.down()
            Orientation.WEST -> position.left()
        }
    }
}
