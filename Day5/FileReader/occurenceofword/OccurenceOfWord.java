package org.example.filereader.occurenceofword;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OccurenceOfWord {
    public static void main(String[] args) {
        String filePath = "C:\\College\\Capgemini\\Week03\\Day05\\src\\main\\java\\org\\example\\filereader\\occurenceofword\\sample";

        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            String word = "Java";
            int count = 0;
            while((line = br.readLine()) != null){
                for(String s: line.split(" ")){
                    if(s.equals(word)){
                        count++;
                    }
                }
            }

            System.out.println("Occurence of the word \"" + word + "\" is " + count);

            br.close();
        }
        catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
