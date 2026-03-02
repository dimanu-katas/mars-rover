package com.dimanu.katas.marsrover

class DeployableMarsRover: MarsRover {
    companion object {
        fun deploy(): DeployableMarsRover {
            return DeployableMarsRover()
        }
    }

    override fun position(): String {
        return "0:0:N"
    }

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