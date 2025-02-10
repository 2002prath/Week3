package Searching;

public class Problem1 {

    public static long postiveValue(int[] list)
    {    int x=0;
        long starttime = System.nanoTime();
        for(int i=0;i<list.length;i++)
        {
            if(list[i]>0)
            {
                x = list[i];
            }
        }
        long endtime = System.nanoTime();
        long duration =   endtime- starttime;
        return duration;
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

    public static long targetIndex(int[] list,int target)
    {
        int[] list1 =  sorting(list);
        int left = 0;
        int right = list.length-1;
        int mid = 0 ;
        int count =0;
        long start = System.nanoTime();
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
        }
            long end = System.nanoTime();
            long duration = end - start;
        return duration;
    }

    public static void main(String[] args) {
        int[] array = {-1,-2,-3,-4,-5,-6,-7,-8,9,0,0,-8-4,-2};
        long time_period_linear_Search = postiveValue(array);
        int target = 8;
        long time_period_binary_Search = targetIndex(array,target);


        System.out.println("time period for a  Linear Search :"+ time_period_linear_Search);


        System.out.println("Time period for binary Search :"+ time_period_binary_Search);
        System.out.println("---------------------------------------");
        System.out.println(" binary Seach  is :" + time_period_linear_Search/time_period_binary_Search + "x faster than linear search");
    }

}

