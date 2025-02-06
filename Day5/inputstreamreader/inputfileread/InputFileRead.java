package org.example.inputstreamreader.inputfileread;

import java.io.*;

public class InputFileRead {
    public static void main(String[] args) {
        String filePath = "C:\\College\\Capgemini\\Week03\\Day05\\src\\main\\java\\org\\example\\inputstreamreader\\inputfileread\\sample";

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);

            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
