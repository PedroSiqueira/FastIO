/**
 * BufferedWriter.write(String);
 */
package iotest.out1;

public class W2a {

    static final java.util.Random _random = new java.util.Random(211166910);
    static int numLines = 1000000;
    static int numColumns = 100;

    private static void PrintLines() throws java.io.IOException {
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numColumns / 10; j++) {
                String s = randomString(5);
                int n = (_random.nextInt(10000) + 10000);
                out.write(s + n);
            }
            out.newLine();
        }
        flush_close();
    }

    public static void main(String args[]) throws java.io.IOException {
        if (args.length > 0) {
            numLines = Integer.parseInt(args[0]);
            numColumns = Integer.parseInt(args[1]);
        }
        long startTime = System.nanoTime();
        PrintLines();
        long stopTime = System.nanoTime();
        System.err.println((stopTime - startTime));
    }

    private static String randomString(int length) {
        StringBuilder strbld = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            strbld.append((char) (_random.nextInt(95) + 33));
        }
        return strbld.toString();
    }

    static void flush_close() throws java.io.IOException {
        out.flush();
        out.close();
    }

    static java.io.BufferedWriter out = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
}
