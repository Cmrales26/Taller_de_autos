package Usuario;

import java.util.Vector;

/**
 *
 * @author Camilo
 */
public class ListaUsuario {

    private static Vector<Usuario> datos = new Vector<Usuario>();

    public static void agregar (Usuario obj) {
        datos.addElement(obj);
    }
    public static Vector mostrar() {
        return datos;
    }

}
