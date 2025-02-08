package Day6.FileEfficiency;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargeFileReadingEfficiency {
    public static void main(String[] args) {
        long startTime, endTime;
        startTime= System.nanoTime();
        try{
            FileReader fr = new FileReader("sample.txt");
            int i;
            while((i= fr.read())!=-1){
                System.out.println((char)i);
            }
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime= System.nanoTime();
        System.out.println("FileReader time : " + (endTime-startTime));

        startTime= System.nanoTime();
        try{
            InputStreamReader isr = new InputStreamReader(new FileInputStream("sample.txt"), "UTF-8");
            int i;
            while((i=isr.read())!=-1){
                System.out.println((char)i);
            }
            isr.close();
        } catch(IOException e){
            e.printStackTrace();
        }
        endTime= System.nanoTime();
        System.out.println("InputStreamReader time :" + (endTime-startTime));
    }
}
