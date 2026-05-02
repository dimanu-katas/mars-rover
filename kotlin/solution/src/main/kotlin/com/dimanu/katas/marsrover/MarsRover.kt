package com.dimanu.katas.marsrover

class MarsRover private constructor(private val plateau: Plateau) {
    companion object {
        fun deployAtDefaultPlateau(): MarsRover = MarsRover(plateau = Plateau.withDefaultSize())
        fun deployAt(plateau: Plateau): MarsRover = MarsRover(plateau = plateau)
    }

    private var orientation: Orientation = Orientation.NORTH
    private var position: Position = Position(0, 0)
    private var hasEncounteredAnObstacle: Boolean = false

    fun position(): String = if (hasEncounteredAnObstacle) "O:$position:$orientation" else "$position:$orientation"

    fun turnRight() {
        orientation = orientation.turnRight()
    }

    fun turnLeft() {
        orientation = orientation.turnLeft()
    }

    fun moveForward() {
        val nextPosition = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation,
        )

        if (plateau.hasObstacleAt(nextPosition)) {
            hasEncounteredAnObstacle = true
            return
        }

        position = nextPosition
    }
}
