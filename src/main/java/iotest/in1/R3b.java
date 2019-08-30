/**
 * BufferedInputStream. apenas le linhas de ate 8192 chars
 */
package iotest.in1;

public class R3b {

    static long total = 0;

    private static void ReadLines() throws java.io.IOException {
        String s;
        while (ready()) {
            s = readUntil("\n");
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
        if (zc >= zv) {
            zv = input.read(zx);
            zc = 0;
        }
        return zv > 0;
    }

    //le da entrada uma string ate (mas nao incluido) c, depois de descartar quaisquer c's a esquerda. se a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace.
    static String readUntil(String c) throws java.io.IOException {
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (ready() && c.indexOf(zx[zc]) != -1) zc++;//descarta c's a esquerda
        for (zb = 0; ready() && c.indexOf(zx[zc]) == -1; zn[zb++] = zx[zc++]);
        return zb > 0 ? new String(zn, 0, zb) : null;
    }

    static byte[] zx = new byte[2097152], zn = new byte[8192];
    static int zc = 0, zv = -2, zb;
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
