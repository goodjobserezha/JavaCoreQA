package HomeWork4;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        task1 ();
        task2 ();
    }


    private static void task1 (){
        String[] wordsArray = new String[]{"Создать", "массив", "с", "набором", "слов", "10-20", "слов", "должны",
                "встречаться", "повторяющиеся", "Найти", "и", "вывести", "список", "уникальных", "слов",
                "из", "которых", "состоит", "массив", "дубликаты", "не", "считаем", "Посчитать", "сколько", "раз",
                "встречается", "каждое", "слово"};
        countAndPrintUniqueWords(wordsArray);
    }

    private static void countAndPrintUniqueWords (String[] words){
        Map<String, Integer> wordsCount = new HashMap();
        for (String word : words) {
            word = word.toLowerCase();
            if (wordsCount.containsKey(word)) {
                wordsCount.put(word, wordsCount.get(word) + 1);
            } else {
                wordsCount.put(word, 1);
            }
        }
        System.out.println(wordsCount);
    }




    private static void task2 (){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(79112763591L, "Shlyshkov");
        phoneBook.add(79500470218L, "Pershin");
        phoneBook.add(79211959163L, "Alekseeva");
        phoneBook.add(79811879229L, "Sydorchuk");
        phoneBook.add(79316422140L, "Khamzaev");
        System.out.println(phoneBook.get("Shlyshkov"));
        System.out.println(phoneBook.get("Sydorchuk"));
    }

}