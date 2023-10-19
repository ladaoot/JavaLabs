package lab3;

public class Main {
    public static void main(String[] args) {

        //Создание объектов типа Contact
        Contact contact = new Contact("Sam","samwin@mail.com", "Kansas");

        Contact contact1 = new Contact();

        Contact contact2 = new Contact("Dean", "deanwin@main.com","Kansas");

        Contact contact3 = new Contact("Ruby","daemon@mail.com","HellTown");

        //Создание экземпляра класса
        HashTable<String,Contact> hashTable = new HashTable<>();

        //Вывод информации об экземпляое класса
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.size());

        //Запись данных в hashtable
        hashTable.put("+7777777777", contact);
        hashTable.put("899999999", contact1);
        hashTable.put("666666666", contact2);
        hashTable.put("999666999", contact3);

        //Вывод данных о hashtable
        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.size());

        //Получение данных по ключу
        System.out.println(hashTable.get("999666999"));

        //Удаление значения по ключу
        System.out.println(hashTable.size());
        hashTable.remove("999666999");
        System.out.println(hashTable.get("999666999"));
        System.out.println(hashTable.size());
    }
}
