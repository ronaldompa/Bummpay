/*
package br.com.bummpay.rest.controller;

import br.com.bummpay.domain.entity.Cliente;
import br.com.bummpay.domain.repository.Clientes;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes/")
public class ClienteController_old {

    private Clientes clientes;

    public ClienteController_old(Clientes clientes) {
        this.clientes = clientes;
    }
    */
/*    @RequestMapping(
            value = {"/api/clientes/hello/{nome}", "/api/hello"},
            method = RequestMethod.POST,
            consumes = {"application/json","application/xml"},
            produces = {"application/json","application/xml"}
    )


    @ResponseBody
    public Cliente helloCliente(@PathVariable("nome") String nomeCliente, @ResponseBody Cliente cliente){
        return String.format("Hello %s ", nomeCliente);
    };*//*


    @GetMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity getClientebyID(@PathVariable("id") Integer id){
        Optional<Cliente> cliente = clientes.findById(id);
        if(cliente.isPresent()){
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("api/clientes")
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente){
        Cliente c = clientes.save(cliente);
        return ResponseEntity.ok(c);
    }

    @DeleteMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Integer id){
        Optional<Cliente> cliente = clientes.findById(id);
        if(cliente.isPresent()){
            clientes.delete(cliente.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/api/clientes/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Cliente cliente){
        return clientes
                .findById(id)
                .map( clienteExistente -> {
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                }).orElseGet( () -> ResponseEntity.notFound().build());
    }

    @GetMapping("/api/clientes")
    public ResponseEntity find(Cliente filtro){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(filtro, matcher);
        List<Cliente> lista = clientes.findAll(example);
        return ResponseEntity.ok(lista);
    }


}
*/
