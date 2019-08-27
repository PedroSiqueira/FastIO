/**
 * BufferedReader, stores in char[], reads with read(char[]). doesn't read until end
 */
package iotest.in2;

public class R3 {

    static long total = 0;

    private static void ReadLines() throws java.io.IOException {
        String s;
        while (ready()) {
            s = readUntil('\n');
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

    static char[] inputchars = new char[2000000];//maximo de 2M chars
    static int inputcurrentchar = 0, inputnumchars = -2, inputauxvar = 0;

    //se ainda ha um caractere diferente de whitespace na entrada, returna true, senao, retorna false
    static boolean ready() throws java.io.IOException {
        if (inputnumchars == -2)
            try (java.io.BufferedReader input = new java.io.BufferedReader(new java.io.InputStreamReader(System.in), 2000000)) {
                inputnumchars = input.read(inputchars);
            }
        while (inputcurrentchar < inputnumchars && inputchars[inputcurrentchar] <= ' ') inputcurrentchar++;
        return inputcurrentchar < inputnumchars;
    }

    //retorna da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null
    static String readUntil(char c) throws java.io.IOException {
        if (!ready()) return null;
        for (inputauxvar = inputcurrentchar; inputcurrentchar < inputnumchars && inputchars[inputcurrentchar] != c; inputcurrentchar++);
        return inputauxvar >= inputcurrentchar ? null : new String(inputchars, inputauxvar, inputcurrentchar - inputauxvar);
    }
}
