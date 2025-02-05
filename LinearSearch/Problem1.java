package LinearSearch;
import java.util.Scanner;
public class Problem1 {

    public static int find(int[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            if (a[i] < 0) {

                return i;

            }

        }
                return -1;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of elements ");
        int x = input.nextInt();
        int[] a = new int[x];

        for(int i=0;i<a.length;i++)
        {
            a[i] = input.nextInt();
        }

        int firstnegativeinteger = find(a);
        System.out.println("First Negative integer index :" + firstnegativeinteger);
    }
}
