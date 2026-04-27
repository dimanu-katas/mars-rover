package com.dimanu.katas.marsrover

class DeployableMarsRover : MarsRover {
    companion object {
        fun deploy(): DeployableMarsRover = DeployableMarsRover()
    }

    private var orientation = "N"

    override fun position(): String = "0:0:$orientation"

    override fun turnRight() {
        if (orientation == "N") {
            orientation = "E"
        }
    }

    override fun turnLeft() {
        TODO("Not yet implemented")
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }
}
