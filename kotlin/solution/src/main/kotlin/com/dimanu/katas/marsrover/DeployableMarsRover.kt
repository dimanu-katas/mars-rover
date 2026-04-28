package com.dimanu.katas.marsrover

class DeployableMarsRover : MarsRover {
    companion object {
        fun deploy(): DeployableMarsRover = DeployableMarsRover()
    }

    private var orientation = Orientation.NORTH
    private var coordinateX = 0
    private var coordinateY = 0

    override fun position(): String = "$coordinateX:$coordinateY:$orientation"

    override fun turnRight() {
        orientation = orientation.turnRight()
    }

    override fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    override fun moveForward() {
        coordinateX += 1
    }
}
