package com.dimanu.katas.marsrover

class CommandFactory {
    companion object {
        fun create(command: String, marsRover: MarsRover): NoCommand {
            return NoCommand(marsRover)
        }
    }
}
