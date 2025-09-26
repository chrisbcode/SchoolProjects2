/* Written by Christopher Bergsveinsson
Program 4 - HorseRaceSim (Class) */

import java.util.Arrays;

public class Horse {
    String horseName;
    String jockeyName;
    String odds;
    double oddVal;
    int position;
    int posIncrease;

    public Horse(String horseName, String jockeyName, String odds) { // constructor that sets class variables to / based off inputted arguments
        this.horseName = horseName;
        this.jockeyName = jockeyName;
        this.odds = odds;
        this.position = 0;
        switch (odds) {
            case "low" -> {
                oddVal = .4;
                posIncrease = 2;
            }
            case "medium" -> {
                oddVal = .5;
                posIncrease = 2;
            }
            case "high" -> {
                oddVal = .9;
                posIncrease = 4;
            }
        }
    }

    public String getHorseName() {
        return horseName;
    } // get methods

    public String getJockeyName() {
        return jockeyName;
    }

    public String getOdds() {
        return odds;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    } // set methods

    public void setHorseName(String horseName) {
        this.horseName = horseName;
    }

    public void setJockeyName(String jockeyName) {
        this.jockeyName = jockeyName;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public void introduction() { // randomized introduction message for horse and jockey, and also their odds
        int introNum = (int) ((Math.random() * 3) - 0.01);
        if (introNum == 0) {
            System.out.println("Here comes " + jockeyName + " with their steady steed " + horseName + ", who has " + odds + " odds and is ready to go!");
        }
        if (introNum == 1) {
            System.out.println("Approaching the track is " + jockeyName + " with their honorable horse " + horseName + ", who has " + odds + " odds and is ready to go!");
        }
        if (introNum == 2) {
            System.out.println("Coming our way is " + jockeyName + " with their sensational stallion " + horseName + ", who has " + odds + " odds and is ready to go!");
        }
    }

    public int pastPosition = 0;
    public void announce() { // prints messages based off the horse's position, change in position, and odds
        if (position == 24) {
            switch(odds) {
                case "low" ->
                    System.out.print("Wow! The low odds horse " + horseName + " is the winner!\n");
                case "medium" ->
                    System.out.print("WOW! The medium odds horse " + horseName + " is the winner!\n");
                case "high" ->
                    System.out.print("WHAT AN UPSET! The high odds horse " + horseName + " is the winner!\n");

            }
        }
        else if ((position - pastPosition) == 1) {
            switch (odds) {
                case "low" ->
                        System.out.println(jockeyName + " stays in rhythm with their horse " + horseName + " and they are now at position " + position);
                case "medium" ->
                        System.out.println(jockeyName + " is rolling along with their horse " + horseName + " and they are now at position " + position);
                case "high" ->
                        System.out.println(jockeyName + " is still in the race with their horse " + horseName + " and they are now at position " + position);
            }
        }
        else if ((position - pastPosition) == posIncrease) {
            switch (odds) {
                case "low" ->
                        System.out.println(jockeyName + " picks up the pace with their horse " + horseName + " and they are now at position " + position + "!");
                case "medium" ->
                        System.out.println(jockeyName + " is making a move with their horse " + horseName + " and they are now at position " + position + "!");
                case "high" ->
                        System.out.println(jockeyName + " has a burst of speed with their horse " + horseName + " and they are now at position " + position + "!");
            }
        }
    }

    public void updatePosition() { // updates position based of the horses odds, and also includes the announce() method to avoid redundancy
        double speed = Math.random() - oddVal;
        if(speed < 0) {
            if ((position + 1) < 24) {
                position += 1;
                announce();
            }
            else {
                position = 24;
                announce();
            }
        }
        else if (speed > 0) {
            if ((position + posIncrease) < 24) {
                position += posIncrease;
                announce();
            }
            else {
                position = 24;
                announce();
            }
        }
        pastPosition = position;
    }


    public static final String[] COLORS = { // ANSI escape codes for the color of the jockey
            "\u001B[31m", // red
            "\u001B[32m", // green
            "\u001B[33m", // yellow
            "\u001B[34m", // blue
            "\u001B[35m", // purple
            "\u001B[36m", // cyan
        };

    public String[] raceTrack = new String[] { "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_", "_"}; // array of the racetrack

    public final String coloredHorse = COLORS[(int) (Math.random() * COLORS.length)] + "*" + "\u001B[0m"; // sets an asterisk to a random color to represent the horse

    public void printHorsePosition() { // prints the horses position
        raceTrack[position] = coloredHorse;
        System.out.println(Arrays.toString(raceTrack));
        raceTrack[position] = "_";
    }

}

