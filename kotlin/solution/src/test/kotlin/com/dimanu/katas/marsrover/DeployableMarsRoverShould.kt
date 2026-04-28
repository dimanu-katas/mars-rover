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

    companion object {
        @JvmStatic
        fun turnRightCommands(): Stream<Arguments> = Stream.of(
            Arguments.of(1, "0:0:E"),
        )
    }
}
