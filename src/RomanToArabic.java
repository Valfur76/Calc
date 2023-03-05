public class RomanToArabic {
    public int getNumber(String roman) throws ExpressionException {
        int n = 0;
        for (int j = 0; j < roman.length (); j++) {
            switch (roman.substring(j, j + 1)) {
                case "X":
                    if (n == 0) {
                        n = 10;
                    } else if (n == 1) {
                        n = 9;
                    } else {
                        throw new ExpressionException();
                    }
                    break;
                case  "V":
                    if (n == 0) {
                        n = 5;
                    } else if (n == 1) {
                        n = 4;
                    } else {
                        throw new ExpressionException();
                    }
                    break;
                case "I":
                    if (((n >= 0) && (n <= 2)) || ((n >= 5) && (n <= 7 ))) {
                        n++;
                    } else {
                        throw new ExpressionException();
                    }
                    break;
                default:
                    throw new ExpressionException();
            }
        }
        return n;
    }
}