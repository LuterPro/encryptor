package runapplication;

import navigations.NavigationMenu;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunApplication {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("""
                Приветствую тебя!
                
                Добро пожаловать в приложение для шифрования/дешифрования!""");
        System.out.println("_____________________________________________________________________________");
        Thread.sleep(1000);

        NavigationMenu.showMainMenu();

    }
}