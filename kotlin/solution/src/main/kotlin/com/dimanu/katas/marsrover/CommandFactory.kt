package com.dimanu.katas.marsrover

class CommandFactory {
    companion object {
        fun create(command: String, marsRover: MarsRover): Command {
            return when (command) {
                "R" -> TurnRightCommand(marsRover)
                "L" -> TurnLeftCommand(marsRover)
                else -> NoCommand(marsRover)
            }
        }
    }
}
