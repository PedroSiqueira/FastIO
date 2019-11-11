/**
 * BufferedInputStream, reads with read(byte[]), stores in byte[]. only reads 2M chars
 */
package iotest.in1;

public class R1l {

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

    static boolean ready() throws java.io.IOException {
        if (ql == -2) ql = input.read(qb);
        return qc < ql;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (qc < ql && qb[qc] <= ' ') qc++;
        for (qa = qc; qc < ql && c.indexOf(qb[qc]) == -1; qc++);
        return qa < ql ? new String(qb, qa, qc - qa) : "";
    }

    static byte[] qb = new byte[2097152];//buffer
    static int qc = 0, ql = -2, qa = 0;//currentChar, length, aux
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
