/**
 * BufferedInputStream. apenas le linhas de ate 8192 chars
 */
package iotest.in1;

public class R3b {

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

    //retorna true se a entrada tiver algo diferente de whitespace e EOF. descarta whitespaces a esquerda
    public static boolean ready() throws java.io.IOException {
        for (inputauxvar = readByte(); inputauxvar > 0 && inputauxvar <= ' '; inputauxvar = readByte());//descarta whitespaces a esquerda
        return --zc >= 0;//como readByte avanca curChar, aqui devemos retroceder uma posicao
    }

    //le um byte do buffer de entrada. se retornar -1, acabou a entrada
    public static int readByte() throws java.io.IOException {
        if (zc >= inputnumchars) {
            inputnumchars = input.read(inputchars);
            zc = 0;
        }
        return inputnumchars > 0 ? inputchars[zc++] : -1;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        for (inputauxvar = readByte(), inputauxvar2 = 0; inputauxvar > 0 && c.indexOf(inputauxvar) == -1; inputauxvar = readByte()) inputchars2[inputauxvar2++] = (byte) inputauxvar;
        return new String(inputchars2, 0, inputauxvar2);
    }

    static byte[] inputchars = new byte[2097152], inputchars2 = new byte[8192];
    static int zc = 0, inputnumchars = -2, inputauxvar, inputauxvar2;
    static java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in);
}
