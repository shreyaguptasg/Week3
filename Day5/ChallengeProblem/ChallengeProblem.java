package org.example.challengeproblem;

import java.io.*;

public class ChallengeProblem {
    public static long builderTime(){
        String str = "Hello";
        int iteration = 1000000;

        StringBuilder stringBuilder = new StringBuilder();
        long startTimeBuilder = System.nanoTime();
        for (int i = 0; i < iteration; i++) {
            stringBuilder.append(str);
        }
        long endTimeBuilder = System.nanoTime();

        return endTimeBuilder - startTimeBuilder;
    }

    public static long bufferTime(){
        String str = "Hello";
        int iteration = 1000000;

        StringBuffer stringBuffer = new StringBuffer();
        long startTimeBuffer = System.nanoTime();
        for (int i = 0; i < iteration; i++) {
            stringBuffer.append(str);
        }
        long endTimeBuffer = System.nanoTime();

        return endTimeBuffer - startTimeBuffer;
    }

    public static int wordCountUsingFileReader(String filePath){
        int count = 0;
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                for(String str: line.split(" ")){
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return count;
    }

    public static int wordCountUsingInputStreamReader(String filePath){
        int count = 0;
        try {
            FileInputStream fs = new FileInputStream(filePath);
            InputStreamReader isr = new InputStreamReader(fs);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                for(String str: line.split(" ")){
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("StringBuilder performance time: " + ChallengeProblem.builderTime());
        System.out.println("StringBuffer performance time: " + ChallengeProblem.bufferTime());

        String filePath = "C:\\College\\Capgemini\\Week03\\Day05\\src\\main\\java\\org\\example\\challengeproblem\\sample";

        long startFileReader = System.nanoTime();
        System.out.println("Word count: " + ChallengeProblem.wordCountUsingFileReader(filePath));
        long endFileReader = System.nanoTime();
        System.out.println("Time Taken by File reader: " + (endFileReader - startFileReader));

        long startInputStreamReader = System.nanoTime();
        System.out.println("Word count: " + ChallengeProblem.wordCountUsingInputStreamReader(filePath));
        long endInputStreamReader = System.nanoTime();
        System.out.println("Time Taken by File reader: " + (endInputStreamReader - startInputStreamReader));
    }
}
