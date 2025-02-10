package Sorting;

public class Problem1 {

    public static long bubleSort(int[] array)
    {
        long start = System.nanoTime();
        for(int i=0;i<array.length-1;i++)
        {   int swap=0;
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
        long end = System.nanoTime();
        long duration = end - start;
        return duration;
    }

public static void mergeSort(int[] a,int si,int ei)
{
    if(si>=ei)
    {
        return;
    }
    int mid = si + (ei-si)/2;
    mergeSort(a,si,mid);
    mergeSort(a,mid+1,ei);
    merge(a,si,mid,ei);

}
    public static void merge(int[] a,int si,int mid,int ei)
    {
        int[] temp = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k=0;

        while(i<=mid && j<= ei)
        {
            if(a[i]<=a[j])
            {
                temp[k]= a[i];
                i++;
            }
            else
            {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while(i<=mid)
        {
            temp[k++] = a[i++];
        }
        while(j<=ei)
        {
            temp[k++]= a[j++];
        }

        for(int x=0;x<temp.length;x++)
        {
            a[si+x] = temp[x];
        }
    }

    public static void quickSort()
    {

    }
    public static void main(String[] args)
    {
        System.out.println("\n Time complexity comparison between sorting algorithms ");
        int[] array = {9,8,7,6,5,4,3,2,1,2,3,4,5,6,7,8,9,0,7,6,4,9,2,3,4,5,5,6,7,8,9,9,8,7,6,6,2,4,1,6,5,43,3,6,698,87,66,55,55,44,44,33,3356,7,8};

        System.out.println("\n -----------------========================================------------------------------------- \n");
        long bubleSortDuration = bubleSort(array);
        System.out.println("Bubble Sort : \nTime Complexity : O(n^2) ");
        System.out.println("\n Time taken by buble sot practically :"+ bubleSortDuration/1000 +"ms");
        System.out.println("\n------------------------------------------------\n \n");

        System.out.println("\n Merge Sort :");
        long start = System.nanoTime();
        mergeSort(array,0,array.length-1);
        long end = System.nanoTime();
        long MergeSortDuration = end-start;
        System.out.println("Time Complexity : O(NlogN)");
        System.out.println("Time taken by Merge Sort practically :"+ MergeSortDuration/1000 +"ms");
        System.out.println("\n------------------------------------------------------------\n \n");

    }
}
