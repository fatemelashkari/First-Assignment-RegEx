import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;


public class Exercise3 {

    /*
    implement the method below so that it extracts a URL from a String
    I will write the basics for this one method, you will have to implement the other two methods from scratch
    */

    public static String extractURL(String text) {
        String str = "Hello, check if there is a URL or not : https://www.happy.com";
        String regex = "(https?://\\S+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return matcher.group();
        }
        else{
            return null;
        }
    }

    /*
    implement the method below to validate an email address
     */

    public static boolean validateEmail(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(regex, email);
    }

    /*
    implement the method below so that it returns a list of words with repeated letters
    */


    public static List<String> findWordsWithRepeatLetters(String text) {
        List<String> wordsWithRepeatation = new ArrayList<>();
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (hasRepeatation(word)) {
                wordsWithRepeatation.add(word);
            }
        }
        return wordsWithRepeatation;
    }

    // Helper method to check if a word has repeated letters
    private static boolean hasRepeatation(String word) {
        for (int i = 0; i < word.length(); i++) {
            char thisChar = word.charAt(i);
            for (int j = i + 1; j < word.length(); j++) {
                if (thisChar == word.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
    Bonus Problem ;)
    implement the method below so that it returns a list of words that are repeated twice accidentally in a string
    for example: "appleapple orange pearpear pineapple" -> ["appleapple", "pearpear"]
    */

    public static List<String> findReapetdWords(String inputWords) {
        List<String> repeatedWords = new ArrayList<>();
        String[] words = inputWords.split("\\s+");
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            if (wordCount.get(word) == 2) {
                repeatedWords.add(word);
            }
        }

        return repeatedWords;

    }

    public static void main(String[] args) {
        String email = "fatemelashkariii84@gmail.com";
        boolean isValidEmail = validateEmail(email);
        String text = "hello, try to make a happy day...";
        List<String> wordsWithRepeatLetters = findWordsWithRepeatLetters(text);
        // the forth one
        String words = "appleapple orange pearpear pineapple";
        List<String> repeatedWords = findReapetdWords(words);
    }
}