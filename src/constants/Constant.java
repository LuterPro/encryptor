package constants;

import java.util.Map;
import java.util.HashMap;

public class Constant {
    private static final String RUS_ALPHABET = "ЙЦУКЕЁНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ";
    private static final String ENG_ALPHABET = "QWERTYUIOPASDFGHJKLZXCVBNM";
    private static final String SYMBOLS = " `~\\|/[]{},.<>?!@#$%^&*()_+=-:;'\"";
    private static final String NUMBERS = "1234567890";
    private static final String RESULT = RUS_ALPHABET + ENG_ALPHABET + SYMBOLS + NUMBERS;
    private static final Map<Character, Integer> stringToHashmap = new HashMap<>();

    public static void main(String[] args) {
        for (int i = 0; i < RESULT.length(); i++) {
            stringToHashmap.put(RESULT.charAt(i), i);
        }
        //System.out.println(RESULT.toString());
    }
}
