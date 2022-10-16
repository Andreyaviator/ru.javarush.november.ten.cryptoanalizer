package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class DecStAnaliz {
    private String textFromOutput1;

    DecStAnaliz() {
    }

    void decStAn(Path path) throws IOException {
        textFromOutput1 = Files.readString(path);
        String textFromOutput = textFromOutput1.toLowerCase();
        char[] array = textFromOutput.toCharArray();
        int c = 0;
        int b = 0;
        ArrayList<Character> array10 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            array10.add(array[i]);
        }
        Map<Character, Integer> al = new TreeMap<>();
        for (int i = 0; i < Alphavit.alphavitAsList.size(); i++) {
            al.put(Alphavit.alphavitAsList.get(i), 0);
        }
        for (int i = 0; i < array10.size(); i++) {
            for (Map.Entry<Character, Integer> pair : al.entrySet()) {
                Character key = pair.getKey();
                Integer value = pair.getValue();
                if (array10.get(i).equals(key)) {
                    al.put(key, value = value + 1);
                }
            }
        }
        al = CustomComparator.sortByValues(al);
//         for(Map.Entry<Character, Integer> pair: al.entrySet())
//         {
//             Character key = pair.getKey();
//             Integer value = pair.getValue();
//             System.out.println(key + " --> " + value);
//         }
        ArrayList<Character> resultArray = new ArrayList<>();

        Character firstKey = (Character) al.keySet().toArray()[2];
        int number1 = Alphavit.alphavitAsList.indexOf(firstKey);
        System.out.println("======================================================");
        System.out.println("           Расшифрованный текст:");
        int deltaKey = 0;
        boolean cicleIndex;
        int delta = 0;
        int[] arAlphavit = {5, 41, 15, 1, 9, 13};  // массив индексов часто встречающихся букв
        int i = 0;
        do {
            if(i > 5)
                break;
            delta = arAlphavit[i];                     // ввод индекса буквы
            if ((number1 - delta) > 0) {
                deltaKey = number1 - delta;
            } else if ((number1 - delta) < 0) {
                deltaKey = Alphavit.alphavitAsList.size() - Math.abs(number1 - delta);
            } else if (deltaKey == 0) {
                deltaKey = Alphavit.alphavitAsList.size() - 1;
            }

            for (int a = 0; a < array10.size(); a++) {
                if (Alphavit.alphavitAsList.contains(array10.get(a))) {
                    int rrr = Alphavit.alphavitAsList.indexOf(array10.get(a));
                    int sas = rrr - deltaKey;
                    if (sas > (Alphavit.alphavitAsList.size() - 1)) {
                        resultArray.add(Alphavit.alphavitAsList.get(sas - Alphavit.alphavitAsList.size()));
                    } else if (sas < 0) {
                        resultArray.add(Alphavit.alphavitAsList.get(Alphavit.alphavitAsList.size() - Math.abs(sas)));
                    } else
                        resultArray.add(Alphavit.alphavitAsList.get(sas));
                }
            }

            for (int k = 0; k < resultArray.size(); k++) {
                System.out.print(resultArray.get(k));
            }
            System.out.println();
            System.out.println("Вас устраивает данный вариант расшифровки?");
            System.out.println("Выберите 1 - устраивает; 2 - неустраивает");
            Scanner sc11 = new Scanner(System.in);
            int nn = sc11.nextInt();
            if (nn == 2) {
                i = i + 1;
                cicleIndex = true;
                resultArray.clear();
            } else {
//                sc11.close();
                cicleIndex = false;
            }
        }
        while (cicleIndex == true);
    }
}

class CustomComparator<K, V extends Comparable> implements Comparator<K> {
    private Map<K, V> map;

    public CustomComparator(Map<K, V> map) {
        this.map = new HashMap<>(map);
    }

    @Override
    public int compare(K s1, K s2) {
        return map.get(s2).compareTo(map.get(s1));
    }

    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                return map.get(k2).compareTo(map.get(k1));
            }
        };
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}
