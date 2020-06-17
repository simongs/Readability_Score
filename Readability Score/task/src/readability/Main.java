package readability;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String[] split = line.split("[\\.\\?\\!]");

        List<Main.SentenceInfo> collect = Arrays.stream(split).filter(i -> !i.isEmpty()).map(i -> new Main.SentenceInfo(i.trim())).collect(Collectors.toList());
        OptionalDouble average = collect.stream().mapToInt(i -> i.getWordCount()).average();

        if (average.getAsDouble() > 10D) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }

    public static class SentenceInfo {

        private String originSentence;
        private int wordCount;

        public SentenceInfo(String originSentence) {
            this.originSentence = originSentence;
            this.wordCount = Arrays.stream(originSentence.split(" ")).collect(Collectors.toSet()).size();
        }

        public int getWordCount() {
            return wordCount;
        }
    }
}
