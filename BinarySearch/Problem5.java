package BinarySearch;

public class Problem5 {

    public static int postiveValue(int[] list)
    {
        for(int i=0;i<list.length;i++)
        {
            if(list[i]>0)
            {
              return list[i];
            }
        }
                  return 0;
    }

    public static int[] sorting(int[] list)
    {

        for(int i=0;i<list.length-1;i++)
        {
            int swap =0;
            for(int j=0;j<list.length-1-i;j++)
            {
              if(list[j]>list[j+1])
              {
                  int temp = list[j];
                  list[j] = list[j+1];
                   list[j+1]= temp;
                   swap++;
              }
               if(swap<1)
               {
                  break;
               }
            }
        }
        return list;
    }

    public static int targetIndex(int[] list,int target)
    {
        int[] list1 =  sorting(list);
        int left = 0;
        int right = list.length-1;
        int mid = 0 ;
        int count =0;
        for(int i=0;i<list1.length;i++)
        {
            if(target == list1[i])
                count++;
        }

        if(count >0) {
            while (mid != target) {
                mid = (left + right) / 2;
                if (list1[mid] > target) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
       return mid;
        }
        else
            return -1;

    }

    public static void main(String[] args) {
        int[] array = {-1,-2,-3,-4,-5,-6,-7,-8,9,0,0,-8-4,-2};
        int positiveNumber = postiveValue(array);
        int target = 8;
        int indexNumber = targetIndex(array,target);


        System.out.println("Positive Value through Linear Search :"+ positiveNumber);
           if(indexNumber>=0)
           {
           System.out.println("Index Value of a Target Number with the help of Binary Search "+ indexNumber);
           }
            else
               System.out.println(" Target Element Not found");

    }

}
