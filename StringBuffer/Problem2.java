package StringBuffer;

public class Problem2 {
    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder();
        int value = 1000000;
        String text = "hello";
        long startTimeBuilder = System.nanoTime();
        for(int i=0;i<value;i++)
        {
            builder.append(text);
        }
        long endTimeBuilder = System.nanoTime();
        long builderDuration = endTimeBuilder - startTimeBuilder;
        System.out.println("Builder Duration : "+ builderDuration/1000000);


        StringBuffer buffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for(int i=0;i<value;i++)
        {
            buffer.append(text);
        }
        long endTimeBuffer = System.nanoTime();
        long bufferDuration = endTimeBuffer - startTimeBuffer;
        System.out.println("Buffer Duration : "+ bufferDuration/1000000);
        long gap = bufferDuration/builderDuration;
        System.out.println("Difference between String buffer and String Builder "+ gap);
    }
}
