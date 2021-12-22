package HomeWork8;

import HomeWork8.IUserInterface;
import HomeWork8.UserInterface;

public class Application {
    public static void main(String[] args) {

        IUserInterface ui = new UserInterface();

        ui.showMenu();


    }
}