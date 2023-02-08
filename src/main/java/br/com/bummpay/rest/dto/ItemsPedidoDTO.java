package br.com.bummpay.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsPedidoDTO {

    private Integer produto;
    private Integer quantidade;

    public Integer getProduto() {
        return produto;
    }
}
