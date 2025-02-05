package BinarySearch;

public class Problem1 {

    public static int middle(int[] array)
    {
     int left = 0;
     int right= array.length-1;
     int mid;
         while(left<right)
         {
           mid =left +  (left+ right)/2;
           if(array[mid] >array[right])
            {
              left = mid +1;
            }
            else
                right = mid;
         }
        return left;
    }


    public static void main(String[] args) {
        int targetValue = 5;
     int[] array = {1,2,3,4,5,6,7,8,9};
        int x = middle(array);
        System.out.println("Smallest value index : "+ x);
        System.out.println(" smallest  value :"+ array[x]);
    }
}
