package com.dimanu.katas.marsrover

import kotlin.test.Test
import kotlin.test.assertEquals

class MarsRoverShould {

    @Test
    fun `return initial position`() {
        val rover = MarsRover()
        val result = rover.execute("")
        assertEquals("0:0:N", result)
    }
}
