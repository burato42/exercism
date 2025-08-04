import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class LogLevels {
    private static final Pattern pattern = Pattern.compile("\\[(\\w+)]: (.+)");

    private static String[] getMatcher(String input) {
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            var level = matcher.group(1);
            var message = matcher.group(2);
            return new String[]{level, message};
        } 
        throw new RuntimeException("Cannot parse the input"); 
     }
       
    public static String message(String logLine) {
        return getMatcher(logLine)[1].strip();
    }

    public static String logLevel(String logLine) {
        return getMatcher(logLine)[0].toLowerCase();
    }

    public static String reformat(String logLine) {
        return message(logLine) + " (" + logLevel(logLine) + ")";
    }
}
