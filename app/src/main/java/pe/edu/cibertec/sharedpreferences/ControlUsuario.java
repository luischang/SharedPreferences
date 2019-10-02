package pe.edu.cibertec.sharedpreferences;

/**
 * Created by angel on 04/11/2017.
 */

public class ControlUsuario {
    /**Creamos una instancia estatica de ControlUsuario*/
    private static ControlUsuario controlUsuario = new ControlUsuario();

    /**Método estatico que devuelve el objeto creado*/
    public static ControlUsuario getInstance() {
        return controlUsuario;
    }
    /**Variables declaradas*/
    public Usuario current_usuario;
}
