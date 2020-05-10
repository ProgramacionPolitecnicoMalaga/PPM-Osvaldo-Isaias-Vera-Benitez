package com.politecnicomalaga.Reader;

import io.github.cdimascio.dotenv.Dotenv;

public class LectorENV {
    public static String getTipo(){
        return Dotenv.configure().load().get("viewer");
    }
}
