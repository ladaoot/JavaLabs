package lab5;

import java.util.regex.*;

public class FindAllNumber {
    public static void main(String[] args) {
        String text = "The price of the product is $19.99. 67 88,9 9, 65";
        Pattern pattern = Pattern.compile("\\d+\\.\\d+|\\d+,\\d+|\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
