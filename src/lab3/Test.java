package lab3;

public class Test {
    public static void main(String[] args) {
        HashTable<String, String> a = new HashTable<>();
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
        a.put("a", "a");
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
        a.put("b", "b");
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
        a.put("a", "c");
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
        a.remove("a");
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
        a.remove("b");
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
        a.put("a", null);
        System.out.println(a.get("a"));
        System.out.println(a.get("b"));
        System.out.println(a.size());
        System.out.println(a.isEmpty());
        System.out.println("---");
    }
}
