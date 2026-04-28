package com.dimanu.katas.marsrover
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MarsRoverRemoteControllerShould {
    companion object {
        private const val NO_COMMAND = ""
        private const val TURN_RIGHT_ONCE = "R"
        private const val TURN_LEFT_ONCE = "L"
        private const val MOVE_FORWARD_ONCE = "M"
        private const val INITIAL_POSITION = "0:0:N"
    }

    private lateinit var marsRover: MarsRover
    private lateinit var remoteController: MarsRoverRemoteController

    @BeforeEach
    fun setUp() {
        marsRover = DeployableMarsRover.deploy()
        remoteController = MarsRoverRemoteController(marsRover)
    }

    @Test
    fun `stay at deployed position if no command is introduced`() {
        val position = remoteController.execute(NO_COMMAND)

        assertEquals(INITIAL_POSITION, position)
    }

    @Test
    fun `turn right once when R command is introduced`() {
        val position = remoteController.execute(TURN_RIGHT_ONCE)

        assertEquals("0:0:E", position)
    }

    @Test
    fun `turn left once when L command is introduced`() {
        val position = remoteController.execute(TURN_LEFT_ONCE)

        assertEquals("0:0:W", position)
    }

    @Test
    fun `move forward one step when M command is introduced`() {
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
