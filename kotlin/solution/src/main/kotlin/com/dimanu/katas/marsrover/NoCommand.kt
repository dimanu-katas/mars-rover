package com.dimanu.katas.marsrover

class NoCommand(private val marsRover: MarsRover): Command {
    override fun execute() {
        marsRover.doNothing()
    }

}
