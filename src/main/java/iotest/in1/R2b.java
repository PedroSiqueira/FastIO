/**
 * BufferedInputStream, le tudo de uma vez e grava em byte[].
 */
package iotest.in1;

public class R2b {

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
        if (inputnumchars <= 0) {
            while ((inputauxvar = input.read(inputchartemp)) != -1) {
                if (inputauxvar + inputnumchars > inputchars.length)
                    inputchars = java.util.Arrays.copyOf(inputchars, inputchars.length * 2);//dobra o tamanho de inputchars
                System.arraycopy(inputchartemp, 0, inputchars, inputnumchars, inputauxvar);//anexa temp em inputchars
                inputnumchars += inputauxvar;
            }
        }
        while (zc < inputnumchars && inputchars[zc] <= ' ') zc++;
        return zc < inputnumchars;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        for (inputauxvar = zc; zc < inputnumchars && c.indexOf(inputchars[zc]) == -1; zc++);
        return inputauxvar >= zc ? null : new String(inputchars, inputauxvar, zc - inputauxvar);
    }

    static byte[] inputchars = new byte[2097152], inputchartemp = new byte[2097152];
    static int zc = 0, inputnumchars = 0, inputauxvar = 0;
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
