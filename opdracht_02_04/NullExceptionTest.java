package com.jetbrains;

/**
 * short program to demonstrate nullpointerexception
 * @author Jeroen Weltens
 */
public class NullExceptionTest {

    /**calls a method from an uninitialised object*/
    public static void main(String[] args) {
        NullExceptionTest test = null;
        try{
            test.foo();
        } catch (NullPointerException e){
            System.err.println("in catch --> NullpointerException");
        }
    }

    private void foo(){}
}
