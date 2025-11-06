package com.cartotal.BackendProy.Service;

import com.cartotal.BackendProy.Model.Categoria;
import com.cartotal.BackendProy.Repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }
    public Optional<Categoria> findById(Long id){
        return  categoriaRepository.findById(id);
    }
    public Categoria GuardarCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
    public void EliminarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }
}
