package Countletters;


import java.util.HashMap;

public class StringCount {

    void takeLetter(String str){
        HashMap hashMap=new HashMap();
        int count=0;
        int length=str.length();
        String[] arrar1=new String[length];
        String[] arrar2=new String[length];
        for (int i = 0; i <length; i++) {
            arrar1[i]= String.valueOf(str.charAt(i));
            arrar2[i]= String.valueOf(str.charAt(i));
        }
        for (String s : arrar1) {
            for (String value : arrar2) {
                if (s.equals(value)) count++;
            }
            System.out.printf("%s - %d\n", s, count);
            count = 0;
        }
    }
}
