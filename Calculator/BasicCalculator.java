import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String target = "7 + (6 - 4 + (2 - 1)) + 7";
        System.out.println(calculate(target));
    }

    public static int calculate(String s) {
        Stack<Object> stack = new Stack<>();
        int n = 0;
        int operand = 0;
        for (int i = s.length() - 1; i >= 0; i --) {
            Character cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                operand = (int) Math.pow(10, n) * (int) (cur - '0') + operand;
                n ++;
            } else if (cur != ' ') {
                if (n != 0) {
                    stack.push(operand);
                    n = 0;
                    operand = 0;
                }
                if (cur == '(') {
                    int res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);
                }
                else {
                    stack.push(cur);
                }
            }

        }
        if (n != 0) {
            stack.push(operand);
        }
        return evaluateExpr(stack);
    }

    public static int evaluateExpr(Stack<Object> stack) {
        int res = 0;

        if (!stack.empty()) {
            res = (int) stack.pop();
        }

        while (!stack.empty() && !((char) stack.peek() == ')')) {

            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (int) stack.pop();
            } else {
                res -= (int) stack.pop();
            }
        }
        return res;
    }
}
