package com.dimanu.katas.marsrover

import kotlin.test.Test
import kotlin.test.assertEquals


class DeployableMarsRoverShould {

    @Test
    fun `be deployed on initial position`() {
        val marsRover = DeployableMarsRover.deploy()

        assertEquals("0:0:N", marsRover.position())
    }
}
