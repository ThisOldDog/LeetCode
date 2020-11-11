import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 废柴 2020/11/5 11:46
 */
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        return ladderLength(endWord, wordList, new HashSet<>() {{
            add(beginWord);
        }}, new HashSet<>(), 1);
    }

    private int ladderLength(String endWord, List<String> wordList, Set<String> arrive, Set<String> exclude, int i) {
        if (arrive.contains(endWord)) {
            return i;
        } else if (arrive.size() == 0) {
            return 0;
        } else {
            Set<String> nextArrive = new HashSet<>();
            exclude.addAll(arrive);
            for (String a : arrive) {
                for (String word : wordList) {
                    if (!exclude.contains(word) && oneCharacterDifference(word, a)) {
                        nextArrive.add(word);
                    }
                }
            }
            return ladderLength(endWord, wordList, nextArrive, exclude, i + 1);
        }
    }

    private boolean oneCharacterDifference(String s1, String s2) {
        int cnt = 0;
        char[] c1 = s1.toCharArray(), c2 = s2.toCharArray();
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] == c2[i]) {
                cnt++;
            }
        }
        return cnt == s1.length() - 1;
    }

    // "qa"
    //"sq"
    //["si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"]
    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("qa", "sq",
                Arrays.asList("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")));
    }
}
