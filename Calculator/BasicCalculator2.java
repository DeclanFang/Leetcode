import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        String target = "14 / 3 * 2";
        System.out.println(calculate(target));
    }

    private static int calculate(String s) {
        Stack<Object> stack = new Stack<>();
        int operand = 0;
        int n = 0;

        for (int i = s.length() - 1; i >= 0; i --) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                operand = (int) Math.pow(10, n) * (int) (cur - '0') + operand;
                n ++;
            }
            else if (cur != ' ') {
                if (cur == '+' || cur == '-') {
                    while (!stack.isEmpty() && ((char) stack.peek() == '*' || (char) stack.peek() == '/')) {
                        char op = (char) stack.pop();
                        if (op == '*') {
                            operand *= (int) stack.pop();
                        }
                        else {
                            operand /= (int) stack.pop();
                        }
                    }
                }
                stack.push(operand);
                stack.push(cur);
                operand = 0;
                n = 0;
            }
        }

        while (!stack.empty()) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                operand += (int) stack.pop();
            } else if (sign == '-') {
                operand -= (int) stack.pop();
            }
            else if (sign == '*') {
                operand *= (int) stack.pop();
            }
            else if (sign == '/') {
                operand /= (int) stack.pop();
            }
        }
        return operand;
    }
}
