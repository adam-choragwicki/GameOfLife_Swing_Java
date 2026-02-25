[![Tests](https://github.com/adam-choragwicki/GameOfLife_Swing_Java/actions/workflows/tests-workflow.yml/badge.svg)](https://github.com/adam-choragwicki/GameOfLife_Swing_Java/actions/workflows/tests-workflow.yml)

# Game of life

Java implementation of the John Conway's Game of Life using:
* OpenJDK 25
* Java Swing library
* Maven 3.9.11

![](screenshot1.jpg)

![](screenshot2.jpg)

**Executable JAR is provided.**

### Wikipedia article about the game and its rules:
https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life

### Features:
* Universe size ranges 25–100
* Pausing/Resetting evolution
* Generating a new universe (based on new seed)
* Modifiable speed of evolution
* Finite grid with dead boundaries (no wrap-around)

Internally, it is implemented using Model-View-Controller architecture.

# Tests
Unit tested using JUnit 5.9.0

# How to run
#### Prerequisites:
* Java 8 or higher

1. Download the latest release zip from:\
https://github.com/adam-choragwicki/GameOfLife_Swing_Java/releases/latest/download/GameOfLife_Swing_Java.jar

2. Run `java -jar GameOfLife_Swing_Java.jar`
