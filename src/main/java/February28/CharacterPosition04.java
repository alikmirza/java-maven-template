package February28;

import java.util.*;
import java.util.stream.IntStream;

public class CharacterPosition04 {
        public static void main(String[] args) {
            String origin = "Alphabet";
            HashMap<Character, List<Integer>> map = new HashMap<>();

            IntStream.range(0, origin.length()).forEach(i -> {
                char c = origin.charAt(i);
                List<Integer> positions = map.getOrDefault(c, new ArrayList<>());
                positions.add(i);
                map.put(c, positions);

            });

            TreeMap<Character, List<Integer>> sorted = new TreeMap<>(map);
            for (Map.Entry<Character, List<Integer>> entry : sorted.entrySet())
                System.out.printf("Letter = %s , position = %s\n",entry.getKey(), entry.getValue());
        }
}
