package February28;

import java.util.Random;

public class february12App {
    public static void main(String[] args) {
        int[] array1=new int[30];
        int[] array2=new int[30];

        int sum1=0;
        int sum2=0;
        int count1=0;
        int count2=0;
        for(int i=0;i<array1.length;i++){
            array1[i]=(int)((Math.random() *40-20))*2;
            sum1+=array1[i];
        }

        for(int j=0;j<array2.length;j++){
            array2[j]=(int)((Math.random() *40-20))*2+1;
            sum2+=array2[j];
        }
        System.out.println(sum1+" "+sum2);
        System.out.println(sum1+sum2);

        }
    }
