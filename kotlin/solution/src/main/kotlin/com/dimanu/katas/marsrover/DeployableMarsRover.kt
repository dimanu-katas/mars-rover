package com.dimanu.katas.marsrover

class DeployableMarsRover : MarsRover {
    companion object {
        fun deploy(): DeployableMarsRover = DeployableMarsRover()
    }

    private var orientation = Orientation.NORTH

    override fun position(): String = "0:0:$orientation"

    override fun turnRight() {
        orientation = orientation.turnRight()
    }

    override fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }
}
