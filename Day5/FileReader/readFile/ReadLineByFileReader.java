package Day4.FileReader;

import java.io.IOException;
import java.io.FileReader;

public class ReadLineByFileReader {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("myFile.txt")) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.println((char) i);
            }


            fr.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
