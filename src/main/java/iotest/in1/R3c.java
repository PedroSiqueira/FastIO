/**
 * BufferedInputStream + String.
 */
package iotest.in1;

public class R3c {

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
        if (ql != -1 && qc >= ql) {
            qn.append(new String(qb, qa, qc - qa));//caso estivesse lendo e o buffer acabado, nao descarta o que ja foi lido
            ql = input.read(qb);
            qc = qa = 0;
        }
        return ql > 0;
    }

    //le da entrada uma string ate (mas nao incluido) c, depois de descartar qualquer whitespace a esquerda. se nao conseguiu ler, retorna null. se c for nulo ou vazio, le ate qualquer whitespace.
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        while (ready() && qb[qc] <= ' ') qc++;//descarta c's a esquerda
        for (qa = qc, qn.setLength(0); ready() && c.indexOf(qb[qc]) == -1; qc++);
        return qn.append(new String(qb, qa, qc - qa)).toString();
    }

    static byte[] qb = new byte[2097152];//buffer
    static int qc = 0, ql = -2, qa = 0;//currentChar, length, aux
    static StringBuilder qn = new StringBuilder(128);//cuidado, qn nao pode ser maior que o buffer
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
