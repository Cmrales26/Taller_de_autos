package Usuario;

import java.util.Vector;

/**
 *
 * @author Camilo&DV
 */
public class Usuario {

    private String user;
    private String pass;
    private String tipo;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public static String saludo(String tipo_usuario){
        return "Ha ingresado con una cuenta de tipo" + tipo_usuario;
    }
     public static String saludo(String tipo_admin, boolean ingreso){
        return "Ha ingresado con una cuenta de tipo" + tipo_admin;
    }

    public static int usuarioNuevo(String usuario) {
        Vector lista = mostrar();
        Usuario us;
        for (int i = 0; i < lista.size(); i++) {
            us = (Usuario) lista.elementAt(i);
            if (us.getUser().equalsIgnoreCase(usuario)) {
                return i;
            }

        }
        return -1;
    }
    
    public static int ingreso (String usuario, String contraseña, String tipo){
        Vector lista = mostrar();
        Usuario us;
        for (int i = 0; i < lista.size(); i++) {
            us = (Usuario)lista.elementAt(i);
            if (us.getUser().equalsIgnoreCase(usuario) && us.getPass().equalsIgnoreCase(contraseña)&& us.getTipo().equalsIgnoreCase(tipo)) {
                return i;
            }
        }
        return -1;
    }

    public static Vector mostrar() {
        return ListaUsuario.mostrar();
    }
}
