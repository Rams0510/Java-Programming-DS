import java.util.Stack;

class PostfixEvaluator {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        
        String[] tokens = expression.split(" ");
        
        for (String token : tokens) {
            if (isOperator(token)) {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = performOperation(token.charAt(0), operand1, operand2);
                stack.push(result);
            } 
            else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        return stack.pop();
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static int performOperation(char operator, int operand1, int operand2) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                return operand1 / operand2;
            default:
                throw new UnsupportedOperationException("Operator not supported");
        }
    }

    public static void main(String[] args) {
        String expression1 = "2 3 1 * + 9 -";
        System.out.println("Result of expression1: " + evaluatePostfix(expression1));

        String expression2 = "100 200 + 2 / 5 * 7 +";
        System.out.println("Result of expression2: " + evaluatePostfix(expression2));
    }
}
