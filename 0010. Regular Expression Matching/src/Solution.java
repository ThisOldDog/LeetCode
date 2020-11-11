import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author qingsheng.chen@hand-china.com
 */
public class Solution {
    public enum PatternType {
        CONSTANT,
        ANY_CHARACTER,
        ANY_NUMBER
    }

    public static class Pattern {
        PatternType patternType;
        char value;

        public Pattern(PatternType patternType, char value) {
            this.patternType = patternType;
            this.value = value;
        }
    }

    public static boolean isMatch(String s, String p) {
        List<Pattern> patterns = parserPattern(p);
        return isMatch(s.toCharArray(), 0, patterns, 0, false);
    }

    private static boolean isMatch(char[] chars, int charIndex, List<Pattern> patterns, int patternIndex, boolean matchBreak) {
        if (charIndex == chars.length && patternIndex == patterns.size()) {
            return true;
        }
        if (patternIndex == patterns.size()) {
            return false;
        }
        Pattern pattern = patterns.get(patternIndex);
        switch (pattern.patternType) {
            case CONSTANT:
                return charIndex < chars.length && chars[charIndex] == pattern.value
                        && isMatch(chars, charIndex + 1, patterns, patternIndex + 1, false);
            case ANY_CHARACTER:
                return charIndex < chars.length
                        && isMatch(chars, charIndex + 1, patterns, patternIndex + 1, false);
            case ANY_NUMBER:
                if (charIndex < chars.length && (chars[charIndex] == pattern.value || pattern.value == '.')) {
                    for (int i = charIndex; i < chars.length && (chars[i] == pattern.value || pattern.value == '.'); i++) {
                        boolean isMatch = isMatch(chars, i + 1, patterns, patternIndex + 1, true);
                        if (isMatch) {
                            return true;
                        }
                        if (matchBreak) {
                            break;
                        }
                    }
                }
                return isMatch(chars, charIndex, patterns, patternIndex + 1, false);
        }
        return false;
    }

    public static List<Pattern> parserPattern(String pattern) {
        if (pattern == null || pattern.length() == 0) {
            return Collections.emptyList();
        }
        List<Pattern> patterns = new ArrayList<>();
        char[] chars = pattern.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] >= 'a' && chars[i] <= 'z') || chars[i] == '.') {
                if (i < chars.length - 1) {
                    if (chars[i + 1] == '*') {
                        patterns.add(new Pattern(PatternType.ANY_NUMBER, chars[i]));
                        continue;
                    }
                }
                patterns.add(chars[i] == '.'
                        ? new Pattern(PatternType.ANY_CHARACTER, chars[i])
                        : new Pattern(PatternType.CONSTANT, chars[i]));
            }
        }
        return patterns;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("bbbba", ".*a*a"));
    }
}
