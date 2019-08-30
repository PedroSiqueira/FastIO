/**
 * BufferedReader only
 */
package iotest.in1;

public class R5b {

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

    static String readUntil(String c) throws java.io.IOException {
        if (zc >= inputchars.length()) {
            inputchars = input.readLine();
            zc = 0;
        }
        if (inputchars == null) return null;
        else if ("\n\r".contains(c)) {
            inputauxvar = zc;
            zc = inputchars.length();
            return inputchars.substring(inputauxvar, zc);
        } else if (c == null || "".equals(c)) c = "\t\n\f\r ";
        for (inputauxvar = zc; zc < inputchars.length() && c.indexOf(inputchars.charAt(zc)) == -1; zc++);
        return inputauxvar >= zc ? null : inputchars.substring(inputauxvar, zc);
    }

    static java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2097152);
    static int inputauxvar, zc = 0;
    static String inputchars = "";
}
