package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * You will be creating an interactive chat-bot type program. Eliza is a therapist program that interacts with the user.
 * Your program will need to evaluate what the user asks and turn the user's input into a question that sounds like the
 * therapist really cares.
 *
 * <h3>Sample hedges:</h3>
 * <p>
 * Please tell me more
 * Many of my patients tell me the same thing
 * It is getting late, maybe we had better quit
 *
 * <h3>Sample qualifiers:</h3>
 * <p>
 * Why do you say that
 * You seem to think that
 * So, you are concerned that
 *
 * <h3>Replacements:</h3>
 * <p>
 * replace i with you
 * replace me with you
 * replace my with your
 * replace am with are
 * <p>
 * <p>
 * When the user enters a statement the program responds in one of two ways:
 * <p>
 * 1. With a randomly chosen hedge, such as "Please tell me more"
 * <p>
 * 2. By changing some keywords  in the user's input string an appending this string to a randomly chosen qualifier.
 * To get a random item from an array, select a random number for one of the array index values and use the value at
 * that index for your qualifier.
 * <p>
 * <p>
 * <p>
 * Here's how the replacement works:
 * <p>
 * The user enters something at the prompt: "my teacher hates me"
 * <p>
 * The program will loop through that string and replace "my" with "your" and "me" with "you" and then prepend the
 * qualifier to the replacement string. So, my teacher hates me becomes "Why do you say that your teacher hates you?"
 * The replacement method returns the same words as the user entered only the replacement words have been swapped.
 * Then the qualifier is prepended to the user's words.
 * <p>
 * Spend some time thinking how you would search through a string and replacing specific words. Hint: read about the
 * split  (Links to an external site.)Links to an external site.operator.
 */

public class Main {

    public static void main(String[] args) {
        String[] hedges = {
                "Please tell me more ",
                "Many of my patients tell me the same thing ",
                "It is getting late, maybe we had better quit "
        };

        String[] qualifiers = {
                "Why do you say that ",
                "You seem to think that ",
                "So, you are concerned that "
        };

        Map<String, String> replace = new HashMap<>();
        replace.put("i", "you");
        replace.put("me", "you");
        replace.put("my", "your");
        replace.put("am", "are");


        Scanner keyboard = new Scanner(System.in);
        String question, answer = "";
        System.out.print("Good day. What is your problem? ");

        while (true) {
            System.out.print("Enter your response here or Q to quit: ");
            question = keyboard.nextLine().toLowerCase();

            if (question.equalsIgnoreCase("I am feeling great") | question.equals("q")) {
                break;
            } else{

                int choice = 1 + (int) (Math.random() * 2);
                switch(choice){
                    case 1:
                        int i = (int) (Math.random() * hedges.length);
                        answer = hedges [i];
                        break;
                    case 2:
                        int j = (int) (Math.random() * qualifiers.length);
                        answer = qualifiers[j] + getReplacedString(replace, question);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                }
                System.out.println(answer);
            }
        }
    }
    
    public static String getReplacedString (Map replace, String question){
        String replacedString = "";
        for (String retval : question.split(" ")) {
            if (replace.containsKey(retval)) {
                replacedString += replace.get(retval) + " ";
            } else {
                replacedString += retval + " ";
            }
        }
        return replacedString;
    }
}

