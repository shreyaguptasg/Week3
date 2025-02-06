package Day4.StringBuilder;

public class ReverseStringUsingStringBuilder {
    public static void main(String[] args) {
        String name= "Hello2";
        StringBuilder sb = new StringBuilder(name);
        sb.reverse();
        System.out.println(sb);

    }
}
