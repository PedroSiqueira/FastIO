/**
 * BufferedInputStream, reads with read(byte[]), stores in byte[]. only reads 2M chars
 */
package iotest.in1;

public class R4b {

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

    //se ainda ha um caractere diferente de whitespace na entrada, returna true, senao, retorna false
    static boolean ready() throws java.io.IOException {
        if (zv == -2) zv = input.read(zx);
        while (zc < zv && zx[zc] <= ' ') zc++;
        return zc < zv;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        for (zb = zc; zc < zv && c.indexOf(zx[zc]) == -1; zc++);
        return zb >= zc ? null : new String(zx, zb, zc - zb);
    }

    static byte[] zx = new byte[2097152];//maximo de 2M chars
    static int zc = 0, zv = -2, zb = 0;
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
