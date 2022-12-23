# LDTS_Turma4_Grupo5 - Frogger Game

## INTRODUCTION

In this simple and classic game, the player will help a little frog cross numerous adversities in order to reach its final destination. Our little friend will need to navigate its way through a road full of all types of vehicles without getting hit and surpass the dangers of a hazardous river.

This project was develop by Tomás Martins (up202108776@fe.up.pt), João Lima (up202108891@fe.up.pt) and João Belchior (up202108777@fe.up.pt) for LDTS 2022/23.

## IMPLEMENTED FEATURES

- **Move to any direction** - The game character will move forward, left, right and backward pressing the "W","A","D" and "S" keys respectively

- **Dangerous vehicles** - There will be a stage of moving vehicles that will pose a threat to our main character if he collides with them. These vehicles will be cars or trucks of different sizes and move at different speeds

- **Hazardous river** - In this stage there will be two types of moving objects. There will be floating logs of wood that will work as moving platforms to the frog, and there will be lily pads that will work the same as the floating logs

- **Health counter** - Our frog will be able to reach its destination within 3 tries. If it colides against a car or a truck, or even if it falls into the river, the frog will be spawned to the starting position losing a heart each time it happens until it is left with none



###DESIGN
-------------------------------------------------------------------------------------------
#### THE GAME DISPLAYS SCREENS AND ALLOWS USER INPUT BASED ON THE CURRENT STATE

**Problem in Context**

The game needs to display different screens and allow for user input based on the current state of the game, such as the game over screen, the game screen, the game won screen, or the menu screen. Currently, there is a lot of scattered conditional logic to determine which screen to display and how to handle user input based on the current state. This makes the code difficult to understand and maintain.

**Patterns**

**State**

In our game we have four different moments: the menu, in-game, when you win or when you lose and we have different controllers and displays for each moment so, we need to know in which moment we are in order to correctly implement it.

This pattern will help us to represent different states with the help of different subclasses and we can switch to another state by switching to another subclass. This will improve our code’s structure and it will allow us to have specific functions for each state.

The UML shows how the pattern’s roles were mapped to the application classes.

These classes can be found in the following files: “GameState”, “GameOverState”, “GameWonState”, “MenuState”, “State”.
Consequences:
- The various states that represent the different screens are explicit in the code, making it easier to understand and maintain
- We don't need to have a long set of conditional if or switch statements associated with the various states; instead, polymorphism is used to activate the right behavior
- The code is more organized and maintainable because the state-specific behavior is managed in a clear and modular way
- There are now more classes and instances to manage, which may increase the complexity of the codebase
-------------------------------------------------------------------------------------------

### TESTING

We have tried to implement some tests using Mockito but most of them are not passing (some of them are). After this delivery there will be more tests and we hope that all of them will pass.