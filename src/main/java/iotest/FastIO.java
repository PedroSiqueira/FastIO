package iotest;

public class FastIO {

    public static void main(String[] args) throws java.io.IOException {
//        int b = '\b', t = '\t', n = '\n', f = '\f', r = '\r', s = ' ';
//        System.out.println("all whitespaces (char=int");
//        System.out.printf("b=%d(08) t=%d(09) n=%d(10) f=%d(12) r=%d(13) s=%d(32)\n", b, t, n, f, r, s);
//        System.out.println(readUntil('\n'));
//        ArrayList<String> al = new ArrayList<>();
//        al.addAll(inputauxvar, al)

        while (ready()) {
            System.out.println("zzz" + readUntil(""));
        }

    }

    //se ainda ha um caractere diferente de whitespace na entrada, returna true, senao, retorna false
    static boolean ready() throws java.io.IOException {
        if (inputnumchars <= 0)
            try (java.io.BufferedInputStream input = new java.io.BufferedInputStream(System.in)) {
                while ((inputauxvar = input.read(inputchartemp)) != -1) {
                    if (inputauxvar + inputnumchars > inputchars.length)
                        inputchars = java.util.Arrays.copyOf(inputchars, inputchars.length * 2);//dobra o tamanho de inputchars
                    System.arraycopy(inputchartemp, 0, inputchars, inputnumchars, inputauxvar);//anexa temp em inputchars
                    inputnumchars += inputauxvar;
                }
            }
        while (inputcurrentchar < inputnumchars && inputchars[inputcurrentchar] <= ' ') inputcurrentchar++;
        return inputcurrentchar < inputnumchars;
    }

    //le da entrada uma string ate (mas nao incluido) c, descartando qualquer whitespace a esquerda. nao descarta c. se o caractere atual for c ou a entrada acabou, retorna null. se c for nulo ou vazio, le ate qualquer whitespace
    static String readUntil(String c) throws java.io.IOException {
        if (!ready()) return null;
        if (c == null || "".equals(c)) c = "\t\n\f\r ";
        for (inputauxvar = inputcurrentchar; inputcurrentchar < inputnumchars && c.indexOf(inputchars[inputcurrentchar]) == -1; inputcurrentchar++);
        return inputauxvar >= inputcurrentchar ? null : new String(inputchars, inputauxvar, inputcurrentchar - inputauxvar);
    }

    static byte[] inputchars = new byte[2097152], inputchartemp = new byte[2097152];
    static int inputcurrentchar = 0, inputauxvar = 0, inputnumchars = 0;
}
