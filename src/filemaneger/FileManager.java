package filemaneger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {
    private static final String FILE_NOT_FOUND = "Извините, такого файла нет :(";
    private static final String IS_NOT_FILE = "Извините, Вы не указали на сам файл :(";

    public String fileReader(String pathName) throws IOException {
        Path path = Paths.get(pathName);

        if (!Files.exists(path)) {
            throw new NoSuchFileException(FILE_NOT_FOUND);
        }

        if (!Files.isRegularFile(path)) {
            throw new IllegalArgumentException(IS_NOT_FILE);
        }

        return Files.readString(path);
    }

    public void fileWriter(String text) {

    }

}
