package LinearSearch;

public class Problem2 {
    public static String found(String[] statement,String term)
    {
         for(String line : statement)
         {
             if(line.contains(term))
             {
                 return line;
             }
         }
       return "Not found";
    }
         public static void printStatement(String[] sentence){
            for(int i=0;i<sentence.length;i++)
            {
                System.out.println(sentence[i]);
            }
        }

    public static void main(String[] args) {
        String[] sentence = {"I am pratham mishra","I can do it","God is with me"};
        String word = "can";
        String result = found(sentence,word);


        System.out.println("Input array of sentences :");
        printStatement(sentence);

        System.out.println("\n Final output: \n" +result);
    }
}
