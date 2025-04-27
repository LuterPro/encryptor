package runapplication;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunApplication {
    static int cipherShift;
    private static final String ENCRYPT = "1 - Закодировать текст";
    private static final String DECRYPT = "2 - Раскодировать текст";
    private static final String BRUT_FORCE = "3 - Раскодировать текст методом перебора";
    private static final String EXIT = "0 - Передумал :)";
    private static final String FILE_FROM_DIRECTORY_ON_PC = "1 - Укажу путь к файлу на моём ПК";
    private static final String FILE_FROM_NAME = "2 - Укажу имя файла";

    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                Приветствую тебя!
                
                Добро пожаловать в приложение для шифрования/дешифрования!""");
        System.out.println("_____________________________________________________________________________");
        Thread.sleep(1000);
        System.out.println("""
                Ниже Вам представлен список доступных операций!
                
                Выберите пожалуйста действие, напишите номер операции и нажмите "Enter":""");
        System.out.println(ENCRYPT + "\n" +
                DECRYPT + "\n" +
                BRUT_FORCE + "\n" +
                EXIT);
        System.out.print("Ваш выбор: ");

        int userChoice;
        Scanner userInput = new Scanner(System.in);

        if (!userInput.hasNextInt()) {
            System.out.println("Введите пожалуйста номер операции из приведенных!");
        } else {
            userChoice = userInput.nextInt();
            switch (userChoice) {
                case 0: {
                    System.out.println("До свидания!");
                    break;
                }
                case 1: {
                    System.out.println("Откуда будем брать текст?\n" +
                            FILE_FROM_DIRECTORY_ON_PC + "\n" +
                            FILE_FROM_NAME + "\n" +
                            EXIT);
                    System.out.print("Ваш выбор: ");
                }
            }
        }
    }
}