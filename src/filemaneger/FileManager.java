package filemaneger;

import exeptions.WorkWithFileException;

import java.io.IOException;
import java.nio.file.*;

public class FileManager {
    private static final String FILE_NOT_FOUND = "Извините, такого файла нет :(";
    private static final String ACCESS_DENIED = "Извините, похоже у Вас нет доступа к файлу :(";
    private static final String IS_NOT_FILE = "Извините, Вы не указали на сам файл :(";
    private static final String FILE_IS_EMPTY = "Извините, выбранный файл пуст:(";
    private static final String CODING_COMPLETE = "Кодирование успешно завершено! Результат сохранен в ";
    private static final Path PATH_OF_ENCODE =
            Paths.get(Path.of("src/resources/Encoded_text.txt").toUri());
    private static final Path PATH_OF_DECODE =
            Paths.get(Path.of("src/resources/Decoded_text.txt").toUri());
    private static final Path PATH_OF_DECODE_BY_BRUT_FORCE =
            Paths.get(Path.of("src/resources/Decoded_text_by_brut_force.txt").toUri());

    //метод для чтения файлов
    public String fileReader(String pathName) throws WorkWithFileException, IOException {
        Path path = Paths.get(Path.of(pathName).toUri());
        if (Files.isDirectory(path)) {
            throw new WorkWithFileException(IS_NOT_FILE);
        }
        if (Files.size(path) == 0) {
            throw new WorkWithFileException(FILE_IS_EMPTY);
        } else {
            try {
                return Files.readString(path);
            } catch (NoSuchFileException e) {
                throw new WorkWithFileException(FILE_NOT_FOUND, e);
            } catch (AccessDeniedException adE) {
                throw new WorkWithFileException(ACCESS_DENIED, adE);
            } catch (IOException ioE) {
                throw new WorkWithFileException();
            }
        }
    }

    //метод для записи в файл
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
                Files.writeString(PATH_OF_DECODE_BY_BRUT_FORCE, text);
                System.out.println(CODING_COMPLETE + PATH_OF_DECODE_BY_BRUT_FORCE);
                break;
            default:
                System.out.println("Что-то явно пошло не так!");
                break;
        }
    }

}
