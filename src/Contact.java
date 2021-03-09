import java.io.Serializable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Contact implements Serializable {
    static Pattern pattern = Pattern.compile("(\\+?(\\([a-z0-9]+\\))([- ][a-z0-9]{2,}[- ]?)*)|(\\+?([a-z0-9]+)([- ]\\([a-z0-9]{2,}\\))([- ][a-z0-9]{2,}[- ]?)*)|(\\+?([a-z0-9]+)([- ][a-z0-9]{2,}[- ]?)*)", Pattern.CASE_INSENSITIVE);

    public static boolean isValidNumber(String number) {
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public abstract void add(Scanner scanner);

    public abstract void edit(Scanner scanner);

    public abstract void info();

    public abstract boolean containsQuery(String query);

    public abstract String getName();
}