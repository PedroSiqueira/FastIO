/**
 * BufferedOutputStream.write(sb.toString().getBytes());
 */
package iotest.out1;

public class W7 {

    static final java.util.Random _random = new java.util.Random(211166910);
    static int numLines = 1000000;
    static int numColumns = 100;

    private static void PrintLines() throws java.io.IOException {
        for (int i = 0; i < numLines; i++) {
            for (int j = 0; j < numColumns / 10; j++) {
                String s = randomString(5);
                int n = (_random.nextInt(10000) + 10000);
                sb.append(s).append(n);
            }
            sb.append(System.getProperty("line.separator"));
            FlushSb();
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
        out.write(sb.toString().getBytes());
        out.flush();
        out.close();
    }

    private static void FlushSb() throws java.io.IOException {
        if (sb.length() >= 20000) {
            out.write(sb.toString().getBytes());
            sb = new StringBuilder(25000);
        }
    }

    static StringBuilder sb = new StringBuilder(25000);
    static java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(System.out);
}
