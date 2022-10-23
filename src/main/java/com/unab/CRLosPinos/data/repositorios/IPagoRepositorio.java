package com.unab.CRLosPinos.data.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.CRLosPinos.data.entidades.PagoEntidad;

@Repository
public interface IPagoRepositorio extends CrudRepository<PagoEntidad, Long> {

    PagoEntidad findById(String string);
                
    
}
