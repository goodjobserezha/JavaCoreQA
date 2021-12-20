package HomeWork8;

import HomeWork8.AppGlobalState;
import HomeWork8.*;
import HomeWork8.Weather;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class Controller implements IController{

    ICityCodeProvider codeProvider = new AccuWeatherCityCodeProvider(); // поиск кода города
    IWeatherProvider weatherProvider = new AccuWeatherProvider(); // поиск погоды по коду города
    IWeatherRepository weatherRepository = new SQLiteWeatherRepository(); // архивная база данных погоды


    @Override
    public void onCityInput(String city) throws IOException {

        if(city.length() == 1) {
            throw new  IOException("Недопустимо короткое название города");
        }
        codeProvider.getCodeByCityName(city);   // вызвали у объекта AccuWeatherCityCodeProvider метод поиска кода города

    }

    @Override
    public void onCommandChosen(int selectedCommand) throws IOException, ParseException {
        System.out.println(" ");
        switch (selectedCommand) {
            case 1: {
                Weather currentWeather = weatherProvider.getCurrentWeather(AppGlobalState.getInstance().getCityKey()); // на 1 день
                System.out.println(currentWeather);
                weatherRepository.saveWeatherObject(currentWeather);
                break;
            }
            case 2: {   // получение погоды на 5 дней
                weatherProvider.getWeatherForFiveDays(AppGlobalState.getInstance().getCityKey());
                break;
            }
            case 3: {   // печатаем в консоль архив
                List<Weather> allData = weatherRepository.getAllData();
                allData.forEach(System.out::println);

                break;
            }
            default: {
                throw new IOException("Вы ввели данные неверно.\n");
            }
        }
    }

}