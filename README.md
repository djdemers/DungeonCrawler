# Design Patterns
### Factory Pattern  
The Factory Pattern is useful for object creation without specifying the exact class of the object that will be created.  
This is useful in games for creating various types of characters or enemies without binding code to specific classes.

Character and Enemy Creation: Factory pattern to create different types of characters and enemies.  
Can have a base class like Character and derived classes for each character type or enemy.  
A CharacterFactory could then be used to instantiate these based on the game level or specific scenarios.  

### Decorator Pattern  
The Decorator Pattern allows behavior to be added to individual objects, dynamically,  
without affecting the behavior of other objects from the same class.

Character Enhancements and Power-ups: Decorator pattern to dynamically  
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
- Initialize the game using a CharacterFactory to create the player's character based on their choice.
- Use the Decorator to add specific attributes or items to the character during the game as they pick up items or earn rewards.  
- Implement the Mediator to control the flow of the game, manage battles, and handle the progression through levels until the final boss fight.