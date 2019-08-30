/**
 * BufferedInputStream with StringBuilder.
 */
package iotest.in1;

public class R3a {

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
        if (qc >= ql) {
            ql = input.read(qb);
            qc = 0;
        }
        return ql > 0;
    }

    //le da entrada uma string ate (mas nao incluido) c, depois de descartar qualquer whitespace a esquerda. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace.
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (ready() && qb[qc] <= ' ') qc++;//descarta c's a esquerda
        for (qn.setLength(0); ready() && c.indexOf(qb[qc]) == -1; qn.appendCodePoint(qb[qc++]));
        return qn.toString();
    }

    static byte[] qb = new byte[2097152];//buffer
    static int qc = 0, ql = -2;//currentChar e length
    static StringBuilder qn = new StringBuilder(128);//linhas na media com 128 caracteres
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
