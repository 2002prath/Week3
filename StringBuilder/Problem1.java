package StringBuilder;

public class Problem1 {

    public static void main(String[] args) {
      StringBuilder sb = new StringBuilder();

      sb.append("hello");

      sb.reverse();
       String str = sb.toString();
        System.out.println(str);
    }
}
