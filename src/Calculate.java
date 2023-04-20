public class Calculate {
    public String getResult(String expression) throws ExpressionException {
        int[] arabic = {0, 0};
        String[] roman = {"", ""};
        String s;
        String op  = "";
        boolean romanNumbers = false;
        boolean arabicNumbers = false;
        int number = 0;
        int result;
        for (int j = 0; j < expression.length(); j++) {
            s = expression.substring(j, j + 1);
            if ((s.equals("I") || s.equals("V")) || s.equals("X")) {
                if (arabicNumbers) {
                    throw new ExpressionException ();
                }
                romanNumbers = true;
                roman[number] += s;
            } else {
                if (s.equals("0") || s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9")) {
                    if (romanNumbers) {
                        throw new ExpressionException ();
                    }
                    arabic[number] = arabic[number] * 10 + Integer.parseInt(s);
                    arabicNumbers = true;
                } else {
                    if ((s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) && (number == 0)) {
                        op = s;
                        number++;
                    } else {
                        if ( !s.equals (" ") ) {
                            throw new ExpressionException();
                        }
                    }
                }
                //}
            }
        }
        if (romanNumbers) {
            RomanToArabic convert = new RomanToArabic();
            arabic[0] = convert.getNumber(roman[0]);
            arabic[1] = convert.getNumber(roman[1]);
        }
        if ((arabic[0] < 0) || (arabic[0] > 10) || (arabic[1] < 0) || (arabic[1] > 10)) {
            throw new ExpressionException();
        }
        switch (op) {
            case "+":
                result = arabic[0] + arabic[1];
                break;
            case "-":
                if (romanNumbers) if (arabic[0] <= arabic[1]) throw new ExpressionException();
                result = arabic[0] - arabic[1];
                break;
            case "*":
                result = arabic[0] * arabic[1];
                break;
            case "/":
                result = (int)(arabic[0] / arabic[1]);
                break;
            default:
                result = 0;
        }
        if (romanNumbers) {
            ArabicToRoman res = new ArabicToRoman();
            return res.getNumber(result);
        }
        return String.valueOf(result);
    }
}