package com.dimanu.katas.marsrover

class TurnLeftCommand(private val marsRover: MarsRover) : Command {
    override fun execute() {
        marsRover.turnLeft()
    }
}
