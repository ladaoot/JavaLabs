package lab5;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkRefactor {
    public static void main(String[] args) {
        String text= "link izhlife.ru/psychology/karty-taro-istoriya-poyavleniya-i-kak-gadat-onlayn.html , " +
                "other link skillbox.ru/media/design/figma-files-1/, h4.ru";
        Pattern pattern = Pattern.compile("[a-z\\d-.]+\\.[a-z.]{2,5}(/[a-z\\d%-_.?=&@#]*)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String link = "https://"+matcher.group();
            text=text.replace(matcher.group(),link);
        }
        System.out.println(text);
    }
}
