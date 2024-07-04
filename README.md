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

## Requirements
### 1. You must be able to choose a class for your character (or have it assigned randomly), each class has a different subset of skills or magic. A class would constitute something along the lines of ’fighter’, ’mage’, ’thief’, get creative with it!
Requirement Fulfillment:  

Character Diversity: By deriving from the Character class, specific character classes such as Mage, Warrior, Rogue   
can implement their unique sets of skills and attributes. This architecture supports the requirement of having character   
classes with distinct abilities.

The CharacterDecorator class allows for dynamic modifications to characters' attributes or abilities.   
This is useful in RPGs for implementing features like temporary buffs, equipment bonuses, or conditional abilities
that modify character behavior based on game events.

The factory method createRandomCharacter encapsulates the logic to randomly select a character class. This approach
not only simplifies character creation throughout the game but also ensures that each character class can be instantiated with its distinct characteristics and abilities, aligning with the requirement.

### 2. You should be able to choose a type for your character (or have it assigned randomly), each race should have one passive skill that gets better after leveling up or that gives them advantage over another. rate A type would constitute something like, ’orc’,’elf’, ’dwarf’, ’human’. Perhaps orcs are stronger naturally, perhaps elves are the most nimble and can dodge better, maybe humans have less HP but gain exp at a faster, get creative with it!
Requirement Fulfillment:

The Race enum defines various types of races available for characters, such as Human, Elf, Dwarf, Orc, and Fairy.   
Each race is associated with unique attribute bonuses that affect the character's health, agility, strength, defense, and mana. This design directly supports the   
requirement of allowing players to choose or be assigned a race randomly, with each race providing distinct passive skills or advantages.

Random Race Assignment: The CharacterFactory uses the Race.getRandomRace() method to assign a race to new characters,   
ensuring that each character starts with a unique set of racial attributes. This random assignment adds an element of   
unpredictability and variety to the game, enhancing replayability.

### 3. You should encounter a randomly generated ’small’ enemy every floor, a ’medium’ enemy every 5 floors, and a ’BOSS’ every 10 floors.

Requirement Fulfillment: 

Small Enemies Every Floor: The method createRandomSmallEnemy(int currentFloor) generates a small enemy for every floor.   
This aligns with the requirement to have a randomly generated small enemy on each floor, ensuring that the game continuously   
presents challenges to the player.

Medium Enemies Every 5 Floors: Similarly, the createRandomMediumEnemy(int currentFloor) method is designed to generate   
medium-sized enemies every five floors.

Boss Enemies Every 10 Floors: The method createRandomBoss(int currentFloor) provides the functionality to create boss   
enemies every ten floors. 

### 4. Your character should be able to equip items such as a sword, shield, helmet, armor, boots, etc. Your character should be able to equip a minimum of 3 unique item types. You get to decide what happens if you come across a second item type. For example, if you have 3 different swords you have programmed, and you have one equipped and come across another, does it automatically replace the old one? Does it compare stats and pick the better one? What happens if you don’t take it? 

Requirement Fulfillment:  

In the Inventory class addItem(Item item): Adds items to the inventory. If the item is an instance of Equipable,   
it automatically tries to equip the item, which is removed from the general inventory if equipped.  
equipItem(String itemName): Manually equips an item by name, removing it from the general inventory if successful.    
autoEquip(Equipable newItem): Automatically decides if a new equipable item should replace the currently equipped   
item of the same type. This method uses a simple comparison based on the item's bonus ensuring that the best item   
of each type is equipped. If a new item is equipped, the old one is unequipped, and its effects are reversed.

### 5. After each battle you should have a small chance to find a chest that contains items such as armor/money/potions, or a shop where you can spend your money.

Requirement Fulfillment:

Chest Event:

Random Rewards: When a chest event is triggered, the player receives a random item and potentially some gold, adding a   
reward mechanism that can help players in their journey. Players immediately see what they've found.
Shop Event:

Shopping: When a shop is found, it provides an interactive element where players can spend gold to buy  
items that may improve their character's stats or abilities.

### 6. The shop should sell 3 random objects, weapons, magic scrolls (good for one use), potions (good for one use), instant level up (RARE), get creative with it.

Requirement Fulfillment:  

Dynamic Shop Inventory: The shop generates its inventory dynamically, which means that no two visits to the shop are exactly the same.

Dynamic Inventory Generation: The generateInventory() in the method within the Shop class ensures that the inventory is not static.   
It includes regular items generated in ItemFactory and a chance for a special item, mimicking randomness.

The Shop generates three items for sale. Two are guaranteed random items, and the third has a 5% chance to be a rare   
instant level-up item. If the rare item does not appear, another random item is added to the inventory. 
This setup ensures variety.

### 7. Potions should never give more Health or Mana than you have as a maximum.

Requirement Fulfillment:  

Health and Mana Restoration: The potion increases the character's health/mana upon use. Max Health/Mana Limitation:   
The amount is capped at the character's maximum health/mana to ensure it does not exceed the max limit, using Math.min()   
to calculate the new health. Usage Feedback: It provides feedback on how much health was actually restored  
Price Implementation: Includes a price for the potion, allowing it to be integrated into shop transactions or other economic elements of your game.

