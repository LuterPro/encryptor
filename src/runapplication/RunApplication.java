package runapplication;

import exeptions.WorkWithFileException;
import navigations.NavigationMenu;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunApplication {

    public static void main(String[] args) throws InterruptedException, IOException, WorkWithFileException {
        System.out.println("""
                Приветствую тебя!
                
                Добро пожаловать в приложение для шифрования/дешифрования!""");
        System.out.println(NavigationMenu.getSeparator());
        Thread.sleep(1000);

        NavigationMenu.showMainMenu();
    }
}