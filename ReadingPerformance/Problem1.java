package ReadingPerformance;

import java.io.*;

public class Problem1 {
    public static final String FILE_PATH = "largeFile.txt";

    public static void main(String[] mmg) throws IOException
    {
      long fileReaderTime = Filereader();
      long inputstreamReaderTime = inputstreamReader();

        System.out.println("Performance Results: ");
        System.out.println("Time taken by File Reader :"+ fileReaderTime);
        System.out.println("Time taken by Input Stream Reader : "+ inputstreamReaderTime);

    }
    public static long Filereader() throws IOException
    {
        long start = System.nanoTime();
         try(FileReader reader = new FileReader(FILE_PATH))
         {
             while(reader.read()!=-1);
         }
          long end = System.nanoTime();
         return (end - start)/1_000_000;
    }
    public static long inputstreamReader() throws IOException
    {
       long start = System.nanoTime();
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(FILE_PATH), "UTF-8")) {
            while (reader.read() != -1);  // Reads one byte at a time and converts to character
        }
        long end = System.nanoTime();
        return (end-start)/1_000_000;
    }
}
