package iotest;

public class FastIO {

    public static void main(String[] args) throws java.io.IOException {
        while (r()) {
            out.append(read("")).append("\n");
        }
        fc();
    }

    //if ready
    static boolean r() throws java.io.IOException {
        if (qb == null) qb = in.readAllBytes();
        return qc < qb.length;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String read(String c) throws java.io.IOException {
        if (!r()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (qc < qb.length && c.indexOf(qb[qc]) != -1) qc++;
        for (qa = qc; qc < qb.length && c.indexOf(qb[qc]) == -1; qc++);
        return qa < qc ? new String(qb, qa, qc - qa) : "";
    }

    //flush and close
    static void fc() throws java.io.IOException {
        try (java.io.BufferedOutputStream bos = new java.io.BufferedOutputStream(System.out)) {
            bos.write(out.toString().getBytes());
            bos.flush();
        }
    }

    static byte[] qb = null;//buffer
    static int qc = 0, qa = 0;//currentChar, length, aux
    static java.io.BufferedInputStream in = new java.io.BufferedInputStream(System.in);
    static StringBuilder out = new StringBuilder(2097152);
}
