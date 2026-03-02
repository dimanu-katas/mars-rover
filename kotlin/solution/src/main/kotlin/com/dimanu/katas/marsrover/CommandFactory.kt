package com.dimanu.katas.marsrover

class CommandFactory {
    companion object {
        fun create(command: Char, marsRover: MarsRover): Command {
            return when (command) {
                'R' -> TurnRightCommand(marsRover)
                else -> NoCommand(marsRover)
            }
        }
    }
}
