package February24;

public class Formatter1 extends Formatter {
    String s;
    Formatter1(String s){
        this.s=s;
    }

    @Override
    public String toString(){
       return String.format("%s",s.toLowerCase());
    }

    @Override
    void print(String s,Formatter f) {
        System.out.println(s.toLowerCase());
    }
}
