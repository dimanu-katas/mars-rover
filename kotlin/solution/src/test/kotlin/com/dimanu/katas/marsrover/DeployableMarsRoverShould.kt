package com.dimanu.katas.marsrover

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals

class DeployableMarsRoverShould {

    @Test
    fun `be deployed on initial position`() {
        val marsRover = DeployableMarsRover.deploy()

        assertEquals("0:0:N", marsRover.position())
    }

    @ParameterizedTest(name = "{0} turn -> {1}")
    @MethodSource("turnRightCommands")
    fun `turn right`(numberOfRightTurns: Int, expectedPosition: String) {
        val marsRover = DeployableMarsRover.deploy()

        repeat(numberOfRightTurns) {
            marsRover.turnRight()
        }

        assertEquals(expectedPosition, marsRover.position())
    }

    @ParameterizedTest(name = "{0} turn -> {1}")
    @MethodSource("turnLeftCommands")
    fun `turn left`(numberOfLeftTurns: Int, expectedPosition: String) {
        val marsRover = DeployableMarsRover.deploy()

        repeat(numberOfLeftTurns) {
            marsRover.turnLeft()
        }

        assertEquals(expectedPosition, marsRover.position())
    }

    @Test
    fun `move forward`() {
        val marsRover = DeployableMarsRover.deploy()

        marsRover.moveForward()

        assertEquals("1:0:N", marsRover.position())
    }

    companion object {
        @JvmStatic
        fun turnRightCommands(): Stream<Arguments> = Stream.of(
            Arguments.of(1, "0:0:E"),
            Arguments.of(2, "0:0:S"),
            Arguments.of(3, "0:0:W"),
            Arguments.of(4, "0:0:N"),
            Arguments.of(5, "0:0:E"),
        )

        @JvmStatic
        fun turnLeftCommands(): Stream<Arguments> = Stream.of(
            Arguments.of(1, "0:0:W"),
            Arguments.of(2, "0:0:S"),
            Arguments.of(3, "0:0:E"),
            Arguments.of(4, "0:0:N"),
            Arguments.of(5, "0:0:W"),
        )
    }
}
