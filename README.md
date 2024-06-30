# MagicalArena
It is a turn-based battle between two players in an arena. Each player has attributes: health, strength, and attack. The game continues in turns until one player's health reaches zero.

# Features
- Dynamic input of player attributes (health, strength, attack).
- Turn-based combat simulation between two players.
- Randomized dice rolling for attack and defense calculations.
- Determines and prints the winner based on the players' health.

# Approach
1. Users provide input for Player A and Player B's attributes: `health`, `strength`, and `attack` values. These inputs define the initial conditions and capabilities of each player in the simulated duel.
2. Based on the user inputs, two `Player` objects are instantiated `(Player playerA = new Player(healthA, strengthA, attackA);` and `Player playerB = new Player(healthB, strengthB, attackB);)`.\
   Each `Player` object encapsulates attributes such as `health`, `strength`, and `attack`, which determine their combat effectiveness.
3. A `Battle` object is created to manage the combat interaction between Player A and Player B `(Battle battle = new Battle(playerA, playerB);)`.\
   The `Battle` object is initialized with references to `Player A` and `Player B`, preparing for the duel to commence.
4. The `Battle` class determines which player starts as the attacker based on their initial health. This decision is typically made to ensure fairness, often favoring the player with lower `health` at the start.
5. The `Battle` proceeds in turns, where each `Player` alternates between attacking and defending. During each turn, the current attacker rolls a dice (simulated by the Dice class) to determine the effectiveness of their attack `(attackRoll = dice.rollDie();)`.\
   Simultaneously, the defending player rolls the dice to gauge the effectiveness of their defense `(defendRoll = dice.rollDie();)`.
6. `Attacker` Damage: Calculate the damage inflicted by the attacker using their `attack` value and the dice roll `(attackDamage = attackRoll * attacker.getAttack();)`.
7. `Defender` Defense: Determine the defender's ability to mitigate damage based on their `strength` and the defense roll `(defendDamage = defendRoll * defender.getStrength();)`.
8. Net Damage: Compute the net damage inflicted on the defender after considering both attack and defense (`netDamage = Math.max(0, attackDamage - defendDamage);`)
9. Apply the computed net damage to reduce the defender's `health` using the `reduceHealth()` method of the `Player` class.\
   Ensure that the defender's `health` does not drop to (or below) zero, safeguarding against negative health values.
10. After each turn, roles switch between attacker and defender (`battle.switchRoles();`).\
    It continues in turns until the health of either `Player A` or `Player B` (or both) drops to zero or below.
11. Winning Condition: If one `Player` has zero or negative `health`, declare the other `Player` as  the winner of the duel.


# Code Flow

User Inputs Player A and Player B Attributes\
↓\
Initialize Players and Match\
↓\
Start Battle\
↓\
Players Take Turns Attacking\
↓\
Determine Winner\
↓\
Print Outcome

# Sample Input and Output
```
Player A

Enter the health of Player A:
70
Enter the strength of Player A:
6
Enter the attack of Player A:
9

Player B

Enter the health of Player B:
70
Enter the strength of Player B:
6
Enter the attack of Player B:
9

Winner of magical arena: Player A wins the match!
```

# How to run this program?
1. Download/Clone this repository.
2. Install `maven` (You can skip this part if already installed) using `sudo apt-get install maven`.
3. Clean the maven packages for a clean build using `mvn clean`.
4. Install the dependencies using `mvn install`.
5. Build the jar file using maven `mvn compile`
6. Run the binary using `mvn exec:java -Dexec.mainClass=com.mycompany.App`