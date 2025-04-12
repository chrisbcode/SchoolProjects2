/* Written by Christopher Bergsveinsson
 CSC 222 - Ambrose Lewis
 Every Saturday 9:35am → 1:30pm
 Program 4 - HorseRaceSim (Main) */


public class HorseRace {

    public static boolean isRaceOver(Horse[] horses){ // method that checks if the race is over
        int i;
        boolean raceOver = false;
        for (i = 0; i < horses.length; i++) {
            if (horses[i].getPosition() == 24) {
                raceOver = true;
            }
        }
        return raceOver;
    }

    public static void main(String[] args) {

        System.out.println("This is Program 4 (Horse Racing Simulator) was written by Christopher Bergsveinsson\n");

        Horse[] Horses = new Horse[3]; // creates a horse array of length 3
        Horses[0] = new Horse("Maverick", "Will", "low"); // initializes the horses in the array and introduces them
        Horses[0].introduction();
        Horses[1] = new Horse("Runner", "George", "medium");
        Horses[1].introduction();
        Horses[2] = new Horse("Strider", "Bob", "high");
        Horses[2].introduction();


        for (Horse horse : Horses) { // prints the horse's initial positions
            horse.printHorsePosition();
        }
        System.out.println("Ready... Set... Go!\n");

        System.out.println();
        int i = 0; // variable to keep track of the number iteration
        while(!isRaceOver(Horses)) { // keeps the loop iterating as long as the race hasn't ended
            if (i < Horses.length) {
                Horses[i].updatePosition();
                Horses[i].printHorsePosition();
                i += 1;
            }
            else { // prints a new line to separate steps of the race
                System.out.println();
                i = 0;
            }
        }

        System.out.println("\nWell that's all for the race today. Thanks for tuning in!");

    }
}