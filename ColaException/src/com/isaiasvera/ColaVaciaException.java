package com.isaiasvera;

public class ColaVaciaException extends Exception{
    public ColaVaciaException(String message){
        super(message);
        System.out.println("La cola está vacía");
    }
}
