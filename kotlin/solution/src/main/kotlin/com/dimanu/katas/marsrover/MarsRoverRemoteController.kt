package com.dimanu.katas.marsrover

class MarsRoverRemoteController(private val marsRover: MarsRover) {
    fun execute(commandSequence: String): String {
        commandSequence.forEach {
            val command = CommandFactory.create(it.toString(), marsRover)
            command.execute()
        }
        return marsRover.position()
    }
}
