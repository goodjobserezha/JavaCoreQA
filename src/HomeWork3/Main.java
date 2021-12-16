package HomeWork3;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Task 1
        Character[] mass1 = new Character[10];
        char ch = 'a';
        for (int i = 0; i < mass1.length ; i++) {
            mass1[i] = ch;
            ch++;
        }
        System.out.println(Arrays.toString(mass1));
        try {
            swap(mass1);
            System.out.println(Arrays.toString(mass1));
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }


//        Task 2
        Integer[] mass2 = new Integer[10];
        for (int i = 0; i <mass2.length; i++) {
            mass2[i] = i;
        }
        System.out.println(Arrays.toString(mass2));
        ArrayList<Object> arrayList2 = new ArrayList<Object>();
        convertArrToArrayList(mass2,arrayList2);
        for (Object o : arrayList2) {
            System.out.print(o + " ");
        }
        System.out.println();

//        Task 3
        Box<Apple> withApples = new Box<Apple>();
        withApples.addFruit(new Apple(), 30);
        Box<Orange> withOranges = new Box<Orange>();
        withOranges.addFruit(new Orange(), 20);

        System.out.println("Вес коробки с яблоками: " + withApples.getWeight());
        System.out.println("Вес коробки с апельсинами: " + withOranges.getWeight());
        System.out.println("Вес у коробок одинаковый? : " + withApples.compare(withOranges));

        Box<Apple> withApples2 = new Box<Apple>();
        System.out.println("Вес 2 коробки с яблоками: " + withApples2.getWeight());

        withApples.pourInto(withApples2);
        System.out.println("Вес 2 коробки с яблоками после пересыпки: " + withApples2.getWeight());
        System.out.println("Вес 1 коробки с яблоками после пересыпки в новую коробку: " + withApples.getWeight());


    }


    /**
     * Метод, который меняет два элемента массива местами.
     */
    static void swap(Object[] obj) throws ArrayIndexOutOfBoundsException {
        if (0 < 0 || 0 > obj.length || 9 < 0 || 9 > obj.length) {
            throw new ArrayIndexOutOfBoundsException("Введены индексы за пределами массива!" + "\n" + "Значения могут быть от 0 до " + (obj.length - 1) + ".");
        }
        Object x = obj[0];
        obj[0] = obj[9];
        obj[9] = x;
    }

    /**
     * Метод, который преобразует массив в ArrayList;
     */
    static ArrayList convertArrToArrayList(Object[]obj, ArrayList<Object> arrayList){
        for (int i = 0; i < obj.length; i++) {
            arrayList.add(obj[i]);
        }
        return arrayList;
    }

}