package ArrayList;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {
        ArrayExample arrayExample=new ArrayExample();

        ArrayList<Integer> list1=new ArrayList<Integer>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2=new ArrayList<Integer>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);

        System.out.println(arrayExample.joinLists(list1,list2));
    }
}
