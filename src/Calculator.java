public class Calculator {
    public static void main(String[] args) {
        String str = "";
        System.out.println("Программа - Калькулятор (Для выхода введите: exit)");
        UserInput getConsole = new UserInput();
        Calculate result = new Calculate();
        while (!str.equals("exit")) {
            str = getConsole.getString();
            if (!str.equals("exit")) {
                try {
                    System.out.println(result.getResult(str));
                } catch(ExpressionException e) {
                    System.out.println("ExpressionException: " + e);
                    break;
                }
            }
        }
    }
}