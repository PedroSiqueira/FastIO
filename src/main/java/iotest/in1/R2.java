/**
 * BufferedInputStream with StringBuilder
 */
package iotest.in1;

public class R2 {

    static long total = 0;

    private static void ReadLines() throws java.io.IOException {
        String s;
        while (ready()) {
            s = readLine();
            for (int i = 0; i < s.length(); i++)
                total += s.charAt(i);
        }
        input.close();
    }

    public static void main(String args[]) throws java.io.IOException {
        long startTime = System.nanoTime();
        ReadLines();
        long stopTime = System.nanoTime();
        System.err.println((stopTime - startTime) + "\t" + total);
    }

    //BufferedInputStream mais rapido que BufferedReader mais rapido que Scanner
    private static final java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
    private static final byte[] buf = new byte[8192];
    private static int curChar = 0;//qual a posicao atual no buffer
    private static int numChars = 0;//quantos bytes ha no buffer

    //retorna true se a entrada tiver algo diferente de whitespace e EOF. vai descartando whitespaces ate encontrar algo diferente
    public static boolean ready() {
        int c = readByte();
        curChar--;
        return c > 0;
    }

    //le um byte do buffer de entrada. se retornar -1, acabou a entrada
    public static int readByte() {
        if (numChars == -1) return -1;
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = input.read(buf);
            } catch (java.io.IOException e) {
                throw new java.util.InputMismatchException();
            }
            if (numChars <= 0) return -1;
        }
        return buf[curChar++];
    }

    //le da entrada ate encontrar algo diferente de whitespace. se for EOF, retorna null. retorna um token ou uma linha se option for, respectivamente, null ou qualquer valor. cuidado que pode nao aceitar letras com acentos.
    public static String readLine() {
        int c = readByte();
        if (c <= 0) return null;
        StringBuilder res = new StringBuilder();
        while (c >= ' ') {
            res.appendCodePoint(c);
            c = readByte();
        }
        return res.toString();
    }
}
