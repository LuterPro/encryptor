package filemaneger;

import java.io.IOException;
import java.nio.file.*;

public class FileManager {
    //    private static final String FILE_NOT_FOUND = "Извините, такого файла нет :(";
//    private static final String ACCESS_DENIED = "Извините, похоже у Вас нет доступа к файлу :(";
//    private static final String IS_NOT_FILE = "Извините, Вы не указали на сам файл :(";
    private static final String CODING_COMPLETE = "Кодирование успешно завершено! Результат сохранен в ";
    private static final Path PATH_OF_ENCODE =
            Paths.get(Path.of("src/resources/Encoded_text.txt").toUri());
    private static final Path PATH_OF_DECODE =
            Paths.get(Path.of("src/resources/Decoded_text.txt").toUri());
    private static final Path PATH_OF_DECODE_BY_BRUTFORCE =
            Paths.get(Path.of("src/resources/Decoded_text_by_brutforce.txt").toUri());

    public String fileReader(String pathName) throws IOException {
        Path path = Paths.get(Path.of(pathName).toUri());

        return Files.readString(path);
    }

    public void fileWriter(String text, int mode) throws IOException {
        switch (mode) {
            case 1:
                Files.writeString(PATH_OF_ENCODE, text);
                System.out.println(CODING_COMPLETE + PATH_OF_ENCODE);
                break;
            case 2:
                Files.writeString(PATH_OF_DECODE, text);
                System.out.println(CODING_COMPLETE + PATH_OF_DECODE);
                break;
            case 3:
                Files.writeString(PATH_OF_DECODE_BY_BRUTFORCE, text);
                System.out.println(CODING_COMPLETE + PATH_OF_DECODE_BY_BRUTFORCE);
                break;
            default:
                System.out.println("Unknow error");
                break;
        }
    }

}
