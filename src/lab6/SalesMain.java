package lab6;

public class SalesMain {
    public static void main(String[] args) {
        Sales s = new Sales();

        s.addSale("Apple",2);
        s.addSale("Peach",1);
        s.addSale("Banana",3);
        s.addSale("Cucumber",6);

        s.getAllSales();
        System.out.println(s.getCountSales());

        s.addSale("Peach",8);

        s.getAllSales();
        System.out.println(s.getCountSales());
        System.out.println(s.mostPopularProduct());
    }
}
