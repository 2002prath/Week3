package BinarySearch;

public class Problem4 {
    static int firstTime;
    static int lastTime;
    public static int[] sorting(int[] Array)
    {
        for(int i=0;i<Array.length-1;i++)
        {
            int swap =0;
            for(int j=0;j<Array.length-1-i;j++)
            {
               if(Array[j]>Array[j+1])
               {
                   int temp = Array[j];
                   Array[j]= Array[j+1];
                   Array[j+1]= temp;
               }
            }
            if(swap<1)
            {
                break;
            }
        }
       return Array;
    }
    public static int  searching(int[] Array,int target)
    {
        int left = 0;
        int right = Array.length-1;
        int operation = 0;
        while(operation<Array.length)
        {
            int mid = (left+right)/2;
            if(Array[mid]>target)
            {
               right = mid-1;
               operation++;
            }
            else if(Array[mid]<target)
            {
                left = mid+1;
                operation++;
            }
            else if(Array[mid]==target)
            {
                return 0;
            }
            else
                return -1;
        }

        return 0;
    }


    public static void main(String[] args) {
        int[] array = {1,3,4,3,8,6,6,7,4,3,7,67,1,9,3,2,7,6,6,4,6,4,6,34};
        int targetValue = 6;

          sorting(array);
          searching(array,targetValue);
    }
}
