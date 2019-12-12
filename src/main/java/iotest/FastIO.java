package iotest;

public class FastIO {

    public static void main(String[] args) throws java.io.IOException {
        while (ready()) {
            sb.append(read("")).append("\n");
        }
        fc();
    }

    static boolean ready() throws java.io.IOException {
        if (qb == null) qb = input.readAllBytes();
        return qc < qb.length;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String read(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (qc < qb.length && qb[qc] <= ' ') qc++;
        for (qa = qc; qc < qb.length && c.indexOf(qb[qc]) == -1; qc++);
        return qa < qc ? new String(qb, qa, qc - qa) : "";
    }

    //flush and close
    static void fc() throws java.io.IOException {
        try (java.io.BufferedOutputStream out = new java.io.BufferedOutputStream(System.out)) {
            out.write(sb.toString().getBytes());
            out.flush();
        }
    }

    static StringBuilder sb = new StringBuilder(131072);
    static byte[] qb = null;//buffer
    static int qc = 0, qa = 0;//currentChar, aux
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
