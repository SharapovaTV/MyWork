import com.sun.xml.internal.ws.util.UtilException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class MaxSum1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите минимум диапазона ");
        int min = Integer.parseInt(reader.readLine());
        System.out.print("Введите максимум диапазона ");
        int max = Integer.parseInt(reader.readLine());
        System.out.print("Введите размер последовательности ");
        int size = Integer.parseInt(reader.readLine());
        System.out.print("Введите размер подпоследовательности ");
        int sub = Integer.parseInt(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        MaxSum1.listCreation(min, max, size, list); // заполнение последовательности
        System.out.println("Последовательность чисел ");
        MaxSum1.listPrint(list); // вывод последовательности на экран

        HashMap <Integer, Object> mapSub = new HashMap<>(); // разбивка последовательности на подпоследовательности
        MaxSum1.subCreation(list, sub, mapSub);
        System.out.println("Подпоследовательности последовательности чисел ");
        System.out.println(mapSub.toString()); // вывод на экран - сумма подпоследовательности + подпоследовательность
        Integer maxKey = Collections.max(mapSub.keySet());
        System.out.println("Максимальная сумма " + maxKey);
        reader.close();
    }

     //заполнение последовательности
     public static ArrayList<Integer> listCreation(int min, int max, int size, ArrayList<Integer> list) {
         int diapason = max + Math.abs(min) + 1;
         for (int i = 0; i < size; i++) {
             int l = (int)((Math.random() * diapason) - max);
             list.add(i, l);
         }
         return list;
     }

    //разбивка последовательности на подпоследовательности + суммы каждой подпоследовательности
    public static HashMap subCreation(ArrayList<Integer> list, int sub, HashMap listSub) {
        for(int i = 0; i < list.size() - (sub - 1); i++) {
            ArrayList<Integer> list1 = new ArrayList<>();
            int sum = 0;
            for (int j = i; j < i + sub; j++) {
                list1.add(list.get(j));
                sum = sum + list.get(j);
            }
            listSub.put(sum, list1); // может быть одинакавая сумма!!! не учла!!!
        }
        return listSub;
    }

    //вывод на экран
    public static void listPrint(ArrayList list) {
        for(Object x : list) {
            System.out.println(x + " ");
        }
    }
}
