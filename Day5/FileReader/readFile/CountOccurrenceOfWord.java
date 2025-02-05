package Day4.FileReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurrenceOfWord {
    public static void main(String[] args) {
        try{
            FileReader fr = new FileReader("myFile.txt");
            BufferedReader buffer = new BufferedReader(fr);
            int count =0;
            String target ;
            String targetString = "Welcome";
            while((target = buffer.readLine())!=null){
                String words[] = target.split("\\W+");
                for(String word: words){
                    if(word.equals(targetString)){
                        count++;
                    }
                }

            }
            System.out.println("Target " + targetString + " appered for " + count + " times" );
            fr.close();
        }
        catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }
}
