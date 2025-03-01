# LDTS_Turma4_Grupo5 - Frogger Game

## INTRODUCTION

In this simple and classic game, the player will help a little frog cross numerous adversities in order to reach its final destination. Our little friend will need to navigate its way through a road full of all types of vehicles without getting hit and surpass the dangers of a hazardous river.

This project was develop by Tomás Martins (up202108776@fe.up.pt), João Lima (up202108891@fe.up.pt) and João Belchior (up202108777@fe.up.pt) for LDTS 2022/23.

## IMPLEMENTED FEATURES

- **Move to any direction** - The game character will move forward, left, right and backward pressing the "W","A","D" and "S" keys respectively

- **Dangerous vehicles** - There will be a stage of moving vehicles that will pose a threat to our main character if he collides with them. These vehicles will be cars or trucks of different sizes and move at different speeds

- **Hazardous river** - In this stage there will be two types of moving objects. There will be floating logs of wood that will work as moving platforms to the frog, and there will be lily pads that will work the same as the floating logs

- **Health counter** - Our frog will be able to reach its destination within 3 tries. If it colides against a car or a truck, or even if it falls into the river, the frog will be spawned to the starting position losing a heart each time it happens until it is left with none

 



<p align="center">
  <img src=https://github.com/FEUP-LDTS-2022/project-l04gr05/blob/Lima/src/main/resources/FroggerGif.gif alt="animated" />
</p>


### DESIGN

-------------------------------------------------------------------------------------------
#### THE GAME DISPLAYS SCREENS AND ALLOWS USER INPUT BASED ON THE CURRENT STATE

**Problem in Context**

The game needs to display different screens and allow for user input based on the current state of the game, such as the game over screen, the game screen, the game won screen, or the menu screen. Currently, there is a lot of scattered conditional logic to determine which screen to display and how to handle user input based on the current state. This makes the code difficult to understand and maintain.

**Patterns**

In our game we have four different moments: the menu, in-game, when you win or when you lose and we have different controllers and displays for each moment so, we need to know in which moment we are in order to correctly implement it. This pattern will help us to represent different states with the help of different subclasses and we can switch to another state by switching to another subclass. This will improve our code’s structure and it will allow us to have specific functions for each state.

The UML shows how the pattern’s roles were mapped to the application classes.

These classes can be found in the following files: “GameState”, “GameOverState”, “GameWonState”, “MenuState”, “State”.

**Consequences:**
- The various states that represent the different screens are explicit in the code, making it easier to understand and maintain
- We don't need to have a long set of conditional if or switch statements associated with the various states; instead, polymorphism is used to activate the right behavior
- The code is more organized and maintainable because the state-specific behavior is managed in a clear and modular way
- There are now more classes and instances to manage, which may increase the complexity of the codebase
-------------------------------------------------------------------------------------------

#### THE GAME DISPLAYS ELEMENTS THAT THE USER WILL INTERACT WITH

**Problem in Context**

In our game, we have several objects that that may or not move across the screen. We need to display them on the screen and allow the user to interact with them.

**Patterns**

We have applied the Model-View-Controller (MVC) pattern to address this problem. This pattern separates the application's data model, user interface, and control logic into separate classes, allowing for a clear separation of concerns and improved maintainability.

This can be found on all Model, viewers, controllers elements.

- The model represents the data and the business logic of the application. It holds the state of the application and defines the rules for manipulating and updating that state
- The view represents the presentation layer of the application. It displays the data from the model to the user and allows the user to interact with the application
- The controller represents the link between the model and the view. It receives input from the user and updates the model accordingly, and it also updates the view to reflect the changes in the model

**Consequences:**
- The MVC pattern helps us to create a clear separation of concerns and improve the maintainability of our code. It also makes the code easier to test and scale
-------------------------------------------------------------------------------------------
#### THE NECESSITY TO HAVE A WAY TO COUNTINUOUSLY UPDATE THE GAME

**Problem in Context**

It is necessary to have a mechanism that allows us to continuously update the game's state and display the corresponding visuals. It is also important to be able to manage user input and transition between different game states (e.g. menu, in-game, win, lose).

**Patterns**

We have applied the Game Loop pattern. This pattern allows us to continuously update the game state and render the game visuals based on that state. It also allows us to handle user input and transition between different game states.

