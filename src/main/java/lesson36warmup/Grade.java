package lesson36warmup;


import java.util.Arrays;
import java.util.List;

public class Grade {

    public static List<Integer> grad(List<Integer> grades){
        for(int i = 0;i<grades.size();i++){
            if (grades.get(i)>37 && grades.get(i) %5 > 2){
                int newNumber = grades.get(i) + (5-grades.get(i) %5);
                grades.set(i,newNumber);
            }
        }
        return grades;



    }

    public static void main(String[] args) {
        System.out.println(grad(Arrays.asList(73,67,38,33)));
    }
}
