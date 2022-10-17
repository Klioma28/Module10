package Module10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Task3 {
    {
        HashMap<String, Integer> words = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream("words.txt");
            Scanner sc = new Scanner(fis);
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] strings = str.strip().split(" ");
                for (String s: strings) {
                    if (words.containsKey(s)) words.replace(s, words.get(s)+1);
                    else words.put(s, 1);
                }
            }
            sc.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        LinkedHashMap<String, Integer> sorted = sortHashMapByValues(words);
        System.out.println(sorted.toString());
    }

    public LinkedHashMap<String, Integer> sortHashMapByValues(
            HashMap<String, Integer> passedMap) {
        List<String> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues, Collections.reverseOrder());
        Collections.sort(mapKeys, Collections.reverseOrder());

        LinkedHashMap<String, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<String> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                String key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }
}
