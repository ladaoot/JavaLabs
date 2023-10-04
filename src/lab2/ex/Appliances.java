package lab2.ex;

public class Appliances extends Technic {
    private String color;
    private String country;
    private int weight;
    private int countObject = 0;

    public Appliances() {
        super();
        color = "Black";
        country = "China";
        weight = 20;
        countObject++;
        printInfo();
    }

    public Appliances(String color, String country, int weight) {
        this.color = color;
        this.country = country;
        this.weight = weight;
        printInfo();
    }

    public Appliances(String color, String country, int weight, String size, double period, String power) {
        super(size, period, power);
        this.color = color;
        this.country = country;
        this.weight = weight;
        countObject++;

        printInfo();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCountObject() {
        return countObject;
    }


    public void printInfo() {
        System.out.println("Был создан экземпляр класса ");
        System.out.println("Appliances{" +
                "color=" + color + '\n' +
                ", country=" + country + '\n' +
                ", weight=" + weight + '\n' +
                ", size=" + super.getSize() + '\n' +
                ", power=" + super.getPowerConsumption() + '\n' +
                ", warranty period=" + super.getWarrantyPeriod() + '\n' +
                '}');
    }


}
