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
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        Optional<Usuario> u = usuarioRepository.findById(id);
        if(u.isPresent()) {
            Usuario existente = u.get();
            existente.setNombre_usuario(usuario.getNombre_usuario());
            existente.setCorreo(usuario.getCorreo());
            if(usuario.getRol() != null) {
                existente.setRol(usuario.getRol());
            }
            // Solo actualiza password si se envió
            if(usuario.getPassword() != null && !usuario.getPassword().isEmpty()) {
                existente.setPassword(usuario.getPassword());
            }
            return usuarioRepository.save(existente);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}
