package RecursiveAndItterative;

public class Problem1 {


    public static void main(String[] args)
    {
      int N =21;

      long start1 = System.nanoTime();
      recursion(N);
      long end1 = System.nanoTime();

      long start2 = System.nanoTime();
      itteration(N);
      long end2 = System.nanoTime();

        System.out.println("Recursion and itteration test Results : \n");
        System.out.println("-------------------------------------------------------");
        System.out.println("\n Results of Recursion :" + (end1-start1)/1000_000+ "ms");
        System.out.println("----------------------------");
        System.out.println("\n Results of Itteration : "+ (end2-start2)/1_000_000+ "ms");
        System.out.println("*************************************************************");
    }
    public static long recursion(int N)
    {
        if(N<=1)
            return N;
        else
        {
            return  recursion(N-1) + recursion(N-2);
        }

    }
    public static long itteration(int n)
    {
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long temp = curr;
            curr = prev + curr;
            prev = temp;
        }
        return curr;
    }
}
