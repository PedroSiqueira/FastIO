/**
 * Scanner
 */
package iotest.in1;

public class R1 {

    static long total = 0;

    private static void ReadLines() {
        String s;
        while (input.hasNextLine()) {
            s = input.nextLine();
            for (int i = 0; i < s.length(); i++)
                total += s.charAt(i);
        }
    }

    public static void main(String args[]) {
        long startTime = System.nanoTime();
        ReadLines();
        long stopTime = System.nanoTime();
        System.err.println((stopTime - startTime) + "\t" + total);
    }

    static java.util.Scanner input = new java.util.Scanner(System.in);
}
