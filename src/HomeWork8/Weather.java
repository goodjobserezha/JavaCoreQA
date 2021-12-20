package HomeWork8;

public class Weather {

    private String date;
    private String city;
    private String temperature;
    private String weatherText;

    public Weather(String date, String city, String temperature, String weatherText) {
        this.date = date;
        this.city = city;
        this.temperature = temperature;
        this.weatherText = weatherText;
    }

    public Weather() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    @Override
    public String toString() {
        return "\nНа дату "+ date + " в искомом городе " + city + " ожидается погода " + weatherText + " с температурой окружающего воздуха " +temperature+" градусов Цельсия.";
    }


}
