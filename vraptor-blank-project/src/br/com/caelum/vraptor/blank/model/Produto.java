package br.com.caelum.vraptor.blank.model;

import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Produto {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull(message="Nome é obrigatório")
	@Length(min=3, message="Nome precisa ter mais de 3 letras")
	private String nome;
	
	@NotNull(message="Descrição é obrigatória")
	@Length(max=40, message="Descrição não pode ter mais de 40 letras")
	private String descricao;
	
	@Min(0)
	private Double preco;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
