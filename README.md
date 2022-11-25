# LPOO_Turma4_Grupo5 - Frogger Game 

## INTRODUCTION

In this simple and classic game, the player will help a little frog cross numerous adversities in order to reach its final destination. Our little friend will need to navigate its way through a road full of all types of vehicles without getting hit and surpass the dangers of a hazardous river.

This project was develop by Tomás Martins (up202108776@fe.up.pt), João Lima (up202108891@fe.up.pt) and João Belchior (up202108777@fe.up.pt) for LPOO 2022/23.

## IMPLEMENTED FEATURES

- **Move to any direction** - The game character will move forward, left, right and backward pressing the "W","A","D" and "S" keys respectively.

- **Dangerous vehicles** - There will be a stage of moving vehicles that will pose a threat to our main character if he collides with them. These vehicles will be cars or trucks of different sizes and move at different speeds.

- **Hazardous river** - In this stage there will be two types of moving objects. There will be floating logs of wood that will work the same as the vehicles mentioned before, and there will be lily pads that will work as moving platforms to the frog.

- **Health counter** - Our frog will be able to reach its destination within 3 tries. If it colides against a car or a log, or even if it falls into the river, the frog will be spawned to the starting position losing a heart each time it happens until it is left with none.

![LDTSuml drawio](https://user-images.githubusercontent.com/93995368/204024667-7b850704-7150-4fb2-823d-2e52d1ad793f.png)


### PLANNED FEATURES

- **Boosts** - Items that the frog can pick up to help it reach the other side easily

### DESIGN
Insert design problems

#### KNOWN CODE SMELLS AND REFACTORING SUGGESTIONS

> This section should describe 3 to 5 different code smells that you have identified in your current implementation, and suggest ways in which the code could be refactored to eliminate them. Each smell and refactoring suggestions should be described in its own subsection.

**Example of such a subsection**:

------

#### DATA CLASS

The `PlatformSegment` class is a **Data Class**, as it contains only fields, and no behavior. This is problematic because […].

A way to improve the code would be to move the `isPlatformSegmentSolid()` method to the `PlatformSegment` class, as this logic is purely concerned with the `PlatformSegment` class.

### TESTING

- Screenshot of coverage report.
- Link to mutation testing report.

### SELF-EVALUATION

> In this section describe how the work regarding the project was divided between the students. In the event that members of the group do not agree on a work distribution, the group should send an email to the teacher explaining the disagreement.


