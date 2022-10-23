package com.unab.CRLosPinos.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.unab.CRLosPinos.Shared.FacturaDto;
import com.unab.CRLosPinos.Shared.UsuarioDto;

public interface IUsuarioService extends UserDetailsService {
    
    UsuarioDto crearUsuario(UsuarioDto usuarioCrearDto);

    UsuarioDto leeUsuario(String username);

    List<FacturaDto> leerFacturas(String username);
    
}
