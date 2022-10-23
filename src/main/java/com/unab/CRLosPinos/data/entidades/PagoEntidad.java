package com.unab.CRLosPinos.data.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "pago")
public class PagoEntidad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)   
    private String nombreValor;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagoEntidadCasa")
    private List<FacturaEntidad> facturaEntidadCasaList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pagoEntidadParqueadero")
    private List<FacturaEntidad> facturaEntidadParqueaderoList = new ArrayList<>();
    

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

    public List<FacturaEntidad> getFacturaEntidadCasaList() {
        return this.facturaEntidadCasaList;
    }

    public void setFacturaEntidadCasaList(List<FacturaEntidad> facturaEntidadCasaList) {
        this.facturaEntidadCasaList = facturaEntidadCasaList;
    }

    public List<FacturaEntidad> getFacturaEntidadParqueaderoList() {
        return this.facturaEntidadParqueaderoList;
    }

    public void setFacturaEntidadParqueaderoList(List<FacturaEntidad> facturaEntidadParqueaderoList) {
        this.facturaEntidadParqueaderoList = facturaEntidadParqueaderoList;
    }

}
