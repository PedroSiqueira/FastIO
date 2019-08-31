package iotest;

public class FastIO {

    public static void main(String[] args) throws java.io.IOException {

        flush_close();
    }

    static boolean ready() throws java.io.IOException {
        if (qb == null) qb = input.readAllBytes();
        return qc < qb.length;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (qc < qb.length && c.indexOf(qb[qc]) != -1) qc++;
        for (qa = qc; qc < qb.length && c.indexOf(qb[qc]) == -1; qc++);
        return qa < qc ? new String(qb, qa, qc - qa) : "";
    }

    static void flush_close() throws java.io.IOException {
        try (java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(System.out)) {
            out.write(output.toString().getBytes());
            out.flush();
        }
    }

    static byte[] qb = null;//buffer
    static int qc = 0, qa = 0;//currentChar, length, aux
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
    static StringBuilder output = new StringBuilder(2097152);
}
