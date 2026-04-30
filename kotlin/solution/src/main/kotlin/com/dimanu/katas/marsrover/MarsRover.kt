package com.dimanu.katas.marsrover

class MarsRover(private val plateau: Plateau) {
    companion object {
        fun deployAtDefaultGrid(): MarsRover = MarsRover(plateau = Plateau.withDefaultSize())
    }

    private var orientation = Orientation.NORTH
    private var position = Position(0, 0)

    fun position(): String = "$position:$orientation"

    fun turnRight() {
        orientation = orientation.turnRight()
    }

    fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    fun moveForward() {
        position = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation
        )
    }
}
