package Diagnostico;

/**
 *
 * @author Camilo&DV
 */
public class Diagnostico {
    private String posibleDiagnostico;
    private String Precio;
    private String Tiempo;
    private String Detalles;

    public Diagnostico(String posibleDiagnostico, String Precio, String Tiempo, String Detalles) {
        this.posibleDiagnostico = posibleDiagnostico;
        this.Precio = Precio;
        this.Tiempo = Tiempo;
        this.Detalles = Detalles;
    }

    public String getPosibleDiagnostico() {
        return posibleDiagnostico;
    }

    public void setPosibleDiagnostico(String posibleDiagnostico) {
        this.posibleDiagnostico = posibleDiagnostico;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String Tiempo) {
        this.Tiempo = Tiempo;
    }

    public String getDetalles() {
        return Detalles;
    }

    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }
}
