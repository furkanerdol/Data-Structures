package HW04_Furkan_Erdol_131044065;

import HW04_Furkan_Erdol_131044065.AbstractConvertToAssembly.Register;
import HW04_Furkan_Erdol_131044065.ConvertToAssembly.RegisterLimitException;

/**
 * Interface for convertible assembly classes
 * @author Furkan
 */
public interface ConvertibleToAssembly {
    
    /**
     * For initialization process
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    public Register loadImmediate(String leftSide, int rightSide) throws RegisterLimitException ;

    /**
     * For assignment process
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    public Register move(Register leftSide, Register rightSide) throws RegisterLimitException ;

    /**
     * For add process
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    public Register add(Register leftSide, Register rightSide) throws RegisterLimitException;

    /**
     * For subtract process
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    public Register subtract(Register leftSide, Register rightSide) throws RegisterLimitException ;

    /**
     * For multiply process
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    public Register multiply(Register leftSide, Register rightSide) throws RegisterLimitException ;

    /**
     * For divide process
     * @param leftSide left operand ( register )
     * @param rightSide right operand ( register )
     * @return result register
     * @throws RegisterLimitException
     */
    public Register divide(Register leftSide, Register rightSide) throws RegisterLimitException ;

    /**
     * register
     * @param register to be written register
     * @return 
     */
    public Register printFunction(Register register);
    
}
