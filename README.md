# LeanIX Dev Conference 12/2018 Coding Challenge
## The game
Your task is to implement a working version of Tic-Tac-Toe (https://en.wikipedia.org/wiki/Tic-tac-toe).

### Basic Requirements
- The user shall interact with the game via keyboard input.
- The state of the game shall be displayed via console output.
- The starting player (Player one) or (Player two) shall be determined randomaly.
- Player one plays 'x', player two plays 'o'.
- The program shall not accept invalid moves.
- The program shall determine when a game has finished.
- The program shall print out the winning player.
- The coordinate system of the board is defined as follows:
```
2 | |
 -+-+-
1 | |
 -+-+-
0 | |
 A B C
```
- The user shall be able to pass via command line if a player is played by a human or by a computer. Example: `-p1 human -p2 cpu`

### Example session
```
Welcome to Tic-Tac-Toe!
Player 2 starts

 | |
-+-+-
 | |
-+-+-
 | |

Player 2>a1

 | |
-+-+-
o| |
-+-+-
 | |

Player 1>a1
Invalid move, try again

Player 1>b1

 | |
-+-+-
o|x|
-+-+-
 | |

Player 2>a0

 | |
-+-+-
o|x|
-+-+-
o| |

Player 1>d4
Invalid move, try again

Player 1>b1

 | |
-+-+-
o|x|
-+-+-
o|x|

Player 2>a2

o| |
-+-+-
o|x|
-+-+-
o|x|

Player 2 has won.
Thanks for playing.
```
