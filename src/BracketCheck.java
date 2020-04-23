import java.util.Stack;

public class BracketCheck {
    public static void main(String[] args) {
        String checkBalancedExpr1= checkBalanced("s * (s – a) * (s – b) * (s – c) ");
        System.out.println("s * (s – a) * (s – b) * (s – c) : "+checkBalancedExpr1);
        String checkBalancedExpr2= checkBalanced("(s * (s – a) * (s – b * (s – c) ");
        System.out.println("(s * (s – a) * (s – b * (s – c) : "+checkBalancedExpr2);
    }
    public static String checkBalanced(String expression)
    {
        if (expression.isEmpty())
            return "Balanced";

        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < expression.length(); i++)
        {
            char current = expression.charAt(i);
            if (current == '{' || current == '(' || current == '[')
            {
                stack.push(current);
            }
            if (current == '}' || current == ')' || current == ']')
            {
                if (stack.isEmpty())
                    return "Not Balanced";
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[')
                    stack.pop();
                else
                    return "Not Balanced";
            }
        }
        return stack.isEmpty()?"Balanced":"Not Balanced";
    }
    }

