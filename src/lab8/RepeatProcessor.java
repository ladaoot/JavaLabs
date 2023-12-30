package lab8;

public class RepeatProcessor {
    @DataProcessor
    public String repeat(String text){
        return text + text;
    }
}
