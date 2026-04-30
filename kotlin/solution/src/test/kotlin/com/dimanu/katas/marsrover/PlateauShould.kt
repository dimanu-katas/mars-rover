package com.dimanu.katas.marsrover

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals


class PlateauShould {

    @ParameterizedTest
    @MethodSource("plateauNextPositionTestData")
    fun `calculate next position for current position and orientation`(position: Position, orientation: Orientation, expectedPosition: Position) {
        val plateau = Plateau.withDefaultSize()

        val movedPosition = plateau.nextPositionFor(
            currentPosition = position,
            currentOrientation = orientation
        )

        assertEquals(expectedPosition, movedPosition)
    }

    companion object {
        private val INITIAL_POSITION = Position(0, 0)

        @JvmStatic
        fun plateauNextPositionTestData(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(INITIAL_POSITION, Orientation.NORTH, Position(1,0)),
                Arguments.of(INITIAL_POSITION, Orientation.EAST, Position(0,1)),
                Arguments.of(Position(1,0), Orientation.SOUTH, INITIAL_POSITION),
                Arguments.of(Position(0,1), Orientation.WEST, INITIAL_POSITION),
            )
        }
    }

    }