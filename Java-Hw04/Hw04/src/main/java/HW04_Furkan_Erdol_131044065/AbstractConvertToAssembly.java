package HW04_Furkan_Erdol_131044065;

/**
 * Abstract class for convert assembly
 * @author Furkan
 */
public abstract class AbstractConvertToAssembly implements ConvertibleToAssembly {

    private final static RegisterList<Register> REGISTERLIST = new RegisterList<Register>();

    /**
     * Creates register data base ( constructor )
     */
    public AbstractConvertToAssembly() {
        REGISTERLIST.add(new Register("$t0"));
        REGISTERLIST.add(new Register("$t1"));
        REGISTERLIST.add(new Register("$t2"));
        REGISTERLIST.add(new Register("$t3"));
        REGISTERLIST.add(new Register("$t4"));
        REGISTERLIST.add(new Register("$t5"));
        REGISTERLIST.add(new Register("$t6"));
        REGISTERLIST.add(new Register("$t7"));
        REGISTERLIST.add(new Register("$t8"));
        REGISTERLIST.add(new Register("$a0"));
        REGISTERLIST.add(new Register("$v0"));
    }

    /**
     * Getter for register list
     * @return register list
     */
    public RegisterList getRegisterList() {
        return REGISTERLIST;
    }

    /**
     * Getter for register in register list
     * @param index
     * @return register
     */
    public Register getRegisterInRegisterList(int index) {
        return REGISTERLIST.get(index);
    }
    
    /**
     * Finds variable's register
     * @param variableName search name
     * @return register
     * @throws ConvertAssembly.UndefinedVariableUsage
     */
    public Register findRegister(String variableName) throws ConvertToAssembly.UndefinedVariableUsage {
        for (int i = 0; i < getRegisterList().size() - 2; ++i) {
            if (getRegisterInRegisterList(i).getVariableName() != null && getRegisterInRegisterList(i).getVariableName().compareTo(variableName) == 0) {
                return getRegisterInRegisterList(i);
            }
        }
        throw new ConvertToAssembly.UndefinedVariableUsage("Undifened variable usage!");
    }

    /**
     * Inner register class
     */
    public static class Register {

        private String registerName = null;
        private String variableName = null;
        private boolean free = true;
        private int integerValue = 0;

        /**
         * Constructor
         */
        public Register() {

        }

        /**
         * Constructor
         * @param newRegisterType
         */
        public Register(String newRegisterType) {
            registerName = newRegisterType;
        }

        /**
         *
         * @return
         */
        public String getRegisterName() {
            return registerName;
        }

        /**
         * Getter for variable name
         * @return variable name
         */
        public String getVariableName() {
            return variableName;
        }

        /**
         * Getter for integer value
         * @return integer value
         */
        public int getIntegerValue() {
            return integerValue;
        }

        /**
         * Setter for variable name
         * @param newVariableName new variable name
         */
        public void setVariableName(String newVariableName) {
            variableName = newVariableName;
        }

        /**
         * Setter for integer value
         * @param newIntegerValue new integer value
         */
        public void setIntegerValue(int newIntegerValue) {
            integerValue = newIntegerValue;
        }

        /**
         * Return true if register is free
         * @return true or false
         */
        public boolean isFree() {
            return free;
        }

        /**
         * Change register status
         * @param newStatus new status true or false
         */
        public void changeFreeStatus(boolean newStatus) {
            free = newStatus;
        }

        @Override
        public String toString() {
            String formatted = new String();
            formatted += String.format("Register type : "
                    + getRegisterName() + "\n" + "Register variable name : "
                    + getVariableName() + "\n" + "Register value : " + getIntegerValue() + "\n" + "Is free : " + isFree());

            return formatted;
        }
    }

    @Override
    public String toString() {
        String formatted = new String();
        for (int i = 0; i < REGISTERLIST.size(); ++i) {
            formatted += String.format("\n############################\n" + getRegisterInRegisterList(i).toString());
        }

        return formatted;
    }
}
