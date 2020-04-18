package ArrayList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ArrayExample {
    ArrayList<Integer> list=new ArrayList<>();
    //ArrayList<Integer> temp=new ArrayList<>();
    public ArrayList<Integer> joinLists(ArrayList arrayList1, ArrayList arrayList2){
        for (int i=0;i<arrayList1.size();i++){
            list.add((Integer) arrayList1.get(i));
        }
        for (int i=0;i<arrayList2.size();i++){
            if(!(list.contains(arrayList2.get(i)))){
            list.add((Integer) arrayList2.get(i));
            //temp.add((Integer) a);
            }
        }
        return list;
    }
}
