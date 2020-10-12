package com.jetbrains;

/**
 * Kort programma om het werken met een zelfgemaakte exceptie uit te testen
 * @author Jeroen Weltens
 */
public class CustomExceptionTest {
    /**throw zelfgemaakte exceptie*/
    private static void CustomThrow() throws MyException{
        throw new MyException("test");
    }

    /**throw en catch van zelfgemaakte exceptie*/
    public static void main(String[] args) {
        try{
            CustomThrow();
        } catch (MyException e){
            e.print();
        }
    }
}
