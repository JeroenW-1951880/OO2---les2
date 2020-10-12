package com.jetbrains;

/**
 * short program to test out the basics of exception handling
 * @author Jeroen Weltens
 */
public class Exceptiontest1 {
    /**Method that throws exception*/
    public static void throwtest() throws Exception{
        System.out.println("in method");
        Exception e = new Exception("test");
        throw e;
    }

    /**try-catch-finallytest*/
    public static void main(String[] args) {
        try {
            System.out.println("in try-block");
            throwtest();
        } catch (Exception e){
            System.out.println("in catch-block");
            System.err.println(e.getMessage());
        } finally {
            System.out.println("in finally-block");
        }
    }
}
