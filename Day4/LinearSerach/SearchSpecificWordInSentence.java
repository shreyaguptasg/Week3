package Day4.LinearSerach;

public class SearchSpecificWordInSentence {
    public static String searchWord(String s, String target){
        String [] words= s.split("\\s+");
        String str = target.toLowerCase();
        for(int i=0; i<s.length(); i++){
            if(words[i].equals(target)){
                return words[i];
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        String str= "i m a book guy and my favourite book is harry potter";
        String target= "favourite";
        System.out.println(searchWord(str, target));

    }
}
