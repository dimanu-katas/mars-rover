package com.dimanu.katas.marsrover

interface MarsRover {
    fun position(): String
    fun doNothing() = Unit
    fun turnRight()
}
