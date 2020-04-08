package lesson29;

public class StringOp {
    public static String shift(String origin, int toLeft, int toRight){
        String ex;
        if (toLeft != 0)
        ex=left(origin,toLeft);
        else
        ex=right(origin,toRight);
        return ex;
    }

    static String left(String origin, int left)
    {
        return origin.substring(left) + origin.substring(0, left);
    }
    static String right(String origin, int right)
    {
        return left(origin, origin.length() - right);
    }

    public static void main(String[] args) {
        StringOp stringOp=new StringOp();
        String ex="Hello";
        System.out.println(stringOp.shift(ex,5,5));

    }

}
