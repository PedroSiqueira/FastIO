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

    //se ainda ha um caractere diferente de whitespace na entrada, returna true, senao, retorna false
    static boolean ready() throws java.io.IOException {
        if (inputchars.length() <= 0)
            while ((inputauxvar = input.read(inputchars2)) != -1) inputchars.append(inputchars2, 0, inputauxvar);
        while (zc < inputchars.length() && inputchars.charAt(zc) <= ' ') zc++;
        return zc < inputchars.length();
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        for (inputauxvar = zc; zc < inputchars.length() && c.indexOf(inputchars.charAt(zc)) == -1; zc++);
        return inputauxvar >= zc ? null : inputchars.substring(inputauxvar, zc);
    }

    static StringBuilder inputchars = new StringBuilder(2097152);//capacidade inicial de 2M chars
    static char[] inputchars2 = new char[2097152];
    static int zc = 0, inputauxvar = 0;
    static java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2097152);
}
