package br.com.serratec.ecommerce.dto;

import java.time.Instant;

public class RelatorioDePedidoDTO {

		private Integer idPedido;
		private Instant dataPedido;
		private Double valorTotal;
		
		
		public Integer getIdPedido() {
			return idPedido;
		}
		public void setIdPedido(Integer idPedido) {
			this.idPedido = idPedido;
		}
		public Instant getDataPedido() {
			return dataPedido;
		}
		public void setDataPedido(Instant dataPedido) {
			this.dataPedido = dataPedido;
		}
		public Double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}
}
