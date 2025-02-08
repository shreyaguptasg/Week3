package Day6.StringConcatenationPerformance;

public class StringConcatenationPerformance {
    public static void main(String[] args) {
        long startTime,endTime;
        String str1 = "java";
         startTime = System.nanoTime();
        String newstr1= "";
        for(int i=0; i<10; i++){
            newstr1+=str1;
        }
        endTime = System.nanoTime();
        System.out.println(" String operation time : " + (endTime-startTime));

        startTime= System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<10; i++){
            builder.append(str1);
        }
        endTime = System.nanoTime();
        System.out.println(" String builder operation time : " + (endTime-startTime));

        startTime= System.nanoTime();
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<10; i++){
            buffer.append(str1);
        }
        endTime = System.nanoTime();
        System.out.println(" String buffer operation time : " + (endTime-startTime));

    }
}