### 8. After each floor (and after each possible random encounter with a shop) you should go back to the top floor if your health is below 15%. Going to the top floor gives you back all of your health and mana

Requirement Fulfillment: 

openShop(Character hero)
Shop Interaction: Initiates a shop interaction where the character can view and possibly purchase items.
Health Check: After shopping, the method checks if the hero's health is below 15% of the maximum.
Top Floor Transition: If the health condition is met, it transitions the game back to the top floor, simulating a safety mechanic where the player can recover.
goToTopFloor()
Health and Mana Restoration: Restores the hero's health and mana to full.
Floor Reset: Sets the game's current level or floor back to the first one.
Notification: Informs the player about the critical health condition and the consequent action taken.

### 9. All enemies should get harder for each floor you travel to, for example, an enemy on floor 2 should be much, much weaker than an enemy on floor 48!

Requirement Fulfillment:    

Scaling Mechanics: The class systematically increases the health, attack power, defense, and speed of enemies based on the current floor number.   
This ensures that as the player progresses to higher floors, the enemies they encounter will have proportionally increased difficulty.  
Parameterized Increments: The use of constants like HEALTH_INCREMENT, ATTACK_INCREMENT, DEFENSE_INCREMENT, and SPEED_INCREMENT allows for easy   
adjustments to the scaling factors. This makes it straightforward to balance the game by modifying these values.

### Approach
- Initialize the game using a factories.CharacterFactory to create the player's character based on their choice.
- Use the Decorator to add specific attributes or items to the character during the game as they pick up items or earn rewards.  
- Implement the Mediator to control the flow of the game, manage battles, and handle the progression through levels until the final boss fight.

# Design Pattern Sources
### In your Readme you need to include a section in which you mention your sources for the Design Patterns, explain why the Design Pattern is a good choice where you implemented it and explain exactly how you utilize it! This needs to be detailed.

Factory Pattern:

CharacterFactory, ItemFactory and EnemyFactory classes.  

CharacterFactory: This factory abstracts the creation process of different types of characters based on the selected or random class and race.   
It encapsulates the instantiation logic which makes the system independent of how objects are created, composed, and represented.  
EnemyFactory: Similar to CharacterFactory, this factory handles the creation of different enemies, applying scaling based on the floor level,   
which simplifies the enemy creation process and makes it easier to adjust the properties of enemies based on game progress.  

Decorator Pattern:

In the CharacterDecorator class and its subclasses like Armor, Sword, and Boots.
Purpose and Utilization:
This pattern allows you to dynamically add or modify behaviors of objects (in this case, characters) at runtime. By wrapping characters with decorators like Armor or Sword, you enhance their abilities (like defense or attack power) without modifying their structure. This is useful for implementing equipment changes that affect character stats temporarily.

Strategy Pattern:

In the EnemyLeveling class, which is used as a strategy for scaling enemy attributes.
Purpose and Utilization:
The strategy pattern is utilized to define a family of algorithms, encapsulate each one, and make them interchangeable. In your game, EnemyLeveling defines how enemy attributes are scaled based on the floor level. By encapsulating the scaling logic in this strategy, you can easily adjust or replace the scaling mechanics without affecting the core enemy class.

Mediator Pattern:  
GameMediatorImpl Utilizes the Mediator Pattern:
Centralized Control: The class centralizes the complex interactions between different game components such as characters,     
enemies, inventory, and game levels. Instead of these components communicating directly with each other and possibly creating   
dependencies that are hard to manage, they interact through the mediator. Reduced Complexity: By handling the game logic and   
the flow of the game, GameMediatorImpl reduces the complexity of the interactions within the game. Each component like Character,   
Enemy, Inventory, or Shop does not need to know about the rules and logic of others. For example, managing battles, leveling up,   
or handling game events like finding chests or shops are all mediated through this class. Improves Flexibility and Reusability:   
Changes in game mechanics or interactions can be managed within the GameMediatorImpl without impacting the individual components.   
This makes the game more flexible and the components more reusable, as they do not contain direct references to each other.  
Enhanced Maintainability: Future updates to the game, such as adding new types of events, enemies, or other game mechanics,   
can be handled within the mediator without extensively modifying the existing components. This encapsulation of processes   
makes the system easier to maintain.

# Screenshot
In your PDF (or README): include a screenshot of your Spotbugs and Checkstyle report. You will not get points   
for this if there are no screenshots that show us your reports. (10 points)

# ScreenCast
Include a short screencast showing you doing a git clone from your repo, gradle build, showing your reports  
(JUnit, Spotbugs, Checkstyle, GitHub Actions CI), and gradle run. Show your system in action (max. 6min). (8 points)  
https://youtu.be/aV6XONbFB-c



# Submission
### Requirements Checklist
In your PDF, describe which requirements you fulfilled and also make sure you comment on it in your code.  
If you chose version 2 above, then 9 requirements need to be fulfilled overall in your code.  

Submit code with your Design Patterns and all that is asked above
1. A link to your GitHub repository (also include in the PDF) https://github.com/djdemers/assignment5
2. A link to your screencast (also include in the PDF) https://youtu.be/aV6XONbFB-c
3. A PDF document explaining everything that is asked above in the general assignment.
   Submit the PDF directly on Canvas.

