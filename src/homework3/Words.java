package homework3;

import java.util.*;

public class Words {

    public static void print(List<String> list) {
        for (int j = 0; j < list.size(); j++) {
            System.out.println(j + "." + " " + list.get(j));
        }
    }

    public static void print(Set<String> set) {
        int i = 0;
        for (String item : set) {
            System.out.println(i + "." + " " + item);
            i++;
        }
    }

    public static void print(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            System.out.printf("%s встречается: %d - раз(а)\n", item.getKey(), item.getValue());
        }
    }

    public static Set<String> initSet(List<String> list) {
        Set<String> set = new HashSet<>();
        for (int j = 0; j < list.size(); j++) {
            set.add(list.get(j));
        }
        return set;
    }

    public static Map<String, Integer> initMap(List<String> list) {
        Map<String, Integer> map = new HashMap();
        for (String item : list) {
            Integer current = map.get(item);
            map.put(item, current == null ? 1 : current + 1);
        }
        return map;
    }

    public static void result(List<String> list, String msg) {
        System.out.println(msg);
        Words.print(list);
        System.out.println("Размер: " + list.size() + " слов");
        System.out.println("---------------------------------------------\n");
    }

    public static void result(List<String> list, Set<String> set, String msg) {
        System.out.println(msg);
        set = Words.initSet(list);
        Words.print(set);
        System.out.println("Размер: " + set.size() + " слов");
        System.out.println("---------------------------------------------\n");
    }

    public static void result(List<String> list, Map<String, Integer> map, String msg) {
        System.out.println(msg);
        map = Words.initMap(list);
        Words.print(map);
        System.out.println("Размер: " + map.size() + " слов");
        System.out.println("---------------------------------------------\n");
    }
}
