package com.dimanu.katas.marsrover
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MarsRoverRemoteControllerShould {
    companion object {
        private const val NO_COMMAND = ""
        private const val INITIAL_POSITION = "0:0:N"

        @JvmStatic
        fun turnRightCommands(): Stream<Arguments> = Stream.of(
            Arguments.of("R", "0:0:E"),
            Arguments.of("RR", "0:0:S"),
            Arguments.of("RRR", "0:0:W"),
            Arguments.of("RRRR", "0:0:N"),
        )

        @JvmStatic
        fun turnLeftCommands(): Stream<Arguments> = Stream.of(
            Arguments.of("L", "0:0:W"),
            Arguments.of("LL", "0:0:S"),
            Arguments.of("LLL", "0:0:E"),
            Arguments.of("LLLL", "0:0:N"),
        )

        @JvmStatic
        fun moveCommands(): Stream<Arguments> = Stream.of(
            Arguments.of("M", "0:1:N"),
            Arguments.of("MM", "0:2:N"),
            Arguments.of("RM", "1:0:E"),
            Arguments.of("MMMRRM", "0:2:S"),
        )
    }

    private lateinit var marsRover: MarsRover
    private lateinit var remoteController: MarsRoverRemoteController

    @BeforeEach
    fun setUp() {
        marsRover = MarsRover.deployAtDefaultPlateau()
        remoteController = MarsRoverRemoteController(marsRover)
    }

    @Test
    fun `stay at deployed position if no command is introduced`() {
        val position = remoteController.execute(NO_COMMAND)

        assertEquals(INITIAL_POSITION, position)
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("turnRightCommands")
    fun `turn right`(rightTurns: String, expectedPosition: String) {
        val position = remoteController.execute(rightTurns)

        assertEquals(expectedPosition, position)
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("turnLeftCommands")
    fun `turn left`(leftTurns: String, expectedPosition: String) {
        val position = remoteController.execute(leftTurns)

        assertEquals(expectedPosition, position)
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("moveCommands")
    fun `move forward in all directions`(stepsForward: String, expectedPosition: String) {
        val position = remoteController.execute(stepsForward)

        assertEquals(expectedPosition, position)
    }

    @Test
    fun `wrap around the plateau when reaches the edge`() {
        val position = remoteController.execute("MMMMMMMMMM")

        assertEquals("0:0:N", position)
    }

    @Test
    fun `not allow to execute invalid commands`() {
        assertFailsWith<InvalidMarsRoverCommand> { remoteController.execute("X") }
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("turnRightCommands")
    @MethodSource("turnLeftCommands")
    @MethodSource("moveCommands")
    fun `process command sequence in a plateau of any size`(commandSequence: String, expectedPosition: String) {
        val plateau = Plateau(width = 10, height = 10)
        val marsRoverRemoteController = MarsRoverRemoteController(marsRover = MarsRover.deployAt(plateau = plateau))

        val position = marsRoverRemoteController.execute(commandSequence)

        assertEquals(expectedPosition, position)
    }

    @Test
    fun `stop when finds an obstacle and cannot continue`(){
        val plateauWithObstacle = Plateau.withDefaultSize(obstacles = arrayOf(Position(0, 3)))
        val remoteController = MarsRoverRemoteController(marsRover = MarsRover.deployAt(plateau = plateauWithObstacle))

        val position = remoteController.execute("MMMM")

        assertEquals("O:0:2:N", position)
    }
}
