package HW04_Furkan_Erdol_131044065;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Converts infix expression to assembly codes
 *
 * @author Furkan
 */
public class ConvertToAssembly extends AbstractConvertToAssembly {

    private final ArrayList<String> assemblyStringList = new ArrayList<String>();
    private final Stack<Register> operandStack = new Stack<Register>();

    private static final String OPERATORS = "*/+-=";

    /**
     * Constructor
     */
    public ConvertToAssembly() {
        super();
    }

    /**
     * Takes an input file and an output file name. Converts infix expressions
     * to assembly codes. Writes assembly code to output file and returns it.
     *
     * @param inputFileName input file name
     * @param outputFileName output file name
     * @return assembly code as a string array list
     * @throws RegisterLimitException
     * @throws UndefinedVariableUsage
     * @throws InfixToPostfix.SyntaxErrorException
     */
    public ArrayList<String> convertInfixFileTOAssemblyFile(String inputFileName, String outputFileName) throws RegisterLimitException, UndefinedVariableUsage, InfixToPostfix.SyntaxErrorException {

        ArrayList<String> infixExpressionStringList = ReadAndWrite.readInfixExpressionFromFile(inputFileName);

        for (int i = 0; i < infixExpressionStringList.size(); ++i) {

            String infixExpression = infixExpressionStringList.get(i);

            String[] tokens = infixExpression.split("\\s+");

            if (tokens[0].compareTo("print") == 0 && tokens.length == 2) {
                Register tempRegister = findRegister(tokens[1]);
                printFunction(tempRegister);
            } else {

                InfixToPostfix convertExpression = new InfixToPostfix();

                String postfixExpression = convertExpression.convertInfixToPostfix(infixExpression);

                evaluate(postfixExpression);
            }
        }

        ReadAndWrite.writeAssemblyCodeToFile(outputFileName, assemblyStringList);

        return assemblyStringList;
    }

    /**
     * Evaluates postfix expressions to assembly codes
     *
     * @param postfixExpressionToConvert
     * @throws RegisterLimitException
     * @throws DivisionByZeroException
     * @throws UndefinedVariableUsage
     */
    public void evaluate(String postfixExpressionToConvert) throws RegisterLimitException, DivisionByZeroException, UndefinedVariableUsage, InfixToPostfix.SyntaxErrorException {

        String[] tokens = postfixExpressionToConvert.split("\\s+");
        try {
            if (tokens.length == 3 && tokens[2].compareTo("=") == 0) {
                int tempInt = Integer.parseInt(tokens[1]);
                loadImmediate(tokens[0], tempInt);

            } else {
                for (int i = 0; i < tokens.length; ++i) {
                    for (int j = 0; j < tokens[i].length(); ++j) {

                        char tempChar = tokens[i].charAt(j);

                        if (Character.isDigit(tempChar)) {
                            int tempInt = Integer.parseInt(tokens[i]);
                            Register tempRegister = loadImmediate(tempInt);
                            operandStack.push(tempRegister);
                            break;
                        } else if (isOperator(tempChar)) {

                            if (tempChar == '-' && tokens[i].length() > 1 && Character.isDigit(tokens[i].charAt(j + 1))) {
                                int tempInt = Integer.parseInt(tokens[i]);
                                Register tempRegister = loadImmediate(tempInt);
                                operandStack.push(tempRegister);
                                break;
                            }
                            Register right = (Register) operandStack.pop();
                            Register left = (Register) operandStack.pop();
                            Register tempRegister = processOperator(left, right, tempChar);
                            operandStack.push(tempRegister);
                        } else {
                            Register tempRegister = new Register();

                            if (i == 0 && tokens[tokens.length - 1].compareTo("=") == 0) {
                                try {
                                    findRegister(tokens[0]);
                                } catch (UndefinedVariableUsage exception) {
                                    loadImmediate(tokens[0], 0);
                                }
                            }

                            tempRegister = findRegister(tokens[i]);
                            operandStack.push(tempRegister);
                            break;
                        }
                    }
                }
            }
        } catch (EmptyStackException exception) {
            throw new InfixToPostfix.SyntaxErrorException("Syntax error!");
        }
    }

    /**
     * Takes an operator and two register. Process register by operator type
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @param operator operator
     * @return
     * @throws RegisterLimitException
     * @throws DivisionByZeroException
     */
    public Register processOperator(Register leftSide, Register rightSide, char operator) throws RegisterLimitException, DivisionByZeroException {

        Register tempRegister = new Register();

        switch (operator) {
            case '=':
                tempRegister = move(leftSide, rightSide);
                break;
            case '+':
                tempRegister = add(leftSide, rightSide);
                break;
            case '-':
                tempRegister = subtract(leftSide, rightSide);
                break;
            case '*':
                tempRegister = multiply(leftSide, rightSide);
                break;
            case '/':
                tempRegister = divide(leftSide, rightSide);
                break;
            default:
        }

        return tempRegister;
    }

    private boolean isOperator(char character) {
        return OPERATORS.indexOf(character) != -1;
    }

    /**
     * For initialization process
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    @Override
    public Register loadImmediate(String leftSide, int rightSide) throws RegisterLimitException {

        Register tempRegister = new Register();

        try {
            tempRegister = findRegister(leftSide);
            tempRegister.setIntegerValue(rightSide);
            assemblyStringList.add("li\t" + tempRegister.getRegisterName() + "," + tempRegister.getIntegerValue());
            return tempRegister;

        } catch (UndefinedVariableUsage exception) {
            for (int i = 0; i < getRegisterList().size() - 2; ++i) {
                if (getRegisterInRegisterList(i).isFree()) {
                    getRegisterInRegisterList(i).setIntegerValue(rightSide);
                    getRegisterInRegisterList(i).setVariableName(leftSide);
                    getRegisterInRegisterList(i).changeFreeStatus(false);

                    assemblyStringList.add("li\t" + getRegisterInRegisterList(i).getRegisterName() + "," + getRegisterInRegisterList(i).getIntegerValue());
                    return getRegisterInRegisterList(i);
                }
            }
        }

        throw new RegisterLimitException("Register limit was exceed!");
    }

    /**
     * For load integer value to register as temporary
     *
     * @param value integer value
     * @return register
     * @throws RegisterLimitException
     */
    public Register loadImmediate(int value) throws RegisterLimitException {

        for (int i = 0; i < getRegisterList().size() - 2; ++i) {
            if (getRegisterInRegisterList(i).isFree()) {
                getRegisterInRegisterList(i).setIntegerValue((int) value);
                getRegisterInRegisterList(i).changeFreeStatus(false);

                assemblyStringList.add("li\t" + getRegisterInRegisterList(i).getRegisterName() + "," + getRegisterInRegisterList(i).getIntegerValue());
                return getRegisterInRegisterList(i);
            }
        }

        throw new RegisterLimitException("Register limit was exceed!");
    }

    /**
     * For assignment process
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    @Override
    public Register move(Register leftSide, Register rightSide) {

        leftSide.setIntegerValue(rightSide.getIntegerValue());

        assemblyStringList.add("move\t" + leftSide.getRegisterName() + "," + rightSide.getRegisterName());

        if (rightSide.getVariableName() == null) {
            rightSide.changeFreeStatus(true);
        }

        return leftSide;
    }

    /**
     * For add process
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    @Override
    public Register add(Register leftSide, Register rightSide) throws RegisterLimitException {

        int result;

        result = leftSide.getIntegerValue() + rightSide.getIntegerValue();

        for (int i = 0; i < getRegisterList().size() - 2; ++i) {
            if (getRegisterInRegisterList(i).isFree()) {
                getRegisterInRegisterList(i).setIntegerValue(result);
                getRegisterInRegisterList(i).changeFreeStatus(false);

                assemblyStringList.add("add\t" + getRegisterInRegisterList(i).getRegisterName() + "," + leftSide.getRegisterName() + "," + rightSide.getRegisterName());

                if (leftSide.getVariableName() == null) {
                    leftSide.changeFreeStatus(true);
                }
                if (rightSide.getVariableName() == null) {
                    rightSide.changeFreeStatus(true);
                }

                return getRegisterInRegisterList(i);
            }
        }

        throw new RegisterLimitException("Register limit was exceed!");
    }

    /**
     * For subtract process
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    @Override
    public Register subtract(Register leftSide, Register rightSide) throws RegisterLimitException {

        int result;

        result = leftSide.getIntegerValue() - rightSide.getIntegerValue();

        for (int i = 0; i < getRegisterList().size() - 2; ++i) {
            if (getRegisterInRegisterList(i).isFree()) {
                getRegisterInRegisterList(i).setIntegerValue(result);
                getRegisterInRegisterList(i).changeFreeStatus(false);

                assemblyStringList.add("sub\t" + getRegisterInRegisterList(i).getRegisterName() + "," + leftSide.getRegisterName() + "," + rightSide.getRegisterName());

                if (leftSide.getVariableName() == null) {
                    leftSide.changeFreeStatus(true);
                }
                if (rightSide.getVariableName() == null) {
                    rightSide.changeFreeStatus(true);
                }

                return getRegisterInRegisterList(i);
            }
        }

        throw new RegisterLimitException("Register limit was exceed!");
    }

    /**
     * For multiply process
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    @Override
    public Register multiply(Register leftSide, Register rightSide) throws RegisterLimitException {

        int result;

        result = leftSide.getIntegerValue() * rightSide.getIntegerValue();

        if (leftSide.getVariableName() == null) {
            leftSide.changeFreeStatus(true);
        }
        if (rightSide.getVariableName() == null) {
            rightSide.changeFreeStatus(true);
        }

        for (int i = 0; i < getRegisterList().size() - 2; ++i) {
            if (getRegisterInRegisterList(i).isFree()) {
                getRegisterInRegisterList(i).setIntegerValue(result);
                getRegisterInRegisterList(i).changeFreeStatus(false);

                assemblyStringList.add("mult\t" + leftSide.getRegisterName() + "," + rightSide.getRegisterName());
                assemblyStringList.add("mflo\t" + getRegisterInRegisterList(i).getRegisterName());

                return getRegisterInRegisterList(i);
            }
        }

        throw new RegisterLimitException("Register limit was exceed!");

    }

    /**
     * For divide process
     *
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    @Override
    public Register divide(Register leftSide, Register rightSide) throws RegisterLimitException, DivisionByZeroException {

        int result;

        try {
            result = leftSide.getIntegerValue() / rightSide.getIntegerValue();
        } catch (ArithmeticException exception) {
            throw new DivisionByZeroException("Division by zero!");
        }
        if (leftSide.getVariableName() == null) {
            leftSide.changeFreeStatus(true);
        }
        if (rightSide.getVariableName() == null) {
            rightSide.changeFreeStatus(true);
        }

        for (int i = 0; i < getRegisterList().size() - 2; ++i) {
            if (getRegisterInRegisterList(i).isFree()) {
                getRegisterInRegisterList(i).setIntegerValue(result);
                getRegisterInRegisterList(i).changeFreeStatus(false);

                assemblyStringList.add("div\t" + leftSide.getRegisterName() + "," + rightSide.getRegisterName());
                assemblyStringList.add("mflo\t" + getRegisterInRegisterList(i).getRegisterName());

                return getRegisterInRegisterList(i);
            }
        }

        throw new RegisterLimitException("Register limit was exceed!");

    }

    /**
     *
     * @param register to be written register
     * @return register
     */
    @Override
    public Register printFunction(Register register) {

        move(getRegisterInRegisterList(getRegisterList().size() - 2), register);

        assemblyStringList.add("li\t" + getRegisterInRegisterList(getRegisterList().size() - 1).getRegisterName() + "," + 1);
        assemblyStringList.add("syscall");

        return register;

    }

    /**
     * Register limit exception
     */
    public static class RegisterLimitException extends Exception {

        public RegisterLimitException(String message) {
            super(message);
        }
    }

    /**
     * Division by zero exception
     */
    public static class DivisionByZeroException extends ArithmeticException {

        public DivisionByZeroException(String message) {
            super(message);
        }
    }

    /**
     * Undefined variable exception
     */
    public static class UndefinedVariableUsage extends Exception {

        public UndefinedVariableUsage(String message) {
            super(message);
        }
    }

}
