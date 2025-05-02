package runapplication;

import constants.Constant;
import navigations.NavigationMenu;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RunApplication {

    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("""
                Приветствую тебя!
                
                Добро пожаловать в приложение для шифрования/дешифрования!""");
        System.out.println("_____________________________________________________________________________");
        Thread.sleep(1000);

        NavigationMenu.showMainMenu();
        //System.out.println(Constant.getAlphabet().toString());

    }
}