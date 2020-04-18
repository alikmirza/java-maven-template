package March04;

import javax.xml.xpath.XPath;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class SVOApp {
    public static void main(String[] args) throws FileNotFoundException {

        Optional<List<String>> part2 = read("C:\\Users\\mirza\\IdeaProjects\\java-maven-template\\verb_obj1_.txt");
        Optional<List<String>> part1 = read("C:\\Users\\mirza\\IdeaProjects\\java-maven-template\\subj_verb_.txt");
//        System.out.println(part1);
//        System.out.println(part2);
       // HashMap<String, List<String>> subj_verb = separate(part1);
       // HashMap<String, List<String>> verb_obj = separate(part2);
        // combine(subj_verb, verb_obj);
    }

    private static void combine(HashMap<String, List<String>> subj_verb, HashMap<String, List<String>> verb_obj) {
        for (String s : subj_verb.keySet())
            for (String v : subj_verb.get(s))
                for (String o : verb_obj.get(v))
                    System.out.println(new Sentence(s, v, o));
    }

    private static HashMap<String, List<String>> separate(List<String> list) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String row : list) {
            String[] halves = row.split(":");
            String[] splitted = halves[1].split(",");
            String[] trimmed = new String[splitted.length];
            for (int i = 0; i < splitted.length; i++) {
                trimmed[i] = splitted[i].trim();
            }
            List<String> words = Arrays.asList(trimmed);
            map.put(halves[0], words);
        }
        return map;
    }


    private static void write(List<String> lines, String filename) throws IOException {
        File file = new File(filename);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String line : lines) {
            bw.write(line);
            bw.write("\n");
        }
    }

    private static Optional<List<String>> read(String filename) throws FileNotFoundException {
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            return Optional.of(br.lines().collect(Collectors.toList()));
        }catch (FileNotFoundException e){
            System.out.println("The file does not exists");
            return Optional.empty();
        }

    }
}

