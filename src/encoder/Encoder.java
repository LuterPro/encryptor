package encoder;

import constants.Constant;
import java.util.Map;

public class Encoder {
    /*
    метод используется для кодирования и декодирования,
    при декодировании используется смещение с отрицательным значением
    */
    public static String encode(int shift, String textForEncoding) {
        Map<Integer, Character> alphabetForSearchByChar = Constant.getAlphabetForSearchByChar();
        Map<Character, Integer> alphabetForSearchByIndex = Constant.getAlphabetForSearchByIndex();
        int alphabetSize = alphabetForSearchByIndex.size();

        StringBuilder result = new StringBuilder();
        for (char abc : textForEncoding.toCharArray()) {
            if (alphabetForSearchByIndex.containsKey(abc)) {
                int currentIndex = alphabetForSearchByIndex.get(abc);
                int newIndex = (currentIndex + shift) % alphabetSize;
                if (newIndex < 0) {
                    newIndex += alphabetSize;
                }
                char newChar = alphabetForSearchByChar.get(newIndex);
                result.append(newChar);
            } else {
                result.append(abc);
            }
        }
        return result.toString();
    }
}
