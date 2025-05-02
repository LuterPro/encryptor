package encoder;

import constants.Constant;
import filemaneger.FileManager;

import java.io.IOException;
import java.util.Map;

public class Encoder {
    public static void encode(int shift, int mode, String textForEncoding) throws IOException {
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

        FileManager fileManager = new FileManager();
        fileManager.fileWriter(result.toString(), mode);
    }
}
