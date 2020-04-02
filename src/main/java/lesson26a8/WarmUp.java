package lesson26a8;

import java.util.Arrays;
import java.util.Random;

public class WarmUp {
    public static void main(String[] args) {
        int[] list=new Random().ints(30,10,50).toArray();
        int minSum=list[0]+list[1];
        int minIndex = 0;
        for (int i = 2; i <list.length-1 ; i++) {
            int minSumNext=list[i]+list[i+1];
            if (minSum>minSumNext){
                minIndex=i;
                minSum=minSumNext;
            }
        }
        System.out.println(Arrays.toString(list));
        System.out.printf("First number: %d\nSecond number: %d\n",list[minIndex],list[minIndex+1]);
        System.out.printf("Index: %d\n",minIndex);
        System.out.printf("Min sum: %d",minSum);
    }
}
