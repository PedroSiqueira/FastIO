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

    public static boolean ready() throws java.io.IOException {
        if (zx != null && zc >= zx.length()) {
            zx = input.readLine();
            zc = 0;
        }
        return zx != null;
    }

    //le da entrada uma string ate (mas nao incluido) c, depois de descartar quaisquer c's a esquerda. se a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace.
    static String readUntil(String c) throws java.io.IOException {
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (ready() && c.indexOf(zx.charAt(zc)) != -1) zc++;//descarta c's a esquerda
        if ("\n\r".contains(c) && zx != null) {
            zv = zc;
            zc = zx.length();
        } else for (zv = zc; zc < zx.length() && c.indexOf(zx.charAt(zc++)) == -1;);
        return zx != null ? zx.substring(zv) : null;
    }

    static java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2097152);
    static int zb, zc = 0, zv;
    static String zx = "";
}
