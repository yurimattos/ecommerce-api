package br.com.serratec.ecommerce.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@NotBlank(message = "O Email deve ser informado")
	@Column(name = "email", unique = true)
	private String email;
	
	@NotBlank(message = "O nome deve ser informado")
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@NotBlank(message = "O CPF deve ser informado")
	@Pattern(regexp = "(([0-9]{3}[0-9]{3}[0-9]{3}[0-9]{2})|([0-9]{11}))", message = "O CPF deve conter apenas números")
	@Column(name = "cpf", unique = true)
	private String cpf;
	
	@Column(name = "telefone")
	private Integer telefone;
	
	@Column(name = "data_nascimento")
	private Instant dataNascimento;
	
	Endereco endereco;

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
}
