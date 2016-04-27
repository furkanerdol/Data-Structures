package HW04_Furkan_Erdol_131044065;

import java.util.LinkedList;

/**
 * Data structure for registers
 * @author Furkan
 * @param <Register> Register
 *
 */
public class RegisterList<Register> extends LinkedList<Register>{

    /**
     * Constructor
     */
    public RegisterList(){
        super();
    }
    
    /**
     * Add register end of the register list
     * @param newRegister new register
     * @return
     */
    public boolean addRegister(Register newRegister){    
        return add(newRegister);
    }
    
}
