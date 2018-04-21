package SE04;

import java.util.*;

public class KeyWords {

    private static final String[] keyWordStrings = {
            "abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const",
            "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float",
            "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native",
            "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super",
            "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"
    };

    public static final Set<String> keyWordsSet = Collections.unmodifiableSet(new LinkedHashSet<>(Arrays.asList(keyWordStrings)));

    public static Map<String, Integer> countJavaKeywords(String text) {
        String[] words = text.split("\\s+");
        Map<String, Integer> tokensCount = new TreeMap<>();
        for (String word : words) {
            if (keyWordsSet.contains(word)) {
                int count = tokensCount.containsKey(word) ? tokensCount.get(word) : 0;
                tokensCount.put(word, count + 1);

            }
        }
        return tokensCount;
    }

}