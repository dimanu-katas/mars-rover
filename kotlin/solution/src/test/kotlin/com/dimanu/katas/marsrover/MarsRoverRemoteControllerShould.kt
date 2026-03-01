package com.dimanu.katas.marsrover
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkClass
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverRemoteControllerShould {
    companion object {
        private const val NO_COMMAND = ""
        private const val INITIAL_POSITION = "0:0:N"
    }

    private lateinit var marsRover: MarsRover
    private lateinit var remoteController: MarsRoverRemoteController

    @BeforeEach
    fun setUp() {
        marsRover = mockk<MarsRover>(relaxUnitFun = true)
        remoteController = MarsRoverRemoteController(marsRover)
    }

    @Test
    fun `not move mars rover if no command is introduced`() {
        every { marsRover.position() } returns INITIAL_POSITION

        val position = remoteController.execute(NO_COMMAND)

        assertEquals(INITIAL_POSITION, position)
        verify { marsRover.doNothing() }
    }
}
