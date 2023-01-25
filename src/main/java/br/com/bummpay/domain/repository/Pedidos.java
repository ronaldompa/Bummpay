package br.com.bummpay.domain.repository;

import br.com.bummpay.domain.entity.Cliente;
import br.com.bummpay.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Pedidos extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);


}
