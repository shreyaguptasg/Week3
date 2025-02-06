package Day4.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class writeFile {
    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("myFile.txt");
            for (int i = 0; i < 100000000; i++) {
                fw.write("Welcome to java ");
            }
            fw.close();
            System.out.println("Success");
        } catch (IOException e) {
            System.out.println("Exception occured");
        }
    }
}
