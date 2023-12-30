package lab8;

public class CharProcessor {
    @DataProcessor
    public Character convert(Integer num){
        return (char) num.intValue();
    }
}
