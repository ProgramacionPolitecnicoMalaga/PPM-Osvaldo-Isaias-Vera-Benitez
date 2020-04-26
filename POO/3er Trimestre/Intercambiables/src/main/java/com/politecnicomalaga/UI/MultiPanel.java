package com.politecnicomalaga.UI;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public interface MultiPanel {
    public static final int ESCRITURA = 1;
    public static final int LECTURA = 2;
    public static final int LOGIN = 3;

    public void notificarCambio(int cambio) throws SQLException, NoSuchAlgorithmException, IOException;
}
