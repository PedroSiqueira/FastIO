/**
 * System.out.print(sb(2097152).toString())
 */
package iotest.out5;

public class W02 {

    static final java.util.Random _random = new java.util.Random(211166910);
    static int numLines = 1000000;
    static int numColumns = 100;

    private static void PrintLines() {
        for (int i = 0; i < numLines; i++) {
            int j = 0;//quantas colunas ja foram geradas para a linha atual
            while (j + 10 < numColumns) {//gera 10 colunas (uma string e um int de 5 digitos cada)
                String s = randomString(5);
                int n = (_random.nextInt(10000) + 10000);
                sb.append(s).append(n);
                j += 10;
            }
            sb.append(randomString(numColumns - j)).append('\n');//gera o restante de colunas que faltou e coloca um \n
        }
        System.out.print(sb.toString());
    }

    public static void main(String args[]) {
        for (int i = 0; i < args.length; i++) {
            if ("-l".equals(args[i])) numLines = Integer.parseInt(args[i + 1]);
            else if ("-c".equals(args[i])) numColumns = Integer.parseInt(args[i + 1]);
        }
        long startTime = System.nanoTime();
        PrintLines();
        long stopTime = System.nanoTime();
        System.err.println((stopTime - startTime));
    }

    private static String randomString(int length) {
        StringBuilder strbld = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            strbld.append((char) (_random.nextInt(95) + 33));
        }
        return strbld.toString();
    }

    static StringBuilder sb = new StringBuilder(2097152);
}
