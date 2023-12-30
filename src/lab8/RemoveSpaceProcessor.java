package lab8;

public class RemoveSpaceProcessor {
    @DataProcessor
    public String remove(String text){
        return text.replaceAll("\\s+","");
    }
}
