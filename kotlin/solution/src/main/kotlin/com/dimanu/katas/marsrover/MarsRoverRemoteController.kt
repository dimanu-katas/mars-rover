package com.dimanu.katas.marsrover

class MarsRoverRemoteController(private val marsRover: MarsRover) {
    fun execute(commandSequence: String): String {
        val command = CommandFactory.create(commandSequence, marsRover)
        command.execute()
        return marsRover.position()
    }

}
