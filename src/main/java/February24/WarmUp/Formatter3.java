package February24.WarmUp;

public class Formatter3 extends Formatter {

    String s;
    Formatter3(String s){
        this.s=s;
    }



    @Override
    void print(String s, Formatter f) {
        int length=s.length();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <length+6; i++) {
            stringBuilder.append('*');
        }

        System.out.println(stringBuilder +"\n*  "+s.toUpperCase()+"  *\n"+ stringBuilder);
    }



}
