import java.util.Scanner;
public class UserInput {
    public String getString() {
        System.out.print("> ");
        Scanner getKeyboard = new Scanner(System.in);
        return getKeyboard.nextLine();
    }
}