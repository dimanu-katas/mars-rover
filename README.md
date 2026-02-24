# :robot: Mars Rover Kata :robot:

## Resources

These instructions where extracted from Codurance Kata Catalogue. You can find the original instructions in the links below.

[![Web](https://img.shields.io/badge/Codurance-Simple_Mars_Rover-14a1f0?style=for-the-badge&logo=web&logoColor=white&labelColor=101010)](https://www.codurance.com/katas/simple-mars-rover)
[![Web](https://img.shields.io/badge/Codurance-Mars_Rover-14a1f0?style=for-the-badge&logo=web&logoColor=white&labelColor=101010)](https://www.codurance.com/katas/mars-rover)

## Description Simple Mars Rover

A squad of robotic rovers are to be landed by NASA on a plateau on Mars.

This plateau, which is curiously rectangular, must be navigated by the rovers so that their onboard cameras can get a complete view
of the surrounding terrain to send back to Earth.

Your task is to develop an API that moves the rovers around on the plateau.

In this API, the plateau is represented as a 10x10 grid, and a rover has state consisting of two parts:

- The position on the grid (represented by an X,Y coordinate pair)
- The direction the compass is facing (represented by a letter, one of  'N', 'S', 'E', 'W')
- The starting position of the rover is '0:0:N'

### Input

The input to the program is a string of one-character move commands:

- 'L' and 'R' rotate the direction the rover is facing
- 'M' moves the rover one grid point forward in the direction it is currently facing

If a rover reaches the end of the plateau, it wraps around the end of the grid.

### Output

The program should output the final position of the rover after all the move commands have been executed.

The position is represented as a coordinate pair and a direction, joined by colons, with the direction letters in uppercase. For example:
a rover whose position is `2:3:W` is at square (2,3), facing west.

### Example

The input string `MMRMMLM` for the rover starting at `0:0:N` will output `2:3:N`.

Given an input `MMMMMMMMMM` for the rover starting at `0:0:N` will output `0:0:N` due to wrap-around.

## Rules

To complete the full version of the kata you need to follow the following rules and implement the needed features:
- The rover receives a char array of commands and returns the finishing point after the moves.
- The rover wraps around if it reached the end of the grid.
- The plateau is represented as a grid with dimensions X and Y
- The rover can move in a grid of any size
- The grid may have obstacles. In these cases, the rover should stop and report the position where it stopped by prefixing O: to the
  position. For example, if the rover finds an obstacle at 0:3:N, it should report O:0:2:N

## Objective

The objective of this kata is:
- Practice TDD baby steps / Practice outside-in TDD
- Apply object calisthenics
- Improve OOP skills

## Visit my GitHub profile to see all solved katas 🚀

[![Web](https://img.shields.io/badge/GitHub-Dimanu.py-14a1f0?style=for-the-badge&logo=github&logoColor=white&labelColor=101010)](https://github.com/orgs/dimanu-katas/repositories)