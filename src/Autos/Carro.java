package Autos;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Camilo&DV
 */
public class Carro extends Despedida{
    private String numPuertas;
    private String velocidadmax;
    private String munLlantas;
    private String modelLlantas;
    private String marca;
    private String modelo;
    private String numPlaca;
    private String tipoCombustible;

    public Carro(String numPuertas, String velocidadmax, String munLlantas, String modelLlantas, String marca, String modelo, String numPlaca, String tipoCombustible) {
        this.numPuertas = numPuertas;
        this.velocidadmax = velocidadmax;
        this.munLlantas = munLlantas;
        this.modelLlantas = modelLlantas;
        this.marca = marca;
        this.modelo = modelo;
        this.numPlaca = numPlaca;
        this.tipoCombustible = tipoCombustible;
      
    }

    public Carro() {
        
    }
    public String validad_placa(){
        return getNumPlaca();
    }
    
    @Override
    public void Despedida(){
       JOptionPane.showMessageDialog(null, " 🛠 MUCHAS GRACIAS POR CONFIAR EN NOSOTROS 🛠");
    }

    public String getModelLlantas() {
        return modelLlantas;
    }

    public void setModelLlantas(String modelLlantas) {
        this.modelLlantas = modelLlantas;
    }
    public String getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(String numPuertas) {
        this.numPuertas = numPuertas;
    }

    public String getVelocidadmax() {
        return velocidadmax;
    }

    public void setVelocidadmax(String velocidadmax) {
        this.velocidadmax = velocidadmax;
    }

    public String getMunLlantas() {
        return munLlantas;
    }

    public void setMunLlantas(String munLlantas) {
        this.munLlantas = munLlantas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumPlaca() {
        return numPlaca;
    }

    public void setNumPlaca(String numPlaca) {
        this.numPlaca = numPlaca;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
}
