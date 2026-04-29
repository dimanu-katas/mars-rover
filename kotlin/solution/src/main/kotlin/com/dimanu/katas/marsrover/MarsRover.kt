package com.dimanu.katas.marsrover

class MarsRover {
    companion object {
        fun deploy(): MarsRover = MarsRover()
    }

    private var orientation = Orientation.NORTH
    private var coordinateX = 0
    private var coordinateY = 0

    fun position(): String = "$coordinateX:$coordinateY:$orientation"

    fun turnRight() {
        orientation = orientation.turnRight()
    }

    fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    fun moveForward() {
        if (orientation == Orientation.NORTH) {
            coordinateX += 1
        }
        else if (orientation == Orientation.EAST) {
            coordinateY += 1
        }
    }
}
