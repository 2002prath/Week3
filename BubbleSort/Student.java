package BubbleSort;
import  java.util.Arrays;
public class Student {

    public static void bublesort(int[] arr)
    {
        for(int i=0;i<arr.length-1;i++)
        {
            int swap =0;
            for(int j=0;j<arr.length-1-i;j++ )
            {
                if(arr[j]>arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
            if(swap<1)
            {
                break;
            }
        }
    }
    public static void main(String[] args) {

        int[]  a = {5,4,2,9,8,12,1,5,9,8,7,6,4,3};
        bublesort(a);
        System.out.println(Arrays.toString(a));
    }
}
