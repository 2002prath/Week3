package BinarySearch;

public class Problem2
{
    public static int maxElement(int[] array)
    {
       for(int i=0;i<array.length-1;i++)
       {   int swap = 0;
           for(int j=0;j<array.length-1-i;j++)
           {
               if(array[j]>array[j+1])
               {
                   int temp = array[j];
                   array[j]= array[j+1];
                   array[j+1] = temp;
                   swap++;
               }
           }
           if(swap<1)
           {
               break;
           }
       }
          return array[array.length-1];
    }
    public static void main(String[] args)
    {
      int[] elements = {8,10,19,28,98,34,54,78};
       int maxElement = maxElement(elements);

        System.out.println("Maximum element of given array : "+ maxElement);
    }
}
