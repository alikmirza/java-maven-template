package lastlession;

import java.util.Arrays;
import java.util.Scanner;

public class february14App {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int array2[]=new int[n];
        int array7[]=new int[n];
        int array11[]=new int[n];

        for (int i=0;i<n;i++){
                    array2[i]=((int)(Math.random()*100))*2;
                    array7[i]=((int)(Math.random()*100))*7;
                    array11[i]=((int)(Math.random()*100))*11;
        }

        String toStr2= Arrays.toString(array2);
        String toStr7= Arrays.toString(array7);
        String toStr11= Arrays.toString(array11);
        System.out.print(toStr2+"\n");
        System.out.print(toStr7+"\n");
        System.out.print(toStr11);
        System.out.println();
        int k=0;

        int[] arrayCombined =new int[n*3];

        for(int i=0;i<arrayCombined.length;i+=3){
            arrayCombined[i]=array2[k];
            i++;
            arrayCombined[i]=array7[k];
            i++;
            arrayCombined[i]=array11[k];
            i-=2;
            k++;
        }


        String toStrComb=Arrays.toString(arrayCombined);
        System.out.print(toStrComb);

        int m=0;

        int[] arrayReverse=new int[n*3];
        for (int i = n*3; i >=0 ; i--) {
            arrayReverse[i]=arrayCombined[m];
            m++;
        }
        System.out.println();

        String toStrRev=Arrays.toString(arrayReverse);
        System.out.print(toStrRev);


    }
}
