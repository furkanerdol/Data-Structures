package HW04_Furkan_Erdol_131044065;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Converts infix expressions to postfix expressions
 *
 * @author Furkan
 */
public class InfixToPostfix {

    private final Stack<Character> operatorStack;
    private static final String OPERATORS = "*/+-";
    private final StringBuilder postfix;

    /**
     * Constructor
     */
    public InfixToPostfix() {
        operatorStack = new Stack<Character>();
        postfix = new StringBuilder();
    }

    /**
     * Takes a infix expression string and converts to postfix expressions
     *
     * @param infixExpression infix expression string
     * @return postfix expression string
     * @throws SyntaxErrorException
     */
    public String convertInfixToPostfix(String infixExpression) throws SyntaxErrorException {

        //Checks infix expression
        checkExpression(infixExpression);

        boolean assignmentStatus = false;

        String[] tokens = infixExpression.split("\\s+");
        try {
            for (int i = 0; i < tokens.length; ++i) {

                for (int j = 0; j < tokens[i].length(); ++j) {

                    char tempChar = tokens[i].charAt(j);

                    if (Character.isDigit(tempChar)) {
                        postfix.append(tokens[i]);
                        postfix.append(' ');
                        break;
                    } else if (isOperator(tempChar)) {
                        if (tempChar == '-' && tokens[i].length() > 1) {
                            postfix.append(tokens[i]);
                            postfix.append(' ');
                            break;
                        } else if (operatorStack.empty()) {
                            operatorStack.push(tempChar);
                        } else if (precedenceOperator(tempChar) > precedenceOperator(operatorStack.peek())) {
                            operatorStack.push(tempChar);
                        } else if (precedenceOperator(tempChar) == precedenceOperator(operatorStack.peek())) {
                            postfix.append(operatorStack.pop());
                            postfix.append(' ');
                            operatorStack.push(tempChar);
                        } else if (precedenceOperator(tempChar) < precedenceOperator(operatorStack.peek())) {
                            while (!operatorStack.empty()) {
                                postfix.append(operatorStack.pop());
                                postfix.append(' ');
                            }
                            operatorStack.push(tempChar);
                        }
                    } else if (tempChar == '=') {
                        assignmentStatus = true;
                        break;
                    } else {
                        postfix.append(tokens[i]);
                        postfix.append(' ');
                        break;
                    }
                }
            }
        } catch (EmptyStackException exception) {
            throw new SyntaxErrorException("Syntax error!");
        }
        
        while (!operatorStack.empty()) {
            postfix.append(operatorStack.pop());
            postfix.append(' ');
        }

        if (assignmentStatus == true) {
            postfix.append('=');
        }

        return postfix.toString();
    }

    private boolean isOperator(char character) {
        return OPERATORS.indexOf(character) != -1;
    }

    private boolean isOperatorAssingmentIncluded(char character) {
        return (OPERATORS.indexOf(character) != -1) || character == '=';
    }

    private int precedenceOperator(char operator) {
        if (operator == '*' || operator == '/') {
            return 1;
        } else {
            return 0;
        }
    }

    private void checkExpression(String infixExpression) throws SyntaxErrorException {

        String[] tokens = infixExpression.split("\\s+");

        for (int i = 0; i < tokens.length; ++i) {

            for (int j = 0; j < tokens[i].length(); ++j) {

                if (i > 1 && tokens[i].charAt(j) == '=') {
                    throw new SyntaxErrorException("Invalid operator location !");
                } else if (isOperatorAssingmentIncluded(tokens[i].charAt(j)) && (i == 0 || i == tokens.length - 1) && (tokens[i].length() > 1 && !Character.isDigit(tokens[i].charAt(j + 1)))) {
                    throw new SyntaxErrorException("Invalid operator location :" + tokens[i].charAt(j));
                } else if (!isOperatorAssingmentIncluded(tokens[i].charAt(j)) && (i == 1 || i == tokens.length - 2)) {
                    throw new SyntaxErrorException("Invalid operator location :" + tokens[i].charAt(j));
                } else if (i < (tokens.length - 2) && i > 0) {
                    if (isOperatorAssingmentIncluded(tokens[i].charAt(j))) {
                        if (isOperatorAssingmentIncluded(tokens[i - 1].charAt(j))
                                || isOperatorAssingmentIncluded(tokens[i + 1].charAt(j))
                                || !isOperatorAssingmentIncluded(tokens[i + 2].charAt(j))) {
                            if (!((tokens[i - 1].charAt(j) == '-' && tokens[i - 1].length() > 1)
                                    || (tokens[i + 1].charAt(j) == '-' && tokens[i + 1].length() > 1))) {
                                throw new SyntaxErrorException("Invalid operator location !");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * For syntax errors
     */
    public static class SyntaxErrorException extends Exception {

        public SyntaxErrorException(String message) {
            super(message);
        }
    }
}
