package homework3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] osArray = {"OS/360","Unix", "Linux", "MS-DOS", "Windows", "HP-UX", "NetWare", "FreeBSD", "Mac OS",
                "Windows", "OS/2", "CISCO IOS", "Linux", "FreeBSD", "Unix", "JunOS", "macOS", "iOS", "Android", "FreeBSD"};
        List<String> sourceOSList = new ArrayList<>(Arrays.asList(osArray));  // Исходный массив слов
        Set<String> uniqueOSSet = new HashSet<String>();                      // Для подсета уникальных слов
        Map<String, Integer> countOSMap = new HashMap<>();                   // Для подсчета сколько раз встречается солово
        Phonebook phoneBook = new Phonebook();

        Words.result(sourceOSList, "----------= Исходный массив слов =----------");
        Words.result(sourceOSList,uniqueOSSet,"----------= Массыв уникальных слов =----------");
        Words.result(sourceOSList,countOSMap,"---= Посчет сколько раз встречается каждое слово =---");

        System.out.println("----------= Телефонный Справочник =----------");
        phoneBook.add("+71234567890", "Petrov");
        phoneBook.add("+71234567891", "Ivanov");
        phoneBook.add("+71235678901", "Sidorov");
        phoneBook.add("+71236789012", "Ivanov");
        phoneBook.add("+71237890123", "Smirnov");
        phoneBook.add("+71238901234", "Kuznetsov");
        phoneBook.add("+71239012345", "Ivanov");


        // Поиск телефона по фамилии
        phoneBook.get("Ivanov");
        phoneBook.get("Kuznetsov");
    }
}
