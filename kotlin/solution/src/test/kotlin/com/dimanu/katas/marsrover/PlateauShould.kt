package com.dimanu.katas.marsrover

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PlateauShould {

    @ParameterizedTest
    @MethodSource("defaultSizePlateauNextPositionTestData")
    @MethodSource("defaultSizePlateauWrapPositionTestData")
    fun `calculate next position for current position and orientation`(position: Position, orientation: Orientation, expectedPosition: Position) {
        val plateau = Plateau.withDefaultSize()

        val movedPosition = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation,
        )

        assertEquals(expectedPosition, movedPosition)
    }

    @ParameterizedTest
    @MethodSource("notDefaultSizePlateauWrapPositionTestData")
    fun `wrap around when edge is reached on a plateau without default size`(position: Position, orientation: Orientation, expectedPosition: Position) {
        val plateau = Plateau(width = NOT_DEFAULT_SIZE, height = NOT_DEFAULT_SIZE)

        val movedPosition = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation,
        )

        assertEquals(expectedPosition, movedPosition)
    }

    @Test
    fun `detect when there is an obstacle`(){
        val plateau = Plateau.withDefaultSize(obstacles = arrayOf(Position(0, 1)))

        assertTrue { plateau.hasObstacleAt(Position(0, 1)) }
    }

    companion object {
        private val INITIAL_POSITION = Position(0, 0)
        private const val DEFAULT_SIZE = 10
        private const val NOT_DEFAULT_SIZE = 6

        @JvmStatic
        fun defaultSizePlateauNextPositionTestData(): Stream<Arguments> = Stream.of(
            Arguments.of(INITIAL_POSITION, Orientation.NORTH, Position(0, 1)),
            Arguments.of(INITIAL_POSITION, Orientation.EAST, Position(1, 0)),
            Arguments.of(Position(0, 1), Orientation.SOUTH, INITIAL_POSITION),
            Arguments.of(Position(1, 0), Orientation.WEST, INITIAL_POSITION),
        )

        @JvmStatic
        fun defaultSizePlateauWrapPositionTestData(): Stream<Arguments> = Stream.of(
            Arguments.of(Position(0, DEFAULT_SIZE - 1), Orientation.NORTH, INITIAL_POSITION),
            Arguments.of(Position(DEFAULT_SIZE - 1, 0), Orientation.EAST, INITIAL_POSITION),
            Arguments.of(INITIAL_POSITION, Orientation.SOUTH, Position(0, DEFAULT_SIZE - 1)),
            Arguments.of(INITIAL_POSITION, Orientation.WEST, Position(DEFAULT_SIZE - 1, 0)),
        )

        @JvmStatic
        fun notDefaultSizePlateauWrapPositionTestData(): Stream<Arguments> = Stream.of(
            Arguments.of(Position(0, NOT_DEFAULT_SIZE - 1), Orientation.NORTH, INITIAL_POSITION),
            Arguments.of(Position(NOT_DEFAULT_SIZE - 1, 0), Orientation.EAST, INITIAL_POSITION),
            Arguments.of(INITIAL_POSITION, Orientation.SOUTH, Position(0, NOT_DEFAULT_SIZE - 1)),
            Arguments.of(INITIAL_POSITION, Orientation.WEST, Position(NOT_DEFAULT_SIZE - 1, 0)),
        )
    }
}
