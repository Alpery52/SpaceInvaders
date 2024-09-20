# Space Invaders (Java)

This is a simple implementation of the classic *Space Invaders* game, developed in Java. The project was created as part of a semester assignment in the course INF101 at the University of Bergen (UiB).

[Watch the demo video here](https://youtu.be/zwQhq_awJ3Y)

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [How to Play](#how-to-play)
- [How to Run](#how-to-run)
- [Technologies Used](#technologies-used)

## Project Overview
This project is a basic recreation of the famous *Space Invaders* arcade game. The game follows the Model-View-Controller (MVC) design pattern to separate logic, interface, and control flow. Additionally, the game plays background music to enhance the gaming experience.

## Features
- **MVC architecture**: The project follows the MVC (Model-View-Controller) design principle to ensure clean separation of concerns.
- **Player controls**: Move left and right using the keyboard arrows and shoot enemies by pressing the spacebar.
- **Enemies**: Rows of enemies move across the screen and descend as the player attempts to shoot them.
- **Collision detection**: Player bullets hit enemies, and enemies can fire back at the player.
- **Background music**: Music plays during gameplay using MIDI files.
- **Game Over and Victory conditions**: The game ends when the player either defeats all enemies or gets hit by them.

## Project Structure
The project is organized into several packages, each responsible for different aspects of the game:

 ```bash
   
├── Controller/        # Handles game logic and controls
├── Entities/          # Contains game objects like the player, enemies, and bullets
├── Model/             # Manages the state of the game (game data, player, enemies, etc.)
├── View/              # Renders the game's visual components (UI)
├── Ressurser/         # Contains resources like images or audio files
├── midi/              # MIDI files for background music
└── SpaceInvadersMain.java   # Main class to run the game
```


### Explanation of Main Components:
- **Controller**: The logic that controls the game flow, including player movement, enemy behavior, and collisions.
- **Entities**: Objects in the game such as the spaceship, bullets, and enemies.
- **Model**: Handles the internal state of the game, including keeping track of the score and the game status.
- **View**: Manages the visual presentation of the game, rendering graphics on the screen.
- **Ressurser**: Stores images, audio files, and other static resources.
- **midi**: This folder contains background music for the game, which enhances the player experience.

## How to Play
1. **Move**: Use the **left** and **right arrow keys** to move your spaceship.
2. **Shoot**: Press the **spacebar** to shoot at the enemies.
3. **Objective**: Destroy all enemies before they reach the bottom of the screen or shoot you.
4. **Avoid**: Don’t get hit by enemy projectiles!

## How to Run
1. Ensure you have **Java 8** or higher installed on your system.
2. Clone this repository:
   ```bash
   git clone https://github.com/username/space-invaders.git

Navigate to the project directory:
cd space-invaders

Compile the Java files:
javac SpaceInvadersMain.java

Run the game:
java SpaceInvadersMain


Technologies Used
Java: The core language used for building the game.
MVC Architecture: The game is designed using the Model-View-Controller pattern.
MIDI: Used to play background music during gameplay.

