# Pebbles

A project by DLUO ET MATJONES

A multithreaded Java simulation of a pebble game, in which player threads draw from and discard to shared bags until one player's hand weighs exactly 100.

## Overview

This is pair coursework from the University of Exeter, written in October 2015 by Matthew Jones and Dennis Luo. Source files credit the authors by candidate number. The user enters the number of players and three files of pebble weights, and the game runs each player on its own thread. Every player logs its moves to a file.

## How the game works

- There are three bag pairs, each with a black bag and a white bag. Each black bag starts with the weights from one input file. Each white bag starts empty.
- Each player draws 10 pebbles, one at a time, from randomly chosen black bags.
- A player whose hand sums to exactly 100 wins. Otherwise, each turn the player discards a random pebble from their hand into the white bag paired with the black bag they last drew from. They then draw a new pebble from a random black bag.
- When a black bag runs empty, the contents of its white bag are moved back into it.
- The first player to reach a total of 100 is declared the winner, and the game ends for every player.

## Features

- One thread per player, run on a fixed thread pool (`ExecutorService`). Bag operations are `synchronized`.
- Interactive input with validation:
  - The number of players must be a positive integer.
  - Each weights file must exist and contain only integers.
  - Each file needs at least 11 pebbles per player, or `InsufficientNumberOfPebblesException` is raised.
  - Weights must be positive, or `NegativePebbleWeightException` is raised.
  - Entering `X` at any prompt exits.
- A per-player log, `player<n>output.txt`, records every draw, every discard, the hand after each move and the winner.

## Tech stack

- Java. The Eclipse project targets Java SE 1.6.
- Standard library only.
- An Eclipse project (`.project`, `.classpath`) is included. There is no Maven or Gradle build.

## Getting started

### Build

From the repository root:

```
javac -d bin src/pebbles/*.java
```

The repository also commits compiled classes in `bin/pebbles/`. You can import it into Eclipse as an existing project instead; its sources are in `src` and its output goes to `bin`.

### Run

```
java -cp bin pebbles.PebbleGame
```

The program prompts for the number of players and then the paths of three weight files:

```
Welcome to Pebble Game!
Number of players? 3
Please enter the path for csv file 1: example.csv
Please enter the path for csv file 2: example.csv
Please enter the path for csv file 3: example2.csv
```

Each move is printed to the console and written to `player<n>output.txt` in the working directory.

### Input format

Weight files list one integer per line. A trailing comma on each line is allowed:

```
1,
2,
3,
```

`example.csv` contains the weights 1 to 100, and `example2.csv` contains 35 pebbles, each weighing 9 or 10.

## Project structure

```
src/pebbles/
  PebbleGame.java                         Entry point, input prompts, game set-up; nested Player thread class
  BagPair.java                            A black/white bag pair: draw, discard and refill operations
  Bag.java, BlackBag.java, WhiteBag.java  Bag types holding pebble weights
  InputUtil.java                          Loads and validates a weights file
  InsufficientNumberOfPebblesException.java
  NegativePebbleWeightException.java
bin/pebbles/                              Committed compiled classes
example.csv, example2.csv                 Sample weight files
player1output.txt ... player9output.txt   Logs from a sample run with nine players
LICENSE                                   MIT licence
```

## Limitations

- At the weights warning, answering `Y` to "Continue anyway?" accepts the file, but the bag is never loaded, so the game cannot start correctly.
- The validation rejects zero weights as well as negative ones.
- Hand sizes are checked with `assert`, which only runs when the JVM is started with `-ea`.

## Licence

MIT. See [LICENSE](LICENSE).

## Acknowledgements

Written by Matthew Jones and Dennis Luo as coursework at the University of Exeter.
