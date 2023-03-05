public class ArabicToRoman {

    public String getNumber(int number) {
        String s;
        if (number == 100) {
            s = "C";
        } else if (number >= 90) {
            s = "XC" + ten (number - 90);
        } else if (number >= 50) {
            s = "L" + forty(number - 50);
        } else if (number >= 40) {
            s = "XL" + ten (number - 40);
        } else {
            s = forty (number);
        }
        return s;
    }

    private String forty(int n) {
        StringBuffer s = new StringBuffer();
        for (byte j = 1; j <= n/10; j++) s.append ("X");
        s.append(ten(n - 10 * (n/10)));
        return String.valueOf(s);
    }

    private String ten(int n) {
        String s;
        if (n == 10) {
            s = "X";
        } else if (n == 9) {
            s = "IX";
        } else if (n >= 5) {
            s = "V" + three (n - 5);
        } else if (n == 4) {
            s = "IV";
        } else {
            s = three (n);
        }

        return s;
    }

    private String three(int n) {
        StringBuffer s = new StringBuffer();
        for (byte j = 1; j <= n; j++) s.append("I");
        return String.valueOf(s);
    }
}