package InputStreamReader;
    import java.io.*;

public class Problem2 {



        public static void main(String[] args) {
            // Create necessary stream objects for reading and writing
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);  // To read from the console
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  // To read input efficiently
            FileWriter fileWriter = null;  // To write input to the file
            BufferedWriter bufferedWriter = null;

            try {
                // Create FileWriter and BufferedWriter to write data to a file
                fileWriter = new FileWriter("user_input.txt", true);  // true to append to the file
                bufferedWriter = new BufferedWriter(fileWriter);

                System.out.println("Enter text to write to the file. Type 'exit' to stop.");

                String input;
                // Continue reading user input until "exit" is entered
                while (true) {
                    input = bufferedReader.readLine();  // Read input from the user

                    if (input.equalsIgnoreCase("exit")) {
                        break;  // Exit the loop if the user types "exit"
                    }

                    // Write the input to the file followed by a newline
                    bufferedWriter.write(input);
                    bufferedWriter.newLine();
                }

                System.out.println("User input written to 'user_input.txt'.");

            } catch (IOException e) {
                System.out.println("An error occurred while reading or writing to the file: " + e.getMessage());
            } finally {
                try {
                    // Close the BufferedReader and BufferedWriter to free resources
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (bufferedWriter != null) {
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing streams: " + e.getMessage());
                }
            }
        }
    }


