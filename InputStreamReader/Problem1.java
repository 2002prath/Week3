package InputStreamReader;
import java.io.*;

public class Problem1
{



        public static void main(String[] args) {
            // Define the file path
            String filePath = "example.txt";  // Replace with your file path

            // Declare FileInputStream, InputStreamReader, and BufferedReader objects
            FileInputStream fileInputStream = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;

            try {
                // Create FileInputStream to read the binary data from the file
                fileInputStream = new FileInputStream(filePath);

                // Wrap the FileInputStream with InputStreamReader to convert byte stream to character stream
                inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");  // Specify charset (UTF-8)

                // Wrap the InputStreamReader with BufferedReader to read efficiently line by line
                bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                // Read each line using readLine() method and print it to the console
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);  // Print each line to the console
                }
            } catch (IOException e) {
                // Handle potential I/O errors (e.g., file not found, encoding errors)
                System.out.println("Error reading file: " + e.getMessage());
            } finally {
                try {
                    // Close the resources after use
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing resources: " + e.getMessage());
                }
            }
        }
    }



