import java.util.*;
public class WordFrequencyReport {
    void printFilteredWordFrequency(String feedback) {
        String[] stopWords = {"the", "was", "and", "a", "is"};
        HashSet<String> stopSet = new HashSet<>(Arrays.asList(stopWords));
        feedback = feedback.toLowerCase();
        feedback = feedback.replace(".", "");
        feedback = feedback.replace(",", "");
        String[] words = feedback.split("\\s+");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!stopSet.contains(word)) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter feedback:");
        String feedback = sc.nextLine();
        WordFrequencyReport obj = new WordFrequencyReport();
        obj.printFilteredWordFrequency(feedback);
    }
}