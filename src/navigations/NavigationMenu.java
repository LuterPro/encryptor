package navigations;

import constants.Constant;
import encoder.Encoder;
import exeptions.WorkWithFileException;
import filemaneger.FileManager;

import java.io.IOException;
import java.util.Scanner;

public class NavigationMenu {
    private static final Scanner SCANNER = new Scanner(System.in);

    private static int cipherShift;
    private static String pathOfFile;
    private static int currentMode;
    private static final String HEADER = """
            Ниже Вам представлен список доступных операций!
            
            Выберите пожалуйста действие, напишите номер операции и нажмите "Enter":""";
    private static final String END = "До свидания!";
    private static final String SEPARATOR = "_____________________________________________________________________________";
    private static final String ENCRYPT = "1 - Закодировать текст";
    private static final String DECRYPT = "2 - Раскодировать текст";
    private static final String BRUT_FORCE = "3 - Раскодировать текст методом перебора";
    private static final String EXIT = "0 - Передумал :)";
    private static final String BACK = "9 - Назад";
    private static final String CHOICE = "Ваш выбор: ";
    private static final String CIPHER_INPUT = "Введите число для кодирования: ";
    private static final String WRONG_CHOICE = "Введите пожалуйста номер операции из перечисленных в меню!";
    private static final String FILE_FROM_DIRECTORY_ON_PC = "1 - Укажу путь к файлу на моём ПК";
    private static final String FILE_FROM_NAME = "2 - Использовать файл по умолчанию";
    private static final String FILE_PATH_INPUT = "Введите путь к файлу, вместе с его именем и расширением: ";

    public static String getSeparator() {
        return SEPARATOR;
    }

    public static void showMainMenu() throws InterruptedException, IOException, WorkWithFileException {
        while (true) {
            System.out.println(SEPARATOR);
            System.out.println(HEADER);
            System.out.println(ENCRYPT);
            System.out.println(DECRYPT);
            System.out.println(BRUT_FORCE);
            System.out.println(EXIT);
            System.out.print(CHOICE);

            if (!SCANNER.hasNextInt()) {
                System.out.println(WRONG_CHOICE);
                System.out.println(SEPARATOR);
                Thread.sleep(1000);
                SCANNER.nextLine();
                continue;
            }

            int choice = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (choice) {
                case 0: {
                    System.out.println(END);
                    System.exit(0);
                }
                case 1: {
                    while (true) {
                        currentMode = 1;
                        System.out.print(CIPHER_INPUT);

                        if (!SCANNER.hasNextInt()) {
                            System.out.println(WRONG_CHOICE);
                            System.out.println(SEPARATOR);
                            Thread.sleep(1000);
                            SCANNER.nextLine();
                            continue;
                        }
                        cipherShift = SCANNER.nextInt();
                        SCANNER.nextLine();
                        showCryptMenu();
                    }
                }
                case 2: {
                    while (true) {
                        currentMode = 2;
                        System.out.print(CIPHER_INPUT);

                        if (!SCANNER.hasNextInt()) {
                            System.out.println(WRONG_CHOICE);
                            System.out.println(SEPARATOR);
                            Thread.sleep(1000);
                            SCANNER.nextLine();
                            continue;
                        }
                        cipherShift = SCANNER.nextInt();
                        SCANNER.nextLine();
                        showCryptMenu();
                    }
                }
                case 3: {
                    currentMode = 3;
                    showCryptMenu();
                }
                default:
                    currentMode = 0;
                    System.out.println(WRONG_CHOICE);
                    System.out.println(SEPARATOR);
            }
        }
    }

