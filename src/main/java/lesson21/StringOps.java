package lesson21;

public class StringOps {

    // a-zA-Z ONLY
    // abc -> ABC
    // aBc -> AbC
    // Abc -> aBC
    String invertCaseV1(String origin) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if (c >= 'a') sb.append((char)(c-32));
            else sb.append((char)(c+32));
        }
        return sb.toString();
    }

    String invertCaseV2(String origin) {
        char[] chars = origin.toCharArray();
        for (int i=0; i < chars.length; i++) {
            char c = origin.charAt(i);
            if (c >= 'a') chars[i] = (char)(c - 32);
            else chars[i] = (char)(c + 32);
        }
        return new String(chars);
    }

    String invertCaseV3(String origin) {
        char[] chars = origin.toCharArray();
        for (int i=0; i < chars.length; i++) {
            char c = origin.charAt(i);
            chars[i] = (c >= 'a') ? (char)(c - 32) : (char)(c + 32);
        }
        return new String(chars);
    }

    String invertCaseV4(String origin) {
        char[] chars = origin.toCharArray();
        for (int i=0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ 32); // bit XOR operation
        }
        return new String(chars);
    }

    // abc -> ABC
    // aBc -> ABC
    // Abc -> ABC
    String toUpperCase(String origin) { // a -> A A -> A
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if (c >= 'a') sb.append((char)(c-32));
            else sb.append(c);
        }
        return sb.toString();
    }

    String toUpperCaseV2(String origin) { // a -> A A -> A
        char[] chars = origin.toCharArray();
        for (int i=0; i < chars.length; i++) {
            int bit=0b00100000;
            int mask= ~bit;
            chars[i] = (char) (chars[i] & mask); // bit XOR operation
        }
        return new String(chars);
    }

    // abc -> abc
    // aBc -> abc
    // Abc -> abc
    String toLowerCase(String origin) { // A -> a a -> a
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if (c >= 'a') sb.append(c);
            else sb.append((char)(c+32));
        }
        return sb.toString();
    }

    String toLowerCaseV2(String origin) { // A -> a a -> a
        char[] chars = origin.toCharArray();
        for (int i=0; i < chars.length; i++) {
            int bit=0b00100000;
            chars[i] = (char) (chars[i] | bit);
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new StringOps().toLowerCaseV2("HelloWorld"));
        System.out.println(new StringOps().toUpperCaseV2("helloworld"));
        int k= 100<<2;
        System.out.println(k);
    }
}
