package homework3;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private Integer phone;
    private String surname;
    private Map<String, String> phoneBook = new HashMap<>();

    public void add(String phone, String surname) {
        phoneBook.put(phone,surname);
    }

    public void get(String surname) {
        for(Map.Entry<String, String> item : phoneBook.entrySet()){
            if(item.getValue().equals(surname)){
                System.out.printf("Фамилия: %s Телефон: %s\n", item.getValue(), item.getKey());
            }
        }
    }

}