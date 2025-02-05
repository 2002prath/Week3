package FileReader;
    import java.io.*;

public class Problem1
  {



        public static void main(String[] args) {
            // Define the file path (make sure the file exists)
            String filePath = "example.txt";

            // Declare FileReader and BufferedReader objects
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;

            try {
                // Create FileReader and wrap it in BufferedReader
                fileReader = new FileReader(filePath);
                bufferedReader = new BufferedReader(fileReader);

                String line;
                // Read each line using readLine() method
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);  // Print the line to the console
                }
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


