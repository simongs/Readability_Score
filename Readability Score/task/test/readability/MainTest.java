package readability;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainTest extends TestCase {

    @Test
    public void test() {
        String test = "12, 12 13 14 14 14, 12 21 23 89! 75 12, 241 123, 123 123 123, 123 123 123? 123, 123 123 123 23 123 213 123 123 123.";

        String[] split = test.split("[\\.\\?\\!]");

        System.out.println(split.length);

        Arrays.stream(split).forEach(System.out::println);

        List<Main.SentenceInfo> collect = Arrays.stream(split).filter(i -> !i.isEmpty()).map(i -> new Main.SentenceInfo(i.trim())).collect(Collectors.toList());

        collect.stream().forEach(i -> System.out.println(i.getWordCount()));

        /*OptionalDouble average = collect.stream().mapToInt(i -> i.getWordCount()).average();
        System.out.println(average.getAsDouble());*/
        OptionalDouble average = collect.stream().mapToInt(i -> i.getWordCount()).average();

        if (average.getAsDouble() > 10D) {
            System.out.println("HARD");
        } else {
            System.out.println("EASY");
        }
    }

    @Test
    public void test2() {
        /*String test = "12, 12 13 14 14 14, 12 21 23 89";

        String[] split = test.split("\\s+");*/

        //String str = " Hello I'm your String";
        //String str = "12 12 13 14 14 14 12 21 23 89";

        String str = "12, 12 13 14 14 14 12, 21 23 89";

        String[] splitStr = str.split("[  ]");

        //String[] splitStr = Pattern.compile(" ").split(str);

        Arrays.stream(splitStr).forEach(System.out::println);


    }

}