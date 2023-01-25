package br.com.bummpay.domain.repository;

import br.com.bummpay.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Clientes extends JpaRepository<Cliente, Integer> {

    @Query(value = "select * from cliente c where c.nome like '%:nome%' ", nativeQuery = true)
    List<Cliente> encontrarPorNome (@Param("nome") String nome);

    @Query(value = "delete from cliente c where c c.nome = :nome ", nativeQuery = true)
    @Modifying
    void deleteByNome(@Param("nome") String nome);

    List<Cliente> findByNomeLike(String nome);

    boolean existsByNome (String nome);

    // Fetch -> Trazer junto os dados dos pedidos
    @Query( " select c from Cliente c left join fetch c.pedidos where c.id = :id") //HQL
    Cliente findClienteFetchPedido(@Param("id") Integer id);


}
