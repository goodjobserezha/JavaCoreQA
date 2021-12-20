package HomeWork8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import HomeWork8.AppGlobalState;

import java.io.IOException;

public class AccuWeatherCityCodeProvider implements ICityCodeProvider {
// так как этот класс будет выходить в сеть, то ему обязательно потребуется клиент http, а также ключ API key

    private static final String BASE_HOST = "dataservice.accuweather.com"; // наш базовый хост, с которым устанавливаем соединение
    private static final String LOCATIONS_SERVICE_PATH = "locations"; //
    private static final String API_VERSION = "v1";
    private static final String API_KEY = AppGlobalState.getInstance().getApiKey();


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getCodeByCityName(String cityName) throws IOException {
        //http://dataservice.accuweather.com/locations/v1/cities/autocomplete?apikey={{accuweatherApiKey}}&q=Brest

        // начинаем сборку URL:
        HttpUrl detectLocationUrl = new HttpUrl.Builder()  // конструктор нашего URL
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS_SERVICE_PATH)
                .addPathSegment(API_VERSION)
                .addPathSegment("cities")
                .addPathSegment("autocomplete") // после знака вопроса "?" должны добавить QueryParameter
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("q", cityName)
                .build();

        // начинаем сборку запроса (request):
        Request detectLocationRequest = new Request.Builder()  // конструктор
                .addHeader("accept", "application/json") // именно здесь application/json понимаем, что будем работать с "JSON"
                .url(detectLocationUrl)
                .build();

        // выполняем наш запрос (request):

        Response response = client.newCall(detectLocationRequest).execute(); // создали объект ответа на запрос
        // в ответе нам присылается варианты городов в массиве с искомым названием
        if (!response.isSuccessful()) {
            throw new IOException("Сетевая ошибка\n");
        }

        String jsonBody = response.body().string();

        if (objectMapper.readTree(jsonBody).size() < 1) { // если в массиве элементы отсутствуют (равны 0), значит город не найден
            throw new IOException("Города с таким названием не нашлось\n"); // readTree - чтение древа JSONa ответа Маппером
        }

        String cityTitle = objectMapper.readTree(jsonBody).get(0).at("/LocalizedName").asText(); // взяли 1-ый элемент массива - это имя
        String countryTitle = objectMapper.readTree(jsonBody).get(0).at("/Country/LocalizedName").asText();// взяли 2-й элемент массива - это страна

        String cityKey = objectMapper.readTree(jsonBody).get(0).at("/Key").asText(); //взяли ключ города
        System.out.println("_____________________");

        System.out.printf("Поиск завершен. Город %s в стране %s!\n", cityTitle, countryTitle);
        System.out.println("_____________________");
        AppGlobalState.getInstance().setCityName1(cityTitle);// требуется записать название города


        AppGlobalState.getInstance().setCityKey(cityKey); // требуется записать ключ города

    }


}