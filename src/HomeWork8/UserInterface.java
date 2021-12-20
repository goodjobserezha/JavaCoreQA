package HomeWork8;

import HomeWork8.Controller;
import HomeWork8.IController;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class UserInterface implements IUserInterface{

    IController controller = new Controller(); // Cоздадим объект через интерфейс, чтобы связать Controller и View с целью замены на другую реалицацию при необходимости

    @Override
    public void showMenu() {  // отображает меню в бесконечном цикле
        while (true) {
            System.out.println("\nПрограмма ARNOLD-2F начала работу.");
//           // System.out.println("Введите название города на английском языке или 'exit' для выхода"); //переделали меню, убрали старое
            System.out.println("Введите одно из значений для получения желаемых данных:"); //  *********************************
            System.out.println("\n1 - хочу знать о погоде в каком-нибудь городе\n2 - хочу получить информацию из предыдущих обращений к ARNOLD-2F\n \nвведите 'exit' для выхода");

            Scanner scanner = new Scanner(System.in);

            String menuChoice = scanner.nextLine();

            checkIsExit(menuChoice); // проверка на выполнение выхода


            if (menuChoice.equalsIgnoreCase("2")) { // при выборе значения 2 получаем сведения из архива
                try {
                    controller.onCommandChosen(3);
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Введите имя города на латинице:");
                String userResponse = scanner.nextLine();

                try { // если не будет искомого города на сервере
                    controller.onCityInput(userResponse);
                } catch (Exception e) {
                    e.printStackTrace(); // если будет ошибка - возвращаемся к запросу города
                    continue;
                }

                System.out.println("Введите команду\n1 - для получения погоды на текущий день\n2 - для получения погоды на 5 дней");


                System.out.println("----------------------------- ");
                int selectedCommand = scanner.nextInt();

                try {
                    controller.onCommandChosen(selectedCommand); // отправляем команду контроллеру
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                    continue;
                }
            }
        }
    }

    private void checkIsExit(String userResponse) {    // добавляем проверку на выход
        if (userResponse.equalsIgnoreCase("exit") ||
                userResponse.equalsIgnoreCase("выход")) {

            System.out.println("Программа ARNOLD-2F завершает работу. Всего вам доброго!");
            System.exit(0);
        }
    }
}