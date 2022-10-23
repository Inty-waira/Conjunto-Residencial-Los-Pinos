package com.unab.CRLosPinos.Shared;

import java.util.ArrayList;
import java.util.List;

public class PagoDto {
    
    private long id;
    private String nombreValor;
    private List<FacturaDto> facturaDtoCasaList = new ArrayList<>();
    private List<FacturaDto> facturaDtoParqueaderoList = new ArrayList<>();


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreValor() {
        return this.nombreValor;
    }

    public void setNombreValor(String nombreValor) {
        this.nombreValor = nombreValor;
    }

    public List<FacturaDto> getFacturaDtoCasaList() {
        return this.facturaDtoCasaList;
    }

    public void setFacturaDtoCasaList(List<FacturaDto> facturaDtoCasaList) {
        this.facturaDtoCasaList = facturaDtoCasaList;
    }

    public List<FacturaDto> getFacturaDtoParqueaderoList() {
        return this.facturaDtoParqueaderoList;
    }

    public void setFacturaDtoParqueaderoList(List<FacturaDto> facturaDtoParqueaderoList) {
        this.facturaDtoParqueaderoList = facturaDtoParqueaderoList;
    }

    
}
