package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPCheck {
    public static void main(String[] args) {
        String password= "0.195.225.225";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d{1,2})" +
                "(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d{1,2})){3}$");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            System.out.println(matcher.group());
        }else System.out.println("IP некорректен");
    }
}
