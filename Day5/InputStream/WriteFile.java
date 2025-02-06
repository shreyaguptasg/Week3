package Day4.InputStream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("example.txt");
            for (int i = 0; i < 1000; i++) {
                fw.write("Welcome to java ");
            }
            fw.close();
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("Exception occured");
        }
    }
}
