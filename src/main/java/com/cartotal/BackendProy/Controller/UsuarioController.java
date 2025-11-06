package com.cartotal.BackendProy.Controller;

import com.cartotal.BackendProy.Model.Usuario;
import com.cartotal.BackendProy.Repository.UsuarioRepository;
import com.cartotal.BackendProy.Service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.ListarUsuarios();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }
    @GetMapping("/{id}")
    public Optional<Usuario> buscarporid(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
    @DeleteMapping("{id}")
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
