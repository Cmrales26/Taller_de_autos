package Autos;

/**
 *
 * @author Camilo
 */
public class Pickup extends Carro{
    private String numPasajeros;
    private String pesoMaxCarga;

    public Pickup(String numPasajeros, String pesoMaxCarga, String numPuertas, String velocidadmax, String munLlantas, String modelLlantas, String marca, String modelo, String numPlaca, String tipoCombustible) {
        super(numPuertas, velocidadmax, munLlantas, modelLlantas, marca, modelo, numPlaca, tipoCombustible);
        this.numPasajeros = numPasajeros;
        this.pesoMaxCarga = pesoMaxCarga;
    }
    
    @Override
     public String validad_placa(){
        return "SU NUMERO DE PLACA ES: " + super.getNumPlaca();
    }

    public String getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(String numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public String getPesoMaxCarga() {
        return pesoMaxCarga;
    }

    public void setPesoMaxCarga(String pesoMaxCarga) {
        this.pesoMaxCarga = pesoMaxCarga;
    }
    
    
}
