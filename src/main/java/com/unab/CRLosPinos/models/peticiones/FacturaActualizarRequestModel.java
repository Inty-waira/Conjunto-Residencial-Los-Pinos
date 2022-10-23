package com.unab.CRLosPinos.models.peticiones;

public class FacturaActualizarRequestModel {

    private String PagosCasa;
    private String PagosParqueadero;


    public String getPagosCasa() {
        return this.PagosCasa;
    }

    public void setPagosCasa(String PagosCasa) {
        this.PagosCasa = PagosCasa;
    }

    public String getPagosParqueadero() {
        return this.PagosParqueadero;
    }

    public void setPagosParqueadero(String PagosParqueadero) {
        this.PagosParqueadero = PagosParqueadero;
    }
 

}
