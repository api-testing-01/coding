package org.fundacionjala.coding.marco;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public final class SortTheInnerContent {
    private SortTheInnerContent() {
}

    public static String sortTheInnerContent(final String words) {
        return Arrays.stream(words.split(" "))
                .map(a -> a.length() > 2 ? a.charAt(0) + a.substring(1, (a.length() - 1)).chars()
                        .mapToObj(e -> String.valueOf((char) e))
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.joining()) + a.charAt(a.length() - 1) : a)
                .collect(Collectors.joining(" "));
    }
}
