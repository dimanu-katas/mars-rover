package com.dimanu.katas.marsrover

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
