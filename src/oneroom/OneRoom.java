package oneroom;

import java.util.Scanner;

public class OneRoom {

    static Scanner sc = new Scanner(System.in); // need scanners for user input (action or guess)
    static boolean play = true; //for while loop in main, so they can do multiple things
    static String answer; //need (probably) string to check .contains

    public static void main(String[] args) {
        start(); //runs the 'first time' text to give context
        input();
        while (play) {
            next(); //this one just reminds user of options so they can provide input
            input();
        }
    }

    public static void start() {//text for first time run / context
        System.out.println("You find yourself in a room.\n"
                + "You aren't sure what kind of room, but you can find out by using the clues available to you.\n"
                + "What do you look at (or do)?\n"
                + "(1) Look at puddle\n"
                + "(2) Look at paper\n"
                + "(3) Look at wooden object\n"
                + "(4) Make a guess at what kind of room");
    }

    public static void input() { //checks user input for action (inspect objects or guess)
        answer = sc.nextLine(); //makes string equal to result of scanner
        if (answer.contains("1") || answer.contains("puddle")) { //just in case they don't listen or whatever, i included the word as well as number
            one();
        } else if (answer.contains("2") || answer.contains("paper")) {
            two();
        } else if (answer.contains("3") || answer.contains("wood") || answer.contains("object")) {
            three();
        } else if (answer.contains("4") || answer.contains("g")) {
            guess();
        } else {
            System.out.println("Wrong input, please try again."); //just in case they typed nothing useful
            input();//restarts so it checks again
        }
    }

    public static void guess() { //separate check for when they guess room type, not 100% necessary but input would be cluttered if we included that in input()
        answer = sc.nextLine();
        if (answer.contains("math") && answer.contains("class")
                || answer.contains("algebra") && answer.contains("class")
                || answer.contains("geometry") && answer.contains("class")) {
            System.out.println("Excellent! You won.");
            play = false;
        } else if (answer.contains("class")) {
            System.out.println("Very close, but do you know what kind of class?");
            answer = sc.nextLine();
            if (answer.contains("math") || answer.contains("algebra") || answer.contains("geometry")) {
                System.out.println("Excellent! You won.");
                play = false;
            } else {
                System.out.println("Try again");
                guess();
            }
        } else {
            System.out.println("Nope. Guess again?\n" //this is for wrong guess, they can continue guessing or go back to looking around
                    + "(1) Yes, guess again\n"
                    + "(2) No, go back to choices\n");
            answer = sc.nextLine();
            if (answer.contains("1") || answer.contains("y")) {
                guess();
            } else if (answer.contains("2") || answer.contains("n")) { //nothing in here so the method will just end and the while loop can do its thing
                
            }
        }

    }

    public static void one() {
        System.out.println("This is a puddle of students' tears.\n"
                + "They are very salty, and are right in front of the wooden object.\n"
                + "It is still a mystery what caused these tears.");
    }

    public static void two() {
        System.out.println("There are many papers. All of them have red letters,\n"
                + "further into the alphabet than you would expect on that of a successful student's work.\n"
                + "The papers also have many numbers on them.");
    }

    public static void three() {
        System.out.println("This is a desk.\n"
                + "On the desk, there are Post-it notes intended to remind someone to 'be cruel to students'.");
    }

    public static void next() {
        System.out.println("What do you look at (or do)?\n"
                + "(1) Look at puddle\n"
                + "(2) Look at paper\n"
                + "(3) Look at wooden object\n"
                + "(4) Make a guess at what kind of room");
    }
}
