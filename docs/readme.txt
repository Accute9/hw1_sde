9/3/26

Assumptions / Rules:
- Wolves eat no more than 2 rabbits each month
- Rabbits that survive the whole month produce offspring (litter of 5 per 2)
- Wolves who eat no rabbits die
- Wolves must survive the whole month to produce offspring (1 cub per 2)
- Wolves eat rabbits one at a time - ex: if there are 2 rabbits and 2 wolves, each wolf eats 1 rabbit
    - If there are rabbits still left after each wolf has eaten one, wolves will eat another until no more rabbits are left or each wolf has eaten two

Pseudocode:

function runSimulation(months, rabbits, wolves)
    while months greater than 0:
        wolvesLeft = 0 // keep track of number of wolves that have eaten (this is the number that lives)
        while rabbits greater than 0 and wolvesLeft greater than wolves:
            decrease rabbits by 1
            increase wolvesEaten by 1
        // Loop again for second round of wolves in case there are rabbits still alive
        secondWolvesCount = 0 // keep track of wolves that have eaten two rabbits
        while secondWolvesCount less than wolves and rabbits less than 0:
            decrease rabbits by 1
            increase secondWolvesCount by 1
        wolves = wolvesLeft
        wolf_pairs = wolves / 2 (rounded down)
        increase wolves by wolf_pairs
        rabbit_pairs = 5 * (rabbits / 2 (rounded down))
        increase rabbits by rabbit_pairs
        decrease months by 1
    return rabbits, wolves

Tests:
1. months = 2, rabbits = 3, wolves = 2: -> rabbits = 0, wolves = 0
2. months = 1, rabbits = 5, wolves = 1: -> rabbits = 8, wolves = 1
3. months = 3, rabbits = 0, wolves = 3: -> rabbits = 0, wolves = 0
4. months = 1, rabbits = 2, wolves = 5: -> rabbits = 0, wolves = 3
5. months = 5, rabbits = 3, wolves = 0: -> rabbits = 1198, wolves = 0

All tests satisfied

How to run:
cd src
java Main.java <# months> <# rabbits> <# wolves>