# Design Patterns
### Factory Pattern  
The Factory Pattern is useful for object creation without specifying the exact class of the object that will be created.  
This is useful in games for creating various types of characters or enemies without binding code to specific classes.

characters.Character and enemies.Enemy Creation: Factory pattern to create different types of characters and enemies.  
Can have a base class like characters.Character and derived classes for each character type or enemy.  
A factories.CharacterFactory could then be used to instantiate these based on the game level or specific scenarios.  

### Decorator Pattern  
The Decorator Pattern allows behavior to be added to individual objects, dynamically,  
without affecting the behavior of other objects from the same class.

characters.Character Enhancements and Power-ups: Decorator pattern to dynamically  
add features or enhancements to characters during the game.  
Decorate a character object with different types of armor or weapons that alter their attack or defense stats.

### Mediator Pattern
The Mediator Pattern is used to reduce communication complexity between multiple objects or classes.  
This pattern provides a mediator class that handles all the communication between different classes  
and supports easy maintenance of the code by promoting loose coupling.

Game Logic and Interaction Handling: GameMediator to handle interactions between different components  
of the game, such as battles, encounters with enemies, and navigating different floors or areas of the dungeon.  
The mediator can manage the turn-based combat system and interactions between players and enemies.

### Approach
- Initialize the game using a factories.CharacterFactory to create the player's character based on their choice.
- Use the Decorator to add specific attributes or items to the character during the game as they pick up items or earn rewards.  
- Implement the Mediator to control the flow of the game, manage battles, and handle the progression through levels until the final boss fight.

# Design Pattern Sources
In your Readme you need to include a section in which you mention your sources for the Design Patterns,  
explain why the Design Pattern is a good choice where you implemented it and explain exactly how you utilize it!  
This needs to be detailed.

# Screenshot
In your PDF (or README): include a screenshot of your Spotbugs and Checkstyle report. You will not get points   
for this if there are no screenshots that show us your reports. (10 points)

# ScreenCast
Include a short screencast showing you doing a git clone from your repo, gradle build, showing your reports  
(JUnit, Spotbugs, Checkstyle, GitHub Actions CI), and gradle run. Show your system in action (max. 6min). (8 points)  
-- link to screencast


# Design Pattern Explanation
Explain each of your Design Patterns briefly and mention which of the requirements
you fulfilled with this Pattern. (5 points)

# Submission
### Requirements Checklist
In your PDF, describe which requirements you fulfilled and also make sure you comment on it in your code.  
If you chose version 2 above, then 9 requirements need to be fulfilled overall in your code.  

Submit code with your Design Patterns and all that is asked above
1. A link to your GitHub repository (also include in the PDF)
2. A link to your screencast (also include in the PDF)
3. A PDF document explaining everything that is asked above in the general assignment.
   Submit the PDF directly on Canvas.

## Run Instructions

## Test Instructions
gradle test --tests InventoryTest  
gradle test --tests CharacterTest 