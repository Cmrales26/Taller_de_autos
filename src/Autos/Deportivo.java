package Autos;

/**
 *
 * @author Camilo
 */
public class Deportivo extends Carro{
    private String tipoTecho;

    public Deportivo(String tipoTecho, String numPuertas, String velocidadmax, String munLlantas, String modelLlantas, String marca, String modelo, String numPlaca, String tipoCombustible) {
        super(numPuertas, velocidadmax, munLlantas, modelLlantas, marca, modelo, numPlaca, tipoCombustible);
        this.tipoTecho = tipoTecho;
    }
    
    @Override
    public String validad_placa (){
        return "SU NUMERO DE PLACA ES: " + super.getNumPlaca();
    }

    public String getTipoTecho() {
        return tipoTecho;
    }

    public void setTipoTecho(String tipoTecho) {
        this.tipoTecho = tipoTecho;
    }
    
}
