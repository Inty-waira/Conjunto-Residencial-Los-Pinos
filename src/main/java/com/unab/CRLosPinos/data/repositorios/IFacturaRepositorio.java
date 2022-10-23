package com.unab.CRLosPinos.data.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.unab.CRLosPinos.data.entidades.FacturaEntidad;



@Repository
public interface IFacturaRepositorio extends PagingAndSortingRepository<FacturaEntidad, Long> {

    List<FacturaEntidad> getByUsuarioEntidadIdOrderByGeneradoDesc(long usuarioEntidadId);

    @Query(nativeQuery = true, value = "SELECT * FROM partido ORDER BY generado DESC LIMIT 12")
    List<FacturaEntidad> facturasGeneradas();

    FacturaEntidad findByIdFactura(String id);

    
}
