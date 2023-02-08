package br.com.bummpay.service.impl;

import br.com.bummpay.domain.entity.Cliente;
import br.com.bummpay.domain.entity.ItemPedido;
import br.com.bummpay.domain.entity.Pedido;
import br.com.bummpay.domain.entity.Produto;
import br.com.bummpay.domain.repository.Clientes;
import br.com.bummpay.domain.repository.ItemsPedido;
import br.com.bummpay.domain.repository.Pedidos;
import br.com.bummpay.domain.repository.Produtos;
import br.com.bummpay.exception.RegraNegocioException;
import br.com.bummpay.rest.dto.ItemsPedidoDTO;
import br.com.bummpay.rest.dto.PedidoDTO;
import br.com.bummpay.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    private final Pedidos pedidos;
    private final Clientes clientes;
    private final Produtos produtos;
    private final ItemsPedido itemsPedido;


    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());

        Cliente cliente = clientes.findById(dto.getCliente())
                .orElseThrow(() ->
                        new RegraNegocioException("Cliente não encontrado"));
        pedido.setCliente(cliente);

        List<ItemPedido> itemPedidos = converterItems(pedido, dto.getItems());

        pedidos.save(pedido);
        itemsPedido.saveAll(itemPedidos);
        pedido.setItemsPedidos(itemPedidos);

        return pedido;

    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemsPedidoDTO> items){
        if (items.isEmpty()){
            throw new RegraNegocioException("Não é possível fazer pedido sem items");
        }

        return items
                .stream()
                .map( dto -> {
                    Produto produto = produtos
                            .findById(dto.getProduto())
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de Produto inválido: "+dto.getProduto()
                                    ));


                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidos.findByIdFetchItens(id);

    }

}
