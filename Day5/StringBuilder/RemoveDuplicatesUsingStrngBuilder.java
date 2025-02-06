package Day4.StringBuilder;

import java.util.HashSet;

public class RemoveDuplicatesUsingStrngBuilder {
    public static void main(String[] args) {
        String name = "ShreyaguptaSg";
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(char ch: name.toCharArray()){
            if(!set.contains(ch)){
                set.add(ch);
                sb.append(ch);
            }
        }

        System.out.println("String without duplicates is :" + sb.toString());

    }
}
