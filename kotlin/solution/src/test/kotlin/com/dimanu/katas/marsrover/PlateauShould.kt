package com.dimanu.katas.marsrover

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals


class PlateauShould {

    @ParameterizedTest
    @MethodSource("defaultSizePlateauNextPositionTestData")
    @MethodSource("defaultSizePlateauWrapPositionTestData")
    fun `calculate next position for current position and orientation`(position: Position, orientation: Orientation, expectedPosition: Position) {
        val plateau = Plateau.withDefaultSize()

        val movedPosition = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation
        )

        assertEquals(expectedPosition, movedPosition)
    }

    @ParameterizedTest
    @MethodSource("notDefaultSizePlateauWrapPositionTestData")
    fun `wrap around when edge is reached on a plateau without default size`(position: Position, orientation: Orientation, expectedPosition: Position) {
        val plateau = Plateau(width = NOT_DEFAULT_SIZE, height = NOT_DEFAULT_SIZE)

        val movedPosition = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation
        )

        assertEquals(expectedPosition, movedPosition)
    }

    companion object {
        private val INITIAL_POSITION = Position(0, 0)
        private const val DEFAULT_SIZE = 10
        private const val NOT_DEFAULT_SIZE = 6

        @JvmStatic
        fun defaultSizePlateauNextPositionTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(INITIAL_POSITION, Orientation.NORTH, Position(1,0)),
                Arguments.of(INITIAL_POSITION, Orientation.EAST, Position(0,1)),
                Arguments.of(Position(1,0), Orientation.SOUTH, INITIAL_POSITION),
                Arguments.of(Position(0,1), Orientation.WEST, INITIAL_POSITION),
            )
        }

        @JvmStatic
        fun defaultSizePlateauWrapPositionTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Position(DEFAULT_SIZE - 1, 0), Orientation.NORTH, INITIAL_POSITION),
                Arguments.of(Position(0, DEFAULT_SIZE - 1), Orientation.EAST, INITIAL_POSITION),
                Arguments.of(INITIAL_POSITION, Orientation.SOUTH, Position(DEFAULT_SIZE - 1, 0)),
                Arguments.of(INITIAL_POSITION, Orientation.WEST, Position(0, DEFAULT_SIZE - 1)),
                )
        }

        @JvmStatic
        fun notDefaultSizePlateauWrapPositionTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(Position(NOT_DEFAULT_SIZE - 1, 0), Orientation.NORTH, INITIAL_POSITION),
                Arguments.of(Position(0, NOT_DEFAULT_SIZE - 1), Orientation.EAST, INITIAL_POSITION),
                Arguments.of(INITIAL_POSITION, Orientation.SOUTH, Position(NOT_DEFAULT_SIZE - 1, 0)),
                Arguments.of(INITIAL_POSITION, Orientation.WEST, Position(0, NOT_DEFAULT_SIZE - 1)),
            )
        }
    }
}