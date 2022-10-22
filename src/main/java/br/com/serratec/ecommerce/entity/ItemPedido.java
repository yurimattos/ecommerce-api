package br.com.serratec.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item_pedido")
public class ItemPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_item_pedido")
	private Integer idItemPedido;
	
	@Column(name = "quantidade")
	private Float quantidade;
	
	@Column(name = "preco_venda")
	private Float precoVenda;
	
	@Column(name = "percentual_desconto")
	private Float percentualDesconto;
	
	@Column(name = "valor_bruto")
	private Float valorBruto;
	
	@Column(name = "valor_liquido")
	private Float valorLiquido;
	
	Pedido pedido;
	
	Produto produto;

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Float precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Float getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Float percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public Float getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(Float valorBruto) {
		this.valorBruto = valorBruto;
	}

	public Float getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(Float valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
