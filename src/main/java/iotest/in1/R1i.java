/**
 * BufferedReader with readToken
 */
package iotest.in1;

public class R1i {

    static long total = 0;

    private static void ReadLines() throws java.io.IOException {
        String s;
        while (ready()) {
            s = readUntil(null);
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
        if (qb != null && qc >= qb.length()) {
            qb = input.readLine();
            qc = 0;
        }
        return qb != null;
    }

    //le da entrada uma string ate (mas nao incluido) c ou linebreak, depois de descartar qualquer whitespace a esquerda. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace.
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (ready() && qb.charAt(qc) <= ' ') qc++;//descarta c's a esquerda
        if ("\n\r".contains(c) && qb != null) {//se c for linebreak
            ql = qc;
            qc = qb.length();
        } else for (ql = qc; qc < qb.length() && c.indexOf(qb.charAt(qc)) == -1; qc++);
        return qb != null ? qb.substring(ql) : "";
    }

    static java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2097152);
    static int qc = 0, ql;//currentChar, length
    static String qb = "";//buffer
}
