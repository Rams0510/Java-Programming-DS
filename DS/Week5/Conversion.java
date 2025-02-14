import java.util.Stack;

class Conversion {
    
    // Function to get precedence of operators
    public static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1; // Non-operator
        }
    }

    // Function to check if a character is an operand (variable or number)
    public static boolean isOperand(char c) {
        return Character.isLetterOrDigit(c);  // Can be extended for more operand types
    }

    // Function to convert infix to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // If the character is an operand, add it to the postfix expression
            if (isOperand(ch)) {
                postfix.append(ch);
            }
            // If the character is '(', push it to the stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If the character is ')', pop from stack until '(' is found
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();  // Discard '(' from the stack
            }
            // If the character is an operator
            else {
                // Handle precedence and associativity
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    // Right associative case for '^'
                    if (ch == '^' && stack.peek() == '^') {
                        break;  // Do not pop for '^' as it's right associative
                    }
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators from the stack
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infix1 = "A+B*C+D";
        String infix2 = "((A+B)-C*(D/E))+F";

        System.out.println("Postfix expression of '" + infix1 + "' : " + infixToPostfix(infix1));
        System.out.println("Postfix expression of '" + infix2 + "' : " + infixToPostfix(infix2));
    }
}
