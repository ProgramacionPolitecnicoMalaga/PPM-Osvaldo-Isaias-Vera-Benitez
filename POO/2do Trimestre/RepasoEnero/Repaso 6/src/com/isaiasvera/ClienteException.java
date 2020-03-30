package com.isaiasvera;

public class ClienteException extends Exception{
    public ClienteException(){
        super("El cliente ya existe.");
    }
}
