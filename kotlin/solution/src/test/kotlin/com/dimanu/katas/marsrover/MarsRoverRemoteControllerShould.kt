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
        private const val MOVE_FORWARD_ONCE = "M"
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

    @ParameterizedTest(name = "{0} turn -> {1}")
    @CsvSource(
        "R, 0:0:E",
                "RR, 0:0:S",
                "RRR, 0:0:W",
                "RRRR, 0:0:N",
    )
    fun `turn right`(commandSequence: String, expectedPosition: String) {
        val position = remoteController.execute(commandSequence)

        assertEquals(expectedPosition, position)
    }

    @ParameterizedTest(name = "{0} turn -> {1}")
    @CsvSource(
        "L, 0:0:W",
        "LL, 0:0:S",
        "LLL, 0:0:E",
        "LLLL, 0:0:N",
    )
    fun `turn left`(commandSequence: String, expectedPosition: String) {
        val position = remoteController.execute(commandSequence)

        assertEquals(expectedPosition, position)
    }

    @Test
    fun `move forward one step`() {
        val position = remoteController.execute(MOVE_FORWARD_ONCE)

        assertEquals("1:0:N", position)
    }

    @Test
    fun `execute a sequence of commands`() {
        val position = remoteController.execute("RM")

        assertEquals("1:0:E", position)
    }

    @Test
    fun `not allow to execute invalid commands`() {
        assertFailsWith<InvalidMarsRoverCommand> { remoteController.execute("X") }
    }
}
