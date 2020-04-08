package lesson29;

public class StringOp {
    public static String shift(String origin, int toLeft, int toRight){
        String first;
        String updated;
        first=left(origin,toLeft);
        updated=right(first,toRight);
        return updated;
    }

    static String left(String origin, int left) {
        return origin.substring(left) + origin.substring(0, left);
    }
    static String right(String origin, int right) {
        return left(origin, origin.length() - right);
    }

    public static void main(String[] args) {
        StringOp stringOp=new StringOp();
        String ex="Hello";
        System.out.println(stringOp.shift(ex,1,1));

    }

}
