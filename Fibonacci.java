import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**.
*
* This program will read an multiple lines of string from the a input file.
* If the data is valid then it will calculate the value at the index
* in the fibonacci sequence and write the result to an output file.
*
* @author Remy Skelton
* @version 1.0
* @since 2025-04-23
*/

final class Fibonacci {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
    */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */

    public static void main(final String[] args) throws Exception {
        // Print the welcome message
        System.out.println("Welcome to the Fibonacci program!");
        System.out.print("This program reads multiple lines");
        System.out.print(" of strings from input.txt, if valid it will ");
        System.out.print("calculates the value at the index in the fibonacci ");
        System.out.println("sequence, and writes the result to output.txt.");

        // Read from input.txt
        File inputFile = new File("input.txt");
        Scanner scanner = new Scanner(inputFile);

        // Make outputWriter to write to output.txt
        FileWriter outputWriter = new FileWriter("output.txt");

        // Create outputStr
        String outputStr = "";

        // While loop to read String from input.txt
        while (scanner.hasNextLine()) {

            // Set line equal to the next line
            String line = scanner.nextLine();

            // Split the line by spaces to see if there are multiple numbers
            String[] lineNumbers = line.split(" ");

            // Go through each number in the line
            for (String numberStr : lineNumbers) {
                // Check if the number
                try {
                    // Make the string into an integer
                    int number = Integer.parseInt(numberStr);

                    // Check if the number is negative
                    if (number < 0) {
                        // Print an error message
                        outputStr += "Invalid: "
                                + numberStr
                                + " is not a valid positive integer.\n";

                        // Restarts the loop if the number is negative
                        continue;
                    } else {
                        // Call the recFactorial method
                        int valueFibb = recFib(number);

                        // Add the Fibonacci result to the output string
                        outputStr += "The value in the Fibonacci Sequence at "
                                + number
                                + " = " + valueFibb
                        + "\n";
                    }

                } catch (NumberFormatException e) {
                    // Print an error message
                    outputStr += "Invalid: "
                            + numberStr
                            + " is not a valid integer.\n";
                    continue;
                }
            }

        }

        // Write the output string to output.txt
        outputWriter.write(outputStr);

        // Print the factorial results to the console
        System.out.println("Factorial results written to output.txt.");

        // Close the scanner
        scanner.close();

        // Close the output writer
        outputWriter.close();
    }

    /**.
     * This method calculates the Fibonacci number at the given index.
     *
     * @param number The index in the Fibonacci sequence
     * @return The Fibonacci number at the given index
     */
    public static int recFib(final int number) {
        // Check if the number is less than or equal to 1
        if (number <= 1) {
            // Return the number
            return number;
        } else {
            // Return the sum of the last 2 term in the Fibonacci sequence
            return recFib(number - 1) + recFib(number - 2);
        }
    }
}
