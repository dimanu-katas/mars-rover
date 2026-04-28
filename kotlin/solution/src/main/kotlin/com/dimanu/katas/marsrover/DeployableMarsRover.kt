package com.dimanu.katas.marsrover

class DeployableMarsRover : MarsRover {
    companion object {
        fun deploy(): DeployableMarsRover = DeployableMarsRover()
    }

    private var orientation = "N"

    override fun position(): String = "0:0:$orientation"

    override fun turnRight() {
        when (orientation) {
            "N" -> orientation = "E"
            "E" -> orientation = "S"
            "S" -> orientation = "W"
            "W" -> orientation = "N"
        }
    }

    override fun turnLeft() {
        TODO("Not yet implemented")
    }

    override fun moveForward() {
        TODO("Not yet implemented")
    }
}