    public static void showCryptMenu() throws WrongThreadException, WorkWithFileException, IOException, InterruptedException {
        while (true) {
            System.out.println(HEADER);
            System.out.println(FILE_FROM_DIRECTORY_ON_PC);
            System.out.println(FILE_FROM_NAME);
            System.out.println(BACK);
            System.out.println(EXIT);
            System.out.print(CHOICE);

            if (!SCANNER.hasNextInt()) {
                System.out.println(WRONG_CHOICE);
                System.out.println(SEPARATOR);
                Thread.sleep(1000);
                SCANNER.nextLine();
                continue;
            }

            int choice = SCANNER.nextInt();
            SCANNER.nextLine();

            switch (choice) {
                case 0: {
                    System.out.println(END);
                    System.exit(0);
                }
                case 1: {
                    System.out.print(FILE_PATH_INPUT);
                    pathOfFile = SCANNER.nextLine();
                    FileManager fileManager = new FileManager();
                    String currentText = fileManager.fileReader(pathOfFile);
                    if (currentMode == 1) {
                        String encodeResult = Encoder.encode(cipherShift, currentText);
                        fileManager.fileWriter(encodeResult, currentMode);
                    }
                    if (currentMode == 2) {
                        //cipherShift = -cipherShift;
                        String encodeResult = Encoder.encode(-cipherShift, currentText);
                        fileManager.fileWriter(encodeResult, currentMode);
                    }
                    if (currentMode == 3) {
                        int alphabetSize = Constant.getAlphabetForSearchByIndex().size();
                        String partOfCurrentText = currentText.substring(0, 20);
                        int variant;
                        for (int i = 1; i < alphabetSize; i++) {
                            System.out.println("Вариант декодирования фрагмента текста №" + i +
                                    " : " + Encoder.encode(-i, partOfCurrentText));
                        }

                        System.out.println(SEPARATOR);
                        System.out.println("Введите номер приемлемого варианта, " +
                                "для декодирования всего текста: ");

                        if (!SCANNER.hasNextInt()) {
                            System.out.println(WRONG_CHOICE);
                            System.out.println(SEPARATOR);
                            Thread.sleep(1000);
                            SCANNER.nextLine();
                            continue;
                        }

                        variant = SCANNER.nextInt();
                        SCANNER.nextLine();

                        String encodeResult = Encoder.encode(-variant, currentText);
                        fileManager.fileWriter(encodeResult, currentMode);
                    }
                }
                case 2: {
                    if (currentMode == 1) {
                        FileManager fileManager = new FileManager();
                        pathOfFile = "src/resources/Original_text.txt";
                        String currentText = fileManager.fileReader(pathOfFile);
                        String encodeResult = Encoder.encode(cipherShift, currentText);
                        fileManager.fileWriter(encodeResult, currentMode);
                    }

                    if (currentMode == 2 || currentMode == 3) {
                        FileManager fileManager = new FileManager();
                        pathOfFile = "src/resources/Encoded_text.txt";
                        String currentText = fileManager.fileReader(pathOfFile);

                        if (currentMode == 2) {
                            //cipherShift = -cipherShift;
                            String encodeResult = Encoder.encode(-cipherShift, currentText);
                            fileManager.fileWriter(encodeResult, currentMode);
                        }

                        if (currentMode == 3) {
                            int alphabetSize = Constant.getAlphabetForSearchByIndex().size();
                            String partOfCurrentText = currentText.substring(0, 20);
                            int variant;
                            for (int i = 1; i < alphabetSize; i++) {
                                System.out.println("Вариант декодирования фрагмента текста №" + i +
                                        " : " + Encoder.encode(-i, partOfCurrentText));
                            }

                            System.out.println(SEPARATOR);
                            System.out.println("Введите номер приемлемого варианта, " +
                                    "для декодирования всего текста: ");

                            if (!SCANNER.hasNextInt()) {
                                System.out.println(WRONG_CHOICE);
                                System.out.println(SEPARATOR);
                                Thread.sleep(1000);
                                SCANNER.nextLine();
                                continue;
                            }

                            variant = SCANNER.nextInt();
                            SCANNER.nextLine();

                            String encodeResult = Encoder.encode(-variant, currentText);
                            fileManager.fileWriter(encodeResult, currentMode);
                        }
                    }
                }
                case 9:
                    pathOfFile = "";
                    currentMode = 0;
                    showMainMenu();
                default:
                    pathOfFile = "";
                    currentMode = 0;
                    System.out.println(WRONG_CHOICE);
                    System.out.println(SEPARATOR);
            }
        }
    }
}
