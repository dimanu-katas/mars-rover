package com.dimanu.katas.marsrover

interface Command {
    fun execute()
}

class MoveForwardCommand(private val marsRover: MarsRover) : Command {
    override fun execute() {
        marsRover.moveForward()
    }
}

class TurnLeftCommand(private val marsRover: MarsRover) : Command {
    override fun execute() {
        marsRover.turnLeft()
    }
}

class TurnRightCommand(private val marsRover: MarsRover) : Command {
    override fun execute() {
        marsRover.turnRight()
    }
}

class CommandFactory {
    companion object {
        fun create(command: String, marsRover: MarsRover): Command = when (command) {
            "R" -> TurnRightCommand(marsRover)
            "L" -> TurnLeftCommand(marsRover)
            "M" -> MoveForwardCommand(marsRover)
            else -> throw InvalidMarsRoverCommand(command)
        }
    }
}

class InvalidMarsRoverCommand(command: String) : RuntimeException("Mars Rover cannot execute command: $command")
