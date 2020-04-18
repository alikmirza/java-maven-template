package lesson25a7;

import java.util.*;

public class WarmUp {
    public static void main(String[] args) {
        int array[]=new Random().ints(50,10,25).toArray();
        int counter=0;
        int temp=0;
        int j;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
            for (j=0; j <array.length; j++) {
                Map<Integer,Integer> map=new HashMap<>();
                temp = array[j];
                map.put(0,array[j]);
                j++;
                if (temp == array[i]) {
                    counter++;
                }
            }
        }
        System.out.printf("\nNumber: %d , appears %d times",temp,counter);

    }
}
