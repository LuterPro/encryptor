package constants;

import java.util.Map;
import java.util.HashMap;

public class Constant {
    private static final String RUS_ALPHABET = "ЙЦУКЕЁНГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮйцукеёнгшщзхъфывапролджэячсмитьбю";
    private static final String ENG_ALPHABET = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyiopasdfghjklzxcvbnm";
    private static final String SYMBOLS = " `~\\|/[]{},.<>?!@#$%^&*()_+=-:;'\"";
    private static final String NUMBERS = "1234567890";
    private static final String RESULT = RUS_ALPHABET + ENG_ALPHABET + SYMBOLS + NUMBERS;
    private static final Map<Integer, Character> alphabetForSearchByChar = new HashMap<>();
    private static final Map<Character, Integer> alphabetForSearchByIndex = new HashMap<>();

    //метод заполняет Map<>
    private static void stringToMap() {
        for (int i = 0; i < RESULT.length(); i++) {
            alphabetForSearchByChar.put(i, RESULT.charAt(i));
            alphabetForSearchByIndex.put(RESULT.charAt(i), i);
        }
    }

    //метод возвращает Map<> для поиска по символу
    public static Map<Integer, Character> getAlphabetForSearchByChar() {
        stringToMap();
        return alphabetForSearchByChar;
    }

    //метод возвращает Map<> для поиска по индексу
    public static Map<Character, Integer> getAlphabetForSearchByIndex() {
        return alphabetForSearchByIndex;
    }
}
