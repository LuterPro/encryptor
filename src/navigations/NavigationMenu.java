package navigations;

import java.util.Scanner;

public class NavigationMenu {
    private static final Scanner SCANNER = new Scanner(System.in);

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
    private static final String WRONG_CHOICE = "Введите пожалуйста номер операции из перечисленных в меню!";
    private static final String FILE_FROM_DIRECTORY_ON_PC = "1 - Укажу путь к файлу на моём ПК";
    private static final String FILE_FROM_NAME = "2 - Укажу имя файла";

    public static void showMainMenu() throws InterruptedException {
        while (true) {
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
                case 1:
                case 2:
                case 3:
                    showCryptMenu();
                default:
                    System.out.println(WRONG_CHOICE);
                    System.out.println(SEPARATOR);
            }
        }

    }

    public static void showCryptMenu() throws InterruptedException {
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
                case 9: showMainMenu();
                default:
                    System.out.println(WRONG_CHOICE);
                    System.out.println(SEPARATOR);
            }
        }
    }
}
