package br.com.bummpay.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "login")
    @NotEmpty(message = "{campo.login.obrigatório}")
    private String login;
    @Column(name = "senha")
    @NotEmpty(message = "{campo.senha.obrigatório}")
    private String senha;
    @Column(name = "admin")
    private boolean admin;







}
