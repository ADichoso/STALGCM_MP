import java.util.ArrayList;
public class Utilities {
    public static ArrayList<Character> stringToCharArrayList(String inputString) {
        ArrayList<Character> charArrayList = new ArrayList<Character>();
        for (int i = 0; i < inputString.length(); i++) {
            charArrayList.add(inputString.charAt(i));
        }
        return charArrayList;
    }
}