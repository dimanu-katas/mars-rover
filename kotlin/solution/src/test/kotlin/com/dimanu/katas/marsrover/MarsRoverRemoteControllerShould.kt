package com.dimanu.katas.marsrover
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MarsRoverRemoteControllerShould {
    companion object {
        private const val NO_COMMAND = ""
        private const val INITIAL_POSITION = "0:0:N"
    }

    private lateinit var marsRover: MarsRover
    private lateinit var remoteController: MarsRoverRemoteController

    @BeforeEach
    fun setUp() {
        marsRover = MarsRover.deploy()
        remoteController = MarsRoverRemoteController(marsRover)
    }

    @Test
    fun `stay at deployed position if no command is introduced`() {
        val position = remoteController.execute(NO_COMMAND)

        assertEquals(INITIAL_POSITION, position)
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(
        "R, 0:0:E",
        "RR, 0:0:S",
        "RRR, 0:0:W",
        "RRRR, 0:0:N",
    )
    fun `turn right`(rightTurns: String, expectedPosition: String) {
        val position = remoteController.execute(rightTurns)

        assertEquals(expectedPosition, position)
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",
        "LLLL, 0:0:N",
    )
    fun `turn left`(leftTurns: String, expectedPosition: String) {
        val position = remoteController.execute(leftTurns)

        assertEquals(expectedPosition, position)
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @CsvSource(
        "M, 1:0:N",
        "MM, 2:0:N",
        "RM, 0:1:E",
        "MMMRRM, 2:0:S",
        "RMMMLLM, 0:2:W",
    )
    fun `move forward in all directions`(stepsForward: String, expectedPosition: String) {
        val position = remoteController.execute(stepsForward)

        assertEquals(expectedPosition, position)
    }

    @Test
    fun `not allow to execute invalid commands`() {
        assertFailsWith<InvalidMarsRoverCommand> { remoteController.execute("X") }
    }
}
