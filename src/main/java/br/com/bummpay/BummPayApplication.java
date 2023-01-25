package br.com.bummpay;

import br.com.bummpay.domain.entity.Cliente;
import br.com.bummpay.domain.repository.Clientes;
import br.com.bummpay.domain.repository.Pedidos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BummPayApplication {

    public static void main (String[] args){
        SpringApplication.run(BummPayApplication.class, args);
    }

    /*@Value("${application.name}")
    private String getApplicationName;

    @GetMapping("/hello")
    public String helloWorld(){
        return getApplicationName;
    }*/
/*
    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes, Pedidos pedidos){
        return args -> {

         *//*   System.out.println("/nSalvando Clientes");
            Cliente cliente = clientes.save(new Cliente("Ana","123456789"));

            Pedido p = new Pedido();
            p.setCliente(cliente);
            p.setDataPedido(LocalDate.now());
            p.setTotal(BigDecimal.valueOf(100.00));

            pedidos.save(p);

            cliente = clientes.findClienteFetchPedido(cliente.getId());
            System.out.println(cliente);
            System.out.println(cliente.getPedidos());


            pedidos.findByCliente(cliente).forEach(System.out::println);
*//*

            System.out.println("/nSalvando Clientes");

            clientes.save(new Cliente("Ana","123456789"));
            clientes.save(new Cliente("Ronaldo","987456321"));
            clientes.save(new Cliente("Pedro","123789456"));
            clientes.save(new Cliente("Matheus","321897654"));

         *//*   List<Cliente> todosClientes = clientes.findAll();
            todosClientes.forEach(System.out::println);

            System.out.println("/nAtualizando Clientes");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " Atualizado");
                clientes.save(c);
                System.out.println(c.getNome());
            });


            System.out.println("/nBuscando cliente por nome");
            clientes.findByNomeLike("Pedro").forEach(System.out::println);


            todosClientes.forEach(System.out::println);


            clientes.findAll().forEach( c ->{
                clientes.delete(c);
            });

            todosClientes = clientes.findAll();
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum cliente encontrado");
            }else{
                todosClientes.forEach(System.out::println);
            }*//*


        };
    };*/



}
