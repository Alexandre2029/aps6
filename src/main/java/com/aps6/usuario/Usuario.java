package com.aps6.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuarios")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cargo;
    private String digital;


    public Usuario(String nome, String cargo, String digital) {
        this.nome = nome;
        this.cargo = cargo;
        this.digital = digital;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "digital='" + digital + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }

    public Usuario(Usuario a) {
        this.nome = a.getNome();
        this.cargo = a.getCargo();
        this.digital = a.getDigital();
    }




}
