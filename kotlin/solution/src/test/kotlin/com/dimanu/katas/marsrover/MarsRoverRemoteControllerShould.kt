package com.dimanu.katas.marsrover
import io.mockk.mockk
import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverRemoteControllerShould {
    companion object {
        private const val NO_COMMAND = ""
    }

    @Test
    fun `not move mars rover if no command is introduced`() {
        val marsRover = mockk<MarsRover>()
        val remoteController = MarsRoverRemoteController(marsRover)

        val position = remoteController.execute(NO_COMMAND)

        assertEquals(position, "0:0:N")
    }
}
