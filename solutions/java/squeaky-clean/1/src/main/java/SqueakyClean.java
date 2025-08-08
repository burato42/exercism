import java.util.Map;

import static java.lang.Character.isLetter;
import static java.lang.Character.toUpperCase;

class SqueakyClean {
    private static final Map<Character, Character> leetspeak = Map.of(
            '4', 'a',
            '3', 'e',
            '0', 'o',
            '1', 'l',
            '7', 't'
    );

    static String clean(String identifier) {
        var strBld = new StringBuilder();
        char[] chars = identifier.toCharArray();
        int idx = 0;

        while (idx < chars.length) {
            if (chars[idx] == ' ') {
                strBld.append('_');
                idx++;
            } else if (chars[idx] == '-' && idx < chars.length - 1) {
                strBld.append(toUpperCase(chars[idx + 1]));
                idx += 2;
            } else if (chars[idx] == '-') {
                idx++;
            } else if (leetspeak.containsKey(chars[idx])) {
                strBld.append(leetspeak.get(chars[idx]));
                idx++;
            } else if (!isLetter(chars[idx])) {
                idx++;
            } else {
                strBld.append(chars[idx]);
            }
        }

    return strBld.toString();
    }
}
