package br.com.bummpay.rest.dto;

import br.com.bummpay.validation.NotEmpytList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/*   {
       "cliente": 1,
           "total": 100,
           "items": [
       {
           "produto" : 1,
               "quantidade" : 10
       }
   ]
   }*/
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedidoDTO {

    @NotNull(message = "{campo.codigo-cliente.obrigatorio}")
    private Integer cliente;
    @NotNull(message = "{campo.total-pedido.obrigatorio}")
    private BigDecimal total;
    @NotEmpytList(message = "{campo.items-pedido.obrigatorio}")
    private List<ItemsPedidoDTO> items;

}
