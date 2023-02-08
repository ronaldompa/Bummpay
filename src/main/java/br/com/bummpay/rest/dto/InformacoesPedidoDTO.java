package br.com.bummpay.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InformacoesPedidoDTO {
    private Integer código;
    private String cpf;
    private String nomeCliente;
    private BigDecimal total;
    private String dataPedido;
    private List<InformacaoItemPedidoDTO> items;

}
