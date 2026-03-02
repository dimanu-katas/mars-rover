package com.dimanu.katas.marsrover

class DeployableMarsRover : MarsRover {
    companion object {
        fun deploy(): DeployableMarsRover = DeployableMarsRover()
    }

    override fun position(): String = "0:0:N"

    override fun turnRight() {
        TODO("Not yet implemented")
    }

    override fun turnLeft() {
        TODO("Not yet implemented")
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }
}
