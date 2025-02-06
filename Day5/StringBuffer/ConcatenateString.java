package Day4.StringBuffer;

public class ConcatenateString {
    public static void main(String[] args) {
        String [] str= {"my","favourite","book","is","harry","potter"};
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length; i++){
            sb.append(str[i]);
        }
        System.out.println("The concatenated string is " + sb);

    }
}
