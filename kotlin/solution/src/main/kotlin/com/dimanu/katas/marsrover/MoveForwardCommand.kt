package com.dimanu.katas.marsrover

class MoveForwardCommand(private val marsRover: MarsRover): Command {
    override fun execute() {
        marsRover.moveForward()
    }
}
