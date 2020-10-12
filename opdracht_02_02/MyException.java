package com.jetbrains;

/**
 * Simpele exceptie die een string data kan bevatten en uitprinten naar stderror
 * @author Jeroen Weltens
 */
public class MyException extends Exception {
    private String $data;

    /**Constructor */
    MyException(String data){ $data = data; }

    /**method die de data van de exceptie naar stderror print*/
    public void print(){
        System.err.println($data);
    }
}
