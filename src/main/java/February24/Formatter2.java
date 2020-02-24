package February24;

public class Formatter2 extends Formatter {

    String s;
    Formatter2(String s){
        this.s=s;
    }
    @Override
    public String toString(){
        return String.format("%s",s.toUpperCase());
    }

    @Override
    void print(String s, Formatter f) {
        System.out.println(s.toUpperCase());
    }
}
