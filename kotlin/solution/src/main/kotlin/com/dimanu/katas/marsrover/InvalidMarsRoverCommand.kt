package com.dimanu.katas.marsrover

class InvalidMarsRoverCommand(val command: String) : RuntimeException("Mars Rover cannot execute command: $command")

