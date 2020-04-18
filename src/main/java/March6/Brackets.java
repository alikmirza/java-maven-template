package March6;

import java.util.Map;

public class Brackets {
    public static void main(String[] args) {
        Brackets brackets=new Brackets();
        System.out.println(brackets.calc("())"));
    }
    public int calc(String origin) { //throw new RuntimeException("should be implemented");
        int depth=0;
        int max=0;
        for (int i = 0; i <origin.length() ; i++) {
            switch (origin.charAt(i)){
                case '(':
                    depth++;break;
                case ')':
                    depth--;break;
            }
            max=Math.max(depth,max);
        }
        return max;
    }
}
