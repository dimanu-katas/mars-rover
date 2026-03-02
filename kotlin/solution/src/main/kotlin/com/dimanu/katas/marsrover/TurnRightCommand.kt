package com.dimanu.katas.marsrover

class TurnRightCommand(private val marsRover: MarsRover): Command {
    override fun execute() {
        marsRover.turnRight()
    }
}
