package edu.miracosta.cs113.change;

import sun.awt.image.ImageWatched;

import java.io.*;
import java.util.LinkedList;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculator {

    public static void main(String[] args)
    {
        LinkedList<Integer> counts = new LinkedList<>();
        for (int i = 0; i < 4; i++)
        {
            counts.add(0);
        }
//        System.out.println(calculateChange(counts, 0, 75));
        printCombinationsToFile(counts, 75);
    }

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents.
     *
     * In addition to returning the number of unique combinations, this method will print out each combination to the
     * console. The format of naming each combination is up to the user, as long as they adhere to the expectation
     * that the coins are listed in descending order of their value (quarters, dimes, nickels, then pennies). Examples
     * include "1Q 2D 3N 4P", and "[1, 2, 3, 4]".
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
//    public static int calculateChange(int cents) {
//        // TODO:
//        // Implement a recursive solution following the given documentation.
//
//        int sum = 0;
//
//        LinkedList<Integer> coins = new LinkedList<>();
//        coins.add(0);
//        coins.add(0);
//        coins.add(0);
//        coins.add(cents);
//
//        if (cents == 0)
//        {
//            return 1;
//        }
//        if (cents % 5 == 0)
//        {
//            cents -= 5;
//            sum += calculateChange(cents);
//            coins.add(2, coins.get(2) + 1);
//        }
//        else if (cents % 10 == 0)
//        {
//            cents -= 10;
//            sum += calculateChange(cents);
//            coins.add(1, coins.get(1) + 1);
//        }
//        else if (cents % 25 == 0)
//        {
//            cents -= 10;
//            sum += calculateChange(cents);
//            coins.add(0, coins.get(1) + 1);
//        }
//        else
//        {
//            for (int i = 0; i < coins.size(); i++)
//            {
//                String output = "";
//                if (i == 0)
//                {
//                    output += "[" + coins.get(i) + ",";
//                }
//                else if (i == coins.size() - 1)
//                {
//                    output += coins.get(i) + "]";
//                }
//                else
//                {
//                    output += coins.get(i) + ",";
//                }
//                System.out.println(output);
//                return sum;
//            }
//        }
//
//
//        return -1;
//    }

//    public static int calculateChange(LinkedList counts, int startIndex, int cents)
//    {
//        LinkedList<Integer> coins = new LinkedList<>();
//        coins.add(25);
//        coins.add(10);
//        coins.add(5);
//        coins.add(1);
//
//        int numOfCombos = 0;
//
//        if (startIndex >= coins.size())
//        {
//            for (int i = 0; i < coins.size(); i++)
//            {
//                if (i == 0)
//                {
//                    System.out.print("[" + counts.get(i) + ",");
//                }
//                else if (i == coins.size() - 1)
//                {
//                    System.out.print(counts.get(i) + "]");
//                }
//                else
//                {
//                    System.out.print(counts.get(i) + ",");
//                }
//            }
//            System.out.print("\n");
//            return 1;
//        }
//
//        if (startIndex == coins.size() - 1)
//        {
//            if ((cents % coins.get(startIndex)) == 0)
//            {
//                counts.set(startIndex, cents / coins.get(startIndex));
//                numOfCombos += calculateChange(counts, startIndex + 1, 0);
//            }
//        }
//        else
//        {
//            for (int i = 0; i < cents / coins.get(startIndex); i++)
//            {
//                counts.set(startIndex, i);
//                numOfCombos += calculateChange(counts, startIndex + 1, cents - coins.get(startIndex) * i);
//            }
//        }
//
//        return numOfCombos;
//    }

//    public static int calculateChange(int cents, LinkedList counts) {
//        // TODO:
//        // Implement a recursive solution following the given documentation.
//
//        int numOfCombos = 0;
//
//        LinkedList<Integer> coins = new LinkedList<>();
//        coins.add(25);
//        coins.add(10);
//        coins.add(5);
//        coins.add(1);
//
//        if (cents == 0)
//        {
//            return 1;
//        }
//        if (cents % 5 == 0)
//        {
//            cents -= 5;
//            numOfCombos += calculateChange(cents, counts);
//            counts.set(2, coins.get(2) + 1);
//        }
//        else if (cents % 10 == 0)
//        {
//            cents -= 10;
//            numOfCombos += calculateChange(cents, counts);
//            counts.set(1, coins.get(1) + 1);
//        }
//        else if (cents % 25 == 0)
//        {
//            cents -= 10;
//            numOfCombos += calculateChange(cents, counts);
//            counts.set(0, coins.get(1) + 1);
//        }
//        else
//        {
//            for (int i = 0; i < coins.size(); i++)
//            {
//                String output = "";
//                if (i == 0)
//                {
//                    output += "[" + counts.get(i) + ",";
//                }
//                else if (i == coins.size() - 1)
//                {
//                    output += counts.get(i) + "]";
//                }
//                else
//                {
//                    output += counts.get(i) + ",";
//                }
//                System.out.println(output);
//                return 1;
//            }
//        }
//
//
//        return numOfCombos;
//    }

    public static int calculateChange(LinkedList<Integer> counts, int index, int cents)
    {
        LinkedList<Integer> coins = new LinkedList<>();
        coins.add(25);
        coins.add(10);
        coins.add(5);
        coins.add(1);

        int numOfCombos = 0;

        if (index >= coins.size())
        {
            for (int i = 0; i < coins.size(); i++)
            {
                if (i == 0)
                {
                    System.out.print("[" + counts.get(i) + ",");
                }
                else if (i == coins.size() - 1)
                {
                    System.out.print(counts.get(i) + "]");
                }
                else
                {
                    System.out.print(counts.get(i) + ",");
                }
            }
            System.out.print("\n");
            return 1;
        }

        if (index == coins.size() - 1)
        {
            if ((cents % coins.get(index)) == 0)
            {
                counts.set(index, cents / coins.get(index));
                numOfCombos += calculateChange(counts, index + 1, 0);
            }
        }
        else
        {
            for (int i = 0; i <= cents / coins.get(index); i++)
            {
                counts.set(index, i);
                numOfCombos += calculateChange(counts, index + 1, cents - (coins.get(index) * i));
            }
        }

        return numOfCombos;
    }

    /**
     * Calls upon calculateChange(int) to calculate and print all possible unique combinations of quarters, dimes,
     * nickels, and pennies that equal the given value in cents.
     *
     * Similar to calculateChange's function in printing each combination to the console, this method will also
     * produce a text file named "CoinCombinations.txt", writing each combination to separate lines.
     *
     * @param cents a monetary value in cents
     */
    public static void printCombinationsToFile(LinkedList<Integer> counts, int cents) {
        // TODO:
        // This when calculateChange is complete. Note that the text file must be created within this directory.
        try
        {
            PrintStream o = new PrintStream("src/edu.miracosta.cs113/change/CoinCombinations.txt");
            PrintStream console = System.out;
            System.setOut(o);
            calculateChange(counts, 0, cents);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

} // End of class ChangeCalculator