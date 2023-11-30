package lab4;

public class Person {
    private int age;

    public void setAge(int age) throws CustomAgeException {

        if (age < 0 || age >= 120) {
            throw new CustomAgeException("Возраст не корректен ");
        }
        this.age = age;
    }
}
