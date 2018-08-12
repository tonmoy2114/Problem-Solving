import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    private static final String[] testCases = new String[]{"Unique", "Has repeat", "abcdefghABCDEFGH1234", "", null};

    public static void main(String args[]) {
        for (String str : testCases) {
            System.out.println("Is Unique: " + isUnique(str));
        }
    }

    public static boolean isUnique(String str) {
        if (str == null || str.length() < 0) return true;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            if (!set.add(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}