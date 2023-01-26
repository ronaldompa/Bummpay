package br.com.bummpay.rest.controller;

import br.com.bummpay.domain.entity.Cliente;
import br.com.bummpay.domain.entity.Produto;
import br.com.bummpay.domain.repository.Produtos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private Produtos produtos;

    public ProdutoController(Produtos produtos) {
        this.produtos = produtos;
    }

    @GetMapping("{id}")
    public Produto getByIdProduto (@PathVariable Integer id){
        return produtos.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado"));
    };

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto save(@RequestBody Produto produto){
        return produtos.save(produto);
    }


    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        produtos.findById(id)
                .map( produto -> {
                    produtos.delete(produto);
                    return produto;
                })
                .orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Produto produto){
        produtos
                .findById(id)
                .map( clienteExistente -> {
                    produto.setId(clienteExistente.getId());
                    produtos.save(produto);
                    return ResponseEntity.noContent().build();
                }).orElseThrow( () ->  new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado"));
    }

    @GetMapping()
    public List<Cliente> find(Produto filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = produtos.findAll(example);
        return produtos.findAll(example);
    }


}
