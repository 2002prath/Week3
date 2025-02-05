package StringBuilder;

import java.util.HashSet;

public class Problem2 {

    public static String removeduplicates(String givenString)
    {
       StringBuilder sb = new StringBuilder();
       HashSet<Character> checked = new HashSet<>();

       char[] charArray = givenString.toCharArray();

          for(int i=0;i<charArray.length;i++) {
              char ch = charArray[i];
               if(!checked.contains(ch))
              {
                 sb.append(ch);
                 checked.add(ch);
              }
          }
            return sb.toString();
    }
    public static void main(String[] args) {
        String input = "Autonomous";
        String result = removeduplicates(input);

        System.out.println("Given String :"+ input);
        System.out.println("Final output after removal of duplicates : "+ result);
    }
}
