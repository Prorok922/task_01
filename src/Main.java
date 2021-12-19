import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.stream(bufferedReader.lines().collect(Collectors.joining())
                .toLowerCase()
                .split("[\\p{Punct}\\s]+"))
             .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
             .entrySet()
             .stream()
             .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey))
                .limit(10)
                .forEach(stringLongEntry -> System.out.println(stringLongEntry.getKey()));
    }
}
