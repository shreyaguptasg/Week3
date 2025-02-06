package Day4.StringBuffer;

public class CompareStringBufferStringBuilderWithConcatenation {
    public static void main(String[] args) {
        long startTime, endTime;
        StringBuffer buffer= new StringBuffer();
        startTime= System.nanoTime();
        for(int i=0; i<1000000;i++){
            buffer.append("hello");
        }
        endTime= System.nanoTime();
        System.out.println("String Buffer time is : " + (endTime - startTime) + " ns");
        StringBuilder builder= new StringBuilder();
        startTime= System.nanoTime();
        for(int i=0; i<1000000; i++){
            builder.append("hello");
        }
        endTime= System.nanoTime();
        System.out.println("String Builder time is : " + (endTime-startTime) + " ns");
    }
}
