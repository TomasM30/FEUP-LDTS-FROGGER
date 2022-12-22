# LDTS_Turma4_Grupo5 - Frogger Game

## INTRODUCTION

In this simple and classic game, the player will help a little frog cross numerous adversities in order to reach its final destination. Our little friend will need to navigate its way through a road full of all types of vehicles without getting hit and surpass the dangers of a hazardous river.

This project was develop by Tomás Martins (up202108776@fe.up.pt), João Lima (up202108891@fe.up.pt) and João Belchior (up202108777@fe.up.pt) for LDTS 2022/23.

## IMPLEMENTED FEATURES

- **Move to any direction** - The game character will move forward, left, right and backward pressing the "W","A","D" and "S" keys respectively

- **Dangerous vehicles** - There will be a stage of moving vehicles that will pose a threat to our main character if he collides with them. These vehicles will be cars or trucks of different sizes and move at different speeds

- **Hazardous river** - In this stage there will be two types of moving objects. There will be floating logs of wood that will work as moving platforms to the frog, and there will be lily pads that will work the same as the floating logs

- **Health counter** - Our frog will be able to reach its destination within 3 tries. If it colides against a car or a truck, or even if it falls into the river, the frog will be spawned to the starting position losing a heart each time it happens until it is left with none

![LDTSuml drawio](https://user-images.githubusercontent.com/93995368/204024667-7b850704-7150-4fb2-823d-2e52d1ad793f.png)


### PLANNED FEATURES

- **Boosts** - Items that the frog can pick up to help it reach the other side easily
- **Different Levels** - Increased speed and number of obstacles increase accordingly to the number of times the frog reaches the other side
- **Timer** - Will trackdown the time the user takes to complete a level

###DESIGN
-------------------------------------------------------------------------------------------
#### THE GAME DISPLAYS SCREENS AND ALLOWS USER INPUT BASED ON THE CURRENT STATE

**Problem in Context**

The game needs to display different screens and allow for user input based on the current state of the game, such as the game over screen, the game screen, the game won screen, or the menu screen. Currently, there is a lot of scattered conditional logic to determine which screen to display and how to handle user input based on the current state. This makes the code difficult to understand and maintain.

**The Pattern**

We have applied the **State** pattern. This pattern allows us to define a common interface for all states, with concrete implementations for each specific state.
We created an abstract State class with abstract methods for getting the viewer and controller for the current state. We then created concrete State subclasses for each of the different screens, such as the GameOverState, the GameState, the GameWonState, and the MenuState. These subclasses override the abstract methods to return the appropriate viewer and controller for their specific state.
The game has a State attribute that determines the current state. When the step method of the game is called, it delegates to the viewer of the current State to display the current state and to the controller of the current State to handle user input. This allows the behavior of the game to change dynamically based on the state it is in. For example, if the game is in the GameOverState, the GameOverViewer will be used to display the game over screen and the GameOverController will be used to handle user input. This allows us to manage the display of screens and handling of user input based on the current state in a more organized and maintainable way.

**Implementation**

The following figure shows how the pattern’s roles were mapped to the application classes.

These classes can be found in the following files:

**Consequences**

- The various states that represent the different screens are explicit in the code, making it easier to understand and maintain
- We don't need to have a long set of conditional if or switch statements associated with the various states; instead, polymorphism is used to activate the right behavior
- The code is more organized and maintainable because the state-specific behavior is managed in a clear and modular way
- There are now more classes and instances to manage, which may increase the complexity of the codebase
-------------------------------------------------------------------------------------------

### TESTING

We have tried to implement some tests using Mockito but most of them are not passing (some of them are). After this delivery there will be more tests and we hope that all of them will pass.

