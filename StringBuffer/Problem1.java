package StringBuffer;
import java.util.Arrays;
public class Problem1 {
    public static String concatenate(String[] input)
    {
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<input.length;i++)
        {
            sb.append(input[i]);
            sb.append(" ");
        }
         String str = sb.toString().trim();
          return str;
    }

    public static void main(String[] args) {
        String[] input = {"Hello","My","Name","is","Pratham"};
        String result = concatenate(input);
        System.out.println("Inserted input :" + Arrays.toString(input));
        System.out.println("Final result :"+ result);
    }
}
