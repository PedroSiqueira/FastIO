/**
 * BufferedReader only
 */
package iotest.in1;

public class R1j {

    static long total = 0;

    private static void ReadLines() throws java.io.IOException {
        String s;
        while (input.ready()) {
            s = input.readLine();
            for (int i = 0; i < s.length(); i++)
                total += s.charAt(i);
        }
    }

    public static void main(String args[]) throws java.io.IOException {
        long startTime = System.nanoTime();
        ReadLines();
        long stopTime = System.nanoTime();
        System.err.println((stopTime - startTime) + "\t" + total);
    }

    static java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2097152);
}
