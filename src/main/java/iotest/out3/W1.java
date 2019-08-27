/**
 * SB.append(Object).append(Object)
 */
package iotest.out3;

public class W1 {

    private static void PrintLines() throws java.io.IOException {
        for (int i = 0; i < 1000000; i++) {
            for (int j = 0; j < 10; j++) {
                String s = randomString(5);
                print(s);//imprime uma string de 5 caracteres
                int n = (_random.nextInt(10000) + 10000);
                print(n);
            }
            print(System.getProperty("line.separator"));
        }
        flush_close();
    }

    public static void main(String args[]) throws java.io.IOException {
        long startTime = System.nanoTime();
        PrintLines();
        long stopTime = System.nanoTime();
        System.err.println((stopTime - startTime));
    }

    private static String randomString(int length) {
        StringBuilder strbld = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            strbld.append(((char) _random.nextInt(95) + 33));
        }
        return strbld.toString();
    }

    static void print(Object ob) throws java.io.IOException {
        sb.append(ob);
        if (sb.length() > 8192) {
            out.write(sb.toString().getBytes());
            sb = new StringBuilder(16384);
        }
    }

    static void flush_close() throws java.io.IOException {
        out.write(sb.toString().getBytes());
        out.flush();
        out.close();
    }

    static final java.util.Random _random = new java.util.Random(211166910);
    static java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(System.out);
    static StringBuilder sb = new StringBuilder(16384);
}
