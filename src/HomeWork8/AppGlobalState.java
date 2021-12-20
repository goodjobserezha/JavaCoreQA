package HomeWork8;

import HomeWork7.Weather;

import java.sql.*;

public class AppGlobalState {  // создали класс для сохранения данных, хранилище информации
    // Singleton это паттерн, который подсказывает у класса есть только один объект

    // Создаем базу данных:
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;

    private static Statement statement;

    private static PreparedStatement insertWeatherPreparedStatement;

    private static AppGlobalState instance;

    public String cityName1;    //здесь имя города

    private String cityKey;

    public String getCityName1() {

        return cityName1;
    }

    public static Connection getConnection() {

        return connection;
    }

    public static Statement getStatement(){
        return statement;
    }

    public static PreparedStatement getInsertWeatherPreparedStatement() {

        return insertWeatherPreparedStatement;
    }

    public void setCityName1(String cityName1) {

        this.cityName1 = cityName1;
    }

    public String getCityKey() {

        return cityKey;
    }

    public void setCityKey(String cityKey) {

        this.cityKey = cityKey;
    }

    public String getDbName() {

        return "weather-app.db";
    }


    private AppGlobalState() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:c:\\sqlite\\"+getDbName()); // Важно верно написать расположение базы данных
            statement = connection.createStatement();
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS weather(" +
                    "date TEXT NOT NULL,city TEXT NOT NULL, temp TEXT NOT NULL, text TEXT NOT NULL);");
            insertWeatherPreparedStatement = connection.prepareStatement(
                    "INSERT INTO weather (date, city, temp, text) VALUES (?,?,?,?);"
            );



        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.exit(1); // выход с ошибкой
        }
    }
    public static AppGlobalState getInstance () {
        if (instance == null) {
            instance = new AppGlobalState();
        }
        return instance;
    }


    public String getApiKey() {

        return "H6ldpZ8Uej2NF2cOGdMmZa5wo1wWr0vq";
    }
}
