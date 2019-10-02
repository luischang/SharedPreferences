package pe.edu.cibertec.sharedpreferences;

/**
 * Created by angel on 04/11/2017.
 */

public class Usuario {
    private String usuario;
    private String clave;

    public Usuario(String usuario, String clave) {
        this.setUsuario(usuario);
        this.setClave(clave);
    }


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
