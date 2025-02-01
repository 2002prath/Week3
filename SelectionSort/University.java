package SelectionSort;

public class University {

    public static void selectionSort(int[] a)
    {
        for(int i=0;i<a.length-1;i++)
        {
            int min =i;
            for( int j=i+1;j<a.length;j++)
            {
                if(a[min]>a[j])
                {
                    min = j;
                }
            }
              int temp = a[min];
              a[min] = a[i];
              a[i] = temp;
        }
    }
     public static void main(String[] aamg)
     {
         int[] a = {89,95,99,100,98};
         selectionSort(a);
         System.out.println("Marks in ascending order :");
         for(int i=0;i<a.length;i++)
         {
             System.out.print(a[i] + " ");
         }
     }
}