This can be found in the Game class

**Consequences:**
- The game loop provides a consistent and organized way to update and render the game state
- The game loop allows for easy transition between different game states
- The frame rate can be adjusted to control the speed of the game
-------------------------------------------------------------------------------------------
#### DIFFERENT BEHAVIORS FOR EACH OBJECT

**Problem in Context**

We need to implement various behaviors for different game elements, such as the frog's movement and interactions with the arena elements. This includes handling user input to move the frog, detecting collisions with cars and the river, and determining win or lose conditions.

**Patterns**

In our game, we have implemented the Strategy pattern to allow for flexible and dynamic behavior of game elements. This pattern allows us to define multiple ways for an element to perform a task and easily switch between them during runtime. For example, we can define different strategies for the frog to move and interact with other elements in the arena, and choose the appropriate one based on the current game situation. This helps us to easily customize the behavior of elements and make the game more dynamic and engaging for the player.

The strategy pattern can be found whenever we define an element controller

**Consequences:**

- The Strategy pattern enables us to dynamically alter the behavior of game elements during execution
- Makes the code more modular and easier to understand, and follows the open-closed principle by allowing for new behaviors without modifying existing code
-------------------------------------------------------------------------------------------

#### ELEMENT VIEWERS AND CONTROLLERS CREATION

**Problem in Context**

There is a need to create element viewers and controllers in a flexible way, as there are multiple types of elements that require them. It is important to have a flexible solution that allows us to easily create them for new types of elements without having to make changes to the existing codebase.

**Patterns**

The Factory Method helps us create things called element viewers and controllers in a way that is easy to change and use for many different types of elements. It does this by hiding the details of how the viewers and controllers are made and making it easy to add new types. This makes the code easier to understand and easier to change if we need to.

This design can be found in the following files: “GameState”, “GameOverState”, “GameWonState”, “MenuState”, “State”.

**Consequences:**

- The factory method lets us make viewers and controllers in a way that can be changed and expanded easily
- We can add new types of elements by making new viewer and controller classes and adding them to the factory method
- Makes the code cleaner and easier to fix if there are problems
-------------------------------------------------------------------------------------------
### UML (It shows the Patterns)

![](https://github.com/FEUP-LDTS-2022/project-l04gr05/blob/Lima/docs/Screenshot%20from%202022-12-23%2016-29-10.png)

-------------------------------------------------------------------------------------------
### TESTING

**Intellij Coverage**

![](https://github.com/FEUP-LDTS-2022/project-l04gr05/blob/Lima/docs/Screenshot%20from%202022-12-23%2022-09-42.png)

**Mutation Testing Report**

![](https://github.com/FEUP-LDTS-2022/project-l04gr05/blob/Lima/docs/Screenshot%20from%202022-12-23%2022-10-22.png)

We tried to implement a lot of tests using mockito and we used once the PBT.

### Refactoring

At the end we have noticed some things that we could eliminate, or simplify in order to make our code more readable and simpler. For example, we had a lot of objects that were doing nothing in some functions; classes and functions that were unnecessary and we have eliminated all the comments that we had in our code. Besides that, we have tried to organize our data (sometimes we have self encapsulated fields, for example), simplified some method calls by, for example, removing parameters that weren’t being used and renaming methods (so that the name explains what the method does) and we have tried to simplify our conditional expressions that were used in our methods.

### Code Smells

**Bloaters - Large class**

The class Arena represents the entire map and it has a lot of private objects in order to create the list of lists (each list represents a line of the map). However it is a very large class and we could have organized these objects better in order to make a simpler and less complicated class. Besides that, we have a huge method ("createLines()") in the class "LoaderArenaBuilder" which it could have been simpler if we've had created 2 or 3 new methods to check if that specific line was a line where there were cars on the road or a line where there were logs in the river, etc.

**Object-Orientation Abusers**

In some parts of our code we have some complex if operators and these could have been easily replaced by simpler expressions specially in the controller classes, the FrogController class for example. In this class, we could have simplified our if operators by creating some temporary fields in order to simplify this expressions (making these more readable). 

**Some Problems in the Tests**

We had some issues testing the change of states and we have a little mistake in the class MenuTest which we didn't understand why it was giving us a failed test.