package HW04_Furkan_Erdol_131044065;

/**
 * Test class
 * @author Furkan
 */
public class main {

    /**
     * Main
     * @param args
     */
    public static void main(String[] args) {

        ConvertToAssembly testInfixToAssembly = new ConvertToAssembly();

        try {
            testInfixToAssembly.convertInfixFileTOAssemblyFile("input.txt", "output.asm");
        } catch (ConvertToAssembly.DivisionByZeroException exception) {
            System.err.println("Division by zero!");
        } catch (ConvertToAssembly.RegisterLimitException exception) {
            System.err.println("Register limit was exceed!");
        } catch (ConvertToAssembly.UndefinedVariableUsage exception) {
            System.err.println("Undefined variable usage!");
        } catch (InfixToPostfix.SyntaxErrorException exception) {
            System.err.println("Syntax error!");
        }
    }
}
