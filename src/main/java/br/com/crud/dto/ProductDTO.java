package br.com.crud.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private String nome;

    private Long stock;

    private Double price;
}
