package lab8;

public class LengthProcessor {
    @DataProcessor
    public Integer length(String text){
        return text.length();
    }
}
