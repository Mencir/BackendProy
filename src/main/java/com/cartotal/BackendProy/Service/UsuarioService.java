package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.Usuario;
import com.cartotal.BackendProy.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> ListarUsuarios() {
        return usuarioRepository.findAll();
    }
    public Usuario registrarUsuario(Usuario usuario) {
        if(usuarioRepository.existsByCorreo(usuario.getCorreo())) {
            throw new RuntimeException("Usuario ya existe");
        }
        return usuarioRepository.save(usuario);
    }
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}
