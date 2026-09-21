## Ninja Adventure

A 2D top-down tile-based game built from scratch in Java using Swing and AWT, with no external libraries or game engines.

Status: work in progress. The core engine (game loop, player movement, animation, tile map rendering) works.
Gameplay features are still being added :)

https://github.com/user-attachments/assets/5eecd9ac-d0cd-40c8-949f-b3fbcea06bbb

### Features so far :
- Game loop running at a fixed 60 FPS on its own thread
- Player movement with WASD keys:

| Key | Action     |
|-----|------------|
| W   | Move up    |
| A   | Move left  |
| S   | Move down  |
| D   | Move right |

                    
- Sprite animation with two walking frames per direction (up, down, left, right)
- Tile-based map loaded from a plain text file, so levels can be edited without touching the code
- Tile types: grass, wall and water
- Scalable graphics: 16x16 pixel art scaled 3x to 48x48 tiles on a 16x12 tile screen (768x576 px)

### How the map works

Maps are text files in `res/maps/`.  
Each number represents a tile index.  
Maps use **16 columns** and **12 rows**, with numbers separated by spaces.

| Number | Tile |
|--------|------|
| 0      | Grass |
| 1      | Wall  |
| 2      | Water |



### Acknowledgements
- The engine structure (game loop, key handling, tile manager) follows the "How to Make a 2D Game in Java" tutorial series by RyiSnow. This project started as a learning exercise.
- All sprite and tile art was created by me.

