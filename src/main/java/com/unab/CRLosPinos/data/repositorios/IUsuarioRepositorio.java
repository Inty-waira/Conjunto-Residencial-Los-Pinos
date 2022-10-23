package com.unab.CRLosPinos.data.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.unab.CRLosPinos.data.entidades.UsuarioEntidad;

@Repository
public interface IUsuarioRepositorio extends CrudRepository<UsuarioEntidad, Long> {

    public UsuarioEntidad findByEmail(String email);

    public UsuarioEntidad findByUsername(String username);
    
}
 