package iotest;

public class FastIO {

    public static void main(String[] args) throws java.io.IOException {
//        int b = '\b', t = '\t', n = '\n', f = '\f', r = '\r', s = ' ';
//        System.out.println("all whitespaces (char=int");
//        System.out.printf("b=%d t=%d n=%d f=%d r=%d s=%d\n", b, t, n, f, r, s);
        System.out.println(readUntil('\n'));
    }

    static byte[] inputchars = new byte[2000000];//maximo de 2M chars
    static int inputcurrentchar = 0, inputnumchars = -2, inputauxvar = 0;

    //se ainda ha um caractere diferente de whitespace na entrada, returna true, senao, retorna false
    static boolean ready() throws java.io.IOException {
        if (inputnumchars == -2)
            try (java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in)) {
                inputnumchars = input.read(inputchars);
            }
        while (inputcurrentchar < inputnumchars && inputchars[inputcurrentchar] <= ' ') inputcurrentchar++;
        return inputcurrentchar < inputnumchars;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null
    static String readUntil(char c) throws java.io.IOException {
        if (!ready()) return null;
        for (inputauxvar = inputcurrentchar; inputcurrentchar < inputnumchars && inputchars[inputcurrentchar] != c; inputcurrentchar++);
        return inputauxvar >= inputcurrentchar ? null : new String(inputchars, inputauxvar, inputcurrentchar - inputauxvar);
    }
}
