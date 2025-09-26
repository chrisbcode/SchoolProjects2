/* Written by Christopher Bergsveinsson
Program 3 - Roulette Simulation */

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class RouletteSim {
    static int[] RouletteWheel = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

    public static void printRouletteWheel() {
        int[] red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 28, 30, 32, 34, 36};
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";

        for(int i = 0; i < RouletteWheel.length; i++) {
            if(RouletteWheel[i] == 0) {
                System.out.print(ANSI_GREEN + RouletteWheel[i] + ANSI_RESET + " ");
            }
            else if (Arrays.binarySearch(red, RouletteWheel[i]) > 0) {
                System.out.print(ANSI_RED + RouletteWheel[i] + ANSI_RESET  + " ");
            }
            else {
                System.out.print(ANSI_BLACK + RouletteWheel[i] + ANSI_RESET + " ");
            }
        }

        System.out.println();

    }

    public static void printRouletteWheel(int chosenNumber) {
        int[] red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 28, 30, 32, 34, 36};
        String ANSI_BLACK = "\u001B[30m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_RESET = "\u001B[0m";
        String ANSI_GREEN = "\u001B[32m";

        for(int i = 0; i < RouletteWheel.length; i++) {
            if(RouletteWheel[i] == 0) {
                if (RouletteWheel[i] == chosenNumber) {
                    System.out.print(ANSI_GREEN + "\033[4m" + RouletteWheel[i] + "\033[0m" + ANSI_RESET + " ");
                }
                else {
                    System.out.print(ANSI_GREEN + RouletteWheel[i] + ANSI_RESET + " ");
                }
            }
            else if (Arrays.binarySearch(red, RouletteWheel[i]) >= 0) {
                if (RouletteWheel[i] == chosenNumber) {
                    System.out.print(ANSI_RED + "\033[4m" + RouletteWheel[i] + "\033[0m" + ANSI_RESET + " ");
                }
                else {
                    System.out.print(ANSI_RED + RouletteWheel[i] + ANSI_RESET  + " ");
                }
            }
            else {
                if (RouletteWheel[i] == chosenNumber) {
                    System.out.print(ANSI_BLACK + "\033[4m" + RouletteWheel[i] + "\033[0m" + ANSI_RESET + " ");
                }
                else {
                System.out.print(ANSI_BLACK + RouletteWheel[i] + ANSI_RESET + " ");
            }
            }
        }

        System.out.println();
    }

    public static void spinRouletteWheel() {

        int[] red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 28, 30, 32, 34, 36};
        Random rand = new Random();
        int roulettePosition = rand.nextInt(RouletteWheel.length);
        Scanner scanner = new Scanner(System.in);

        int[] betLine = {-1, -1, -1, -1};

        int chips = 0, bet = 0;

        boolean exit = false;

        System.out.println("Welcome to the Roulette Wheel!");
        printRouletteWheel();
        System.out.println("How many chips would you like to start with?");
        chips = Integer.parseInt(scanner.nextLine());

        while (!exit) {
            System.out.println("How many chips would you like to bet?");
            if(bet < chips) {
                bet = Integer.parseInt(scanner.nextLine());
            }
            else {
                break;
            }

            roulettePosition = rand.nextInt(RouletteWheel.length); // sets the roulette position for the remainder of this iteration of the while loopo

            System.out.println("What type of bet would you like to play? Enter 0 for betting on a color, and 1-4 for betting on a specific amount of numbers!");
            int chosenNumber = Integer.parseInt(scanner.nextLine());

            if (chosenNumber == 0) { // Option for color bet

                System.out.println("I see you chose the color bet! Which color would you like to choose? Black (1) or Red (2)?");
                chosenNumber = Integer.parseInt(scanner.nextLine());

                if (chosenNumber == 1) { // Option for black
                    System.out.print("Alright! Lets spin the wheel!");

                    printRouletteWheel(roulettePosition);
                    if (Arrays.binarySearch(red, roulettePosition) >= 0 || roulettePosition == 0) {
                        chips -= bet;
                        System.out.println("You lose! You lost your bet and your balance is now " + chips + " chips.");
                    } else {
                        chips += (bet * 2);
                        System.out.println("You win! Your bet was doubled, and your balance is now " + chips + " chips.");
                    }

                } else if (chosenNumber == 2) { // Option for red
                    System.out.println("Alright! Lets spin the wheel!");

                    printRouletteWheel(roulettePosition);
                    if (Arrays.binarySearch(red, roulettePosition) >= 0 || roulettePosition == 0) {
                        chips += (bet * 2);
                        System.out.println("You win! Your bet has been doubled, and your balance is now " + chips + " chips.");
                    } else {
                        chips -= bet;
                        System.out.println("You lose! You lost your bet and your balance is now " + chips + " chips.");
                    }

                }
            } else {
                if(chosenNumber == 1) { // Option for straight bet
                    System.out.println("I see you chose the straight bet! Enter your lucky number!");

                    chosenNumber = Integer.parseInt(scanner.nextLine());
                    System.out.println("Alright! Lets spin the wheel!");

                    printRouletteWheel(roulettePosition);
                    if (chosenNumber == roulettePosition) {
                        chips += (bet * 35);
                        System.out.println("WOW! You won and your bet has been multiplied by 35 and your balance is now " + chips + " chips.");
                    }
                    else {
                        chips -= bet;
                        System.out.println("You lose! You lost your bet and your balance is now " + chips + " chips.");
                    }
                }
                if(chosenNumber == 2) { // Option for split bet
                    System.out.println("I see you chose the split bet! Enter your two lucky numbers!");

                    for(int i = 0; i < chosenNumber; i++) {
                        betLine[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.println("Alright! Lets spin the wheel!");
                    printRouletteWheel(roulettePosition);

                    if(Arrays.binarySearch(betLine, roulettePosition) >= 0) {
                        chips += (bet * 17);
                        System.out.println("WOW! You won and your bet has been multiplied by 17 and your balance is now " + chips + " chips.");
                    } else {
                        chips -= bet;
                        System.out.println("You lose! You lost your bet and your balance is now " + chips + " chips.");
                    }

                }
                if(chosenNumber == 3) { // Option for street bet
                    System.out.println("I see you chose the street bet! Enter your three lucky numbers!");
                    for(int i = 0; i < chosenNumber; i++) {
                        betLine[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.println("Alright! Lets spin the wheel!");
                    printRouletteWheel(roulettePosition);

                    if(Arrays.binarySearch(betLine, roulettePosition) >= 0) {
                        chips += (bet * 11);
                        System.out.println("WOW! You won and your bet has been multiplied by 11 and your balance is now " + chips + " chips.");
                    } else {
                        chips -= bet;
                        System.out.println("You lose! You lost your bet and your balance is now " + chips + " chips.");
                    }
                }
                if(chosenNumber == 4) {
                    System.out.println("");
                    for(int i = 0; i < chosenNumber; i++) {
                        betLine[i] = Integer.parseInt(scanner.nextLine());
                    }

                    System.out.println("Alright! Lets spin the wheel!");
                    printRouletteWheel(roulettePosition);

                    if(Arrays.binarySearch(betLine, roulettePosition) >= 0) {
                        chips += (bet * 8);
                        System.out.println("WOW! You won and your bet has been multiplied by 8 and your balance is now " + chips + " chips.");
                    } else {
                        chips -= bet;
                        System.out.println("You lose! You lost your bet and your balance is now " + chips + " chips.");
                    }

                }

            }









            for (int i = 0; i < 4; i++) { // Resets the bet line
                betLine[i] = -1;
            }
            chosenNumber = 0; // Resets chosenNumber

            System.out.println("Would you like to keep playing? Yes (1) or No (2)");
            int choice = scanner.nextInt();
            if (choice == 1) {
                exit = false;
                if(chips == 0) {
                    System.out.println("You have zero chips! How many chips would you like to add to your balance?");
                    chips = scanner.nextInt();
                    System.out.println("You have sucessfully added " + chips + " chips to your balance!");
                }
            } else if (choice == 2) {
                exit = true;
            }

        }

    }

    public static void simulateRouletteSpins(int times) {

        int[] red = {1, 3, 5, 7, 9, 12, 14, 16, 18, 21, 23, 25, 27, 28, 30, 32, 34, 36};
        Random rand = new Random();
        int greenCount = 0, redCount = 0, blackCount = 0;

        for (int i = 0; i < times; i++) {
            int roulettePosition = rand.nextInt(RouletteWheel.length);

            if (roulettePosition == 0) {
            greenCount += 1;
            }
            else if (Arrays.binarySearch(red, roulettePosition) >= 0) {
            redCount += 1;
            }
            else {
            blackCount += 1;
            }

        }

        System.out.println("Green Count: " + greenCount + "\nRed Count: " + redCount + "\nBlack Count: " + blackCount);

    }



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("This is Program 3: Roulette Simulation written by Christopher Bergsveinsson");
        System.out.println("Would you like to enter simulation mode (1) or game mode (2)");
        int mode = scanner.nextInt();

        boolean exit = false;

        if (mode == 1) {
            while (!exit) {
                System.out.println("How many times would you like to spin the wheel?");
                int times = scanner.nextInt();
                simulateRouletteSpins(times);
                System.out.println("Would you like to keep simulating? Yes (1) or No (2)");
                int choice = scanner.nextInt();
                if (choice == 1) {
                    exit = false;
                }
                else if (choice == 2) {
                    exit = true;
                }
            }

        }
        else if (mode == 2) {
                spinRouletteWheel();
        }



    }
}
