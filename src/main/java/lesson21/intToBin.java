package lesson21;

public class intToBin {
    public static void main(String[] args) {
        String binary = "00010011";
        //
        int value = 0;
        //System.out.println(value);

        StringBuilder bin = new StringBuilder();
        for (int i = binary.length()-1; i >= 0; i--) {
            int shifted_part = value << i;
            int one_bit = shifted_part | 1;
            bin.append(one_bit);
        }

        System.out.println(bin);
        // "00010011"
    }

    }

