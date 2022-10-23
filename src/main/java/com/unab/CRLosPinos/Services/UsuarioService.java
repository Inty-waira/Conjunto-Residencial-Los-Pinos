package com.unab.CRLosPinos.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unab.CRLosPinos.Shared.FacturaDto;
import com.unab.CRLosPinos.Shared.UsuarioDto;
import com.unab.CRLosPinos.data.entidades.FacturaEntidad;
import com.unab.CRLosPinos.data.entidades.UsuarioEntidad;
import com.unab.CRLosPinos.data.repositorios.IFacturaRepositorio;
import com.unab.CRLosPinos.data.repositorios.IUsuarioRepositorio;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    ModelMapper modelmapper;

    @Autowired
    IUsuarioRepositorio iUsuarioRepositorio;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    IFacturaRepositorio iFacturaRepositorio;

    @Override
    public UsuarioDto crearUsuario(UsuarioDto usuarioCrearDto) {

        if (iUsuarioRepositorio.findByEmail(usuarioCrearDto.getEmail()) != null) {
            throw new RuntimeException("Este correo ya se encuentra Registrado");
        }
        if (iUsuarioRepositorio.findByUsername(usuarioCrearDto.getUsername()) != null) {
            throw new RuntimeException("Este usuario ya se encuentra Registrado");
        }
        
        UsuarioEntidad usuarioEntidadDto = modelmapper.map(usuarioCrearDto, UsuarioEntidad.class);
        usuarioEntidadDto.setIdUsuario(UUID.randomUUID().toString());
        usuarioEntidadDto.setPasswordEncriptada(bCryptPasswordEncoder.encode(usuarioCrearDto.getPassword()));

        UsuarioEntidad usuarioEntidadRes = iUsuarioRepositorio.save(usuarioEntidadDto);

        UsuarioDto usuarioDto = modelmapper.map(usuarioEntidadRes, UsuarioDto.class);

        return usuarioDto;
    }

    @Override
    public UsuarioDto leeUsuario(String username) {
        
        UsuarioEntidad usuarioEntidad = iUsuarioRepositorio.findByUsername(username);
        
        if (usuarioEntidad == null) {
            throw new UsernameNotFoundException(username);
        }

        UsuarioDto usuarioDto = modelmapper.map(usuarioEntidad, UsuarioDto.class);

        return usuarioDto;
    }

    @Override
    public List<FacturaDto> leerFacturas(String username) {

        UsuarioEntidad usuarioEntidad= iUsuarioRepositorio.findByUsername(username);

        List<FacturaEntidad> facturaEntidadList= iFacturaRepositorio.getByUsuarioEntidadIdOrderByGeneradoDesc(usuarioEntidad.getId());
        
        List<FacturaDto> facturaoDtoList= new ArrayList<>();

        for(FacturaEntidad facturaEntidad  : facturaEntidadList){
            FacturaDto facturaDto= modelmapper.map(facturaEntidad, FacturaDto.class);
            facturaoDtoList.add(facturaDto);
        }

        return facturaoDtoList;
    }

     @Override
     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        UsuarioEntidad usuarioEntidad= iUsuarioRepositorio.findByUsername(username);

        if(usuarioEntidad==null){
            throw new UsernameNotFoundException(username);
        }

        User  usuario= new User(usuarioEntidad.getUsername(), usuarioEntidad.getPasswordEncriptada(), new ArrayList<>());

        return usuario;
    } 
    
}
