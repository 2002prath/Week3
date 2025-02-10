package StringConcatenationPerformance;
import java.util.Scanner;
public class Problem1 {


    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of inputs ");
        int N = sc.nextInt();

        long stringTime = string(N);
        long stringBuilderTime = stringBuilder(N);
        long stringBufferTime = stringBuffer(N);

        System.out.println("Time taken by String : \n"+ stringTime+"ms");
        System.out.println(" Time taken by String Builder : \n"+ stringBuilderTime+"ms");
        System.out.println("Time taken by String Buffer : \n"+ stringBufferTime+"ms");

        sc.close();
    }
    public static long string(int N)
    {
        long start = System.nanoTime();
        String str = "";
        for(int i=0;i<N;i++)
        {
            str = str + "a";
        }
        long end = System.nanoTime();
        return end-start/1000_000_000;
    }
    public static long stringBuilder(int N)
    {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder(N);
        for(int i=0;i<N;i++)
        {
            sb.append("a");
        }
        long end = System.nanoTime();
        return end-start/1000_000_000;
    }
    public static long stringBuffer(int N)
    {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer(N);
        for(int i=0;i<N;i++)
        {
            sb.append("a");
        }
        long end = System.nanoTime();
        return end-start/10_00_000_000;
    }
}
