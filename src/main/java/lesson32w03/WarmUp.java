package lesson32w03;

public class WarmUp {
    private static String dataOrdered(int R, int C, int[][] a) {
        return String.valueOf(a[R][C]);
    }

    public static void main(String[] args) {
        int[][]a =
                {
                        {  1,  2,  3 },
                        {  5,  6,  7 },
                        {  9, 10, 11 },
                        { 13, 14, 15 },
                        { 17, 18, 19 },
                        { 21, 22, 23 },
                };

        System.out.println(dataOrdered(a.length-1, a[0].length, a));
    }
}
