package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;

public class DecStAnaliz {
    public String textFromOutput1;

    public DecStAnaliz() throws IOException {
    }

    public void decStAn(Path path) throws IOException {
        textFromOutput1 = Files.readString(path);
        String textFromOutput = textFromOutput1.toLowerCase();
        char[] array = textFromOutput.toCharArray();
        int c = 0;
        int b = 0;
        ArrayList<Character> array10 = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            array10.add(array[i]);
        }
    }
}
//          Map<Character, Integer> al = new TreeMap<>();
//            for (int i = 0; i < Alphavit.alphavitAsList.size(); i++) {
//            al.put(Alphavit.alphavitAsList.get(i), 0);
//            }
//    }
//}
//
//
//
//
//
//
//
//
//  for (int i = 0; i < array10.size(); i++) {
//   for (Map.Entry<Character, Integer> pair : al.entrySet()) {
//      Character key = pair.getKey();
//     Integer value = pair.getValue();
//    if (array10.get(i).equals(key)) {
//         al.put(key, value = value + 1);
//    }
//  }
// }
//
// al = CustomComparator.sortByValues(al);
//
// Character firstKey = al.keySet().iterator().next();
// int number1 = Alphavit.alphavitAsList.indexOf(firstKey);
//// буква "о" по статистике использования в русском языке( 10,983%) имеет ндекс в alphavitAsList - 15/
// int deltaKey = 0;
// if ((number1 - 15) > 0) {
//     deltaKey = number1 - 15;
// } else deltaKey = Math.abs(number1 - 15);
//
//  ArrayList<Character> resultArray = new ArrayList<>();
//  for (int a = 0; a < array10.size(); a++) {
//     int rrr = Alphavit.alphavitAsList.indexOf(array10.get(a)) + deltaKey;
//
//    if (rrr > Alphavit.alphavitAsList.size() - 1) {
//       rrr = rrr - Alphavit.alphavitAsList.size();
//   }
//  if(rrr < 0){
//      rrr =Alphavit.alphavitAsList.size() - Math.abs(c);
//   }
//   resultArray.add(Alphavit.alphavitAsList.get(rrr));
//
// StringBuilder sb = new StringBuilder();
//  for (char o : resultArray) {
//      sb.append(o);
//  }
// String res = sb.toString();
//
//  System.out.println(res);
//
//
//  class CustomComparator<K, V extends Comparable> implements Comparator<K> {
//   private Map<K, V> map;
//
//  public CustomComparator(Map<K, V> map) {
//  this.map = new HashMap<>(map);
//  }
//
//  @Override
//  public int compare(K s1, K s2) {
//     return map.get(s2).compareTo(map.get(s1));
// }
//
//  public static <K, V> Map<K, V> sortByValues(Map<K, V> map) {
//    Comparator<K> comparator = new CustomComparator(map);
//
//   Map<K, V> sortedMap = new TreeMap<>(comparator);
//  sortedMap.putAll(map);

//    return sortedMap;
// }
// }