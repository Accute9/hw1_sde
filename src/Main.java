  //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Incorrect number of arguments, please try again following this format: # month ");
            System.out.println();
        } else {
            // All CLI arguments come as strings, so need to parse to integers before calling runSimulation
            int months = Integer.parseInt(args[0]);
            int rabbits = Integer.parseInt(args[1]);
            int wolves = Integer.parseInt(args[2]);
            runSimulation(months, rabbits, wolves);
        }
    }

    public static void runSimulation(int months, int rabbits, int wolves) {
        System.out.println("Your program begins with " + wolves + " wolves and " + rabbits +  " rabbits and runs for " + months + " months. \n");
        while (months > 0) {
            int wolvesLeft = 0;
            while (rabbits > 0 && wolvesLeft < wolves) {
                rabbits -= 1;
                wolvesLeft += 1;
            }
            if (rabbits > 0) {
                int secondWolvesCount = 0;
                while (secondWolvesCount < wolves && rabbits > 0) {
                    rabbits -= 1;
                    secondWolvesCount += 1;
                }
            }
            wolves = wolvesLeft;
            wolves += Math.floorDiv(wolves, 2);
            rabbits += (5 * Math.floorDiv(rabbits, 2));
            months -= 1;
        }
        System.out.println("At the end of the simulation, there are " + wolves + " wolves and " + rabbits + " rabbits.\n");
    }

}