package br.com.bummpay.service;

import br.com.bummpay.rest.dto.PedidoDTO;
import br.com.bummpay.domain.entity.Pedido;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

}
