/**
 * BufferedReader, le tudo de uma vez e grava em SB.
 */
package iotest.in1;

public class R2a {

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
        if (qb.length() <= 0)
            while ((qa = input.read(qn)) != -1) qb.append(qn, 0, qa);
        return qc < qb.length();
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (qc < qb.length() && qb.charAt(qc) <= ' ') qc++;
        for (qa = qc; qc < qb.length() && c.indexOf(qb.charAt(qc)) == -1; qc++);
        return qa < qc ? qb.substring(qa, qc) : "";
    }

    static StringBuilder qb = new StringBuilder(2097152);//buffer
    static char[] qn = new char[2097152];//buffer2
    static int qc = 0, qa = 0;//currentChar, aux
    static java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2097152);
}
