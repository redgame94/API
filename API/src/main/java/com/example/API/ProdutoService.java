package com.example.API;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> buscarTodos() {
        return repository.findAll();
    }
 
    public Produto buscarPorId(Long id) {
        Optional<Produto> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
    	
    public Produto atualizar(Long id, Produto produto) {
        return repository.findById(id).map(existente -> {
            existente.setNome(produto.getNome());
            existente.setDescricao(produto.getDescricao());
            existente.setPreco(produto.getPreco());
            existente.setQuantidade(produto.getQuantidade());
            return repository.save(existente);
        }).orElse(null);
    }
    }