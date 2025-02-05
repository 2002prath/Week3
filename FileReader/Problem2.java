package FileReader;
    import java.io.*;

public class Problem2 {



        public static void main(String[] args) {
            // Define the file path and the word to count
            String filePath = "example.txt";
            String targetWord = "word";  // Specify the word to search for

            // Declare FileReader and BufferedReader objects
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            int wordCount = 0;

            try {
                // Create FileReader and wrap it in BufferedReader
                fileReader = new FileReader(filePath);
                bufferedReader = new BufferedReader(fileReader);

                String line;
                // Read each line using readLine() method
                while ((line = bufferedReader.readLine()) != null) {
                    // Split the line into words using whitespace as delimiter
                    String[] words = line.split("\\s+");

                    // Iterate through each word and check if it matches the target word
                    for (String word : words) {
                        if (word.equalsIgnoreCase(targetWord)) {
                            wordCount++;  // Increment the counter for each occurrence
                        }
                    }
                }

                // Output the total count of occurrences
                System.out.println("The word \"" + targetWord + "\" appears " + wordCount + " times in the file.");
            } catch (IOException e) {
                // Handle potential exceptions (e.g., file not found, IO errors)
                System.out.println("Error reading file: " + e.getMessage());
            } finally {
                try {
                    // Close the BufferedReader and FileReader to release resources
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing resources: " + e.getMessage());
                }
            }
        }
    }


