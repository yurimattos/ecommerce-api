package br.com.serratec.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
=======

>>>>>>> 7a22df5d4842d4946f5e08216b335e2530228a81
import br.com.serratec.ecommerce.entity.Pedido;
import br.com.serratec.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> getAllPedidos(){
		return pedidoRepository.findAll();
	}
/*	
	public List<PedidoDTO> getAllPedidosDTO(){
		List<Pedido> listaPedido = pedidoRepository.findAll();
		List<PedidoDTO> listaPedidoDTO = new ArrayList<>();
		
		for(Pedido pedido: listaPedido) {
			PedidoDTO pedidoDTO = toDTO(pedido);
			listaPedidoDTO.add(pedidoDTO);
		}
	
		return listaPedidoDTO;
	}
	
*/	
	public Pedido getPedidoById(Integer id) {
		return pedidoRepository.findById(id).orElse(null);
	}
	
	public Pedido savePedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}
	
	public Pedido updatePedido(Pedido pedido, Integer id) {
		//Pedido pedidoExistenteNoBanco = pedidoRepository.findById(id).get();
		
		Pedido pedidoExistenteNoBanco = getPedidoById(id);

		pedidoExistenteNoBanco.setDataPedido(pedido.getDataPedido());
		pedidoExistenteNoBanco.setDataEntrega(pedido.getDataEntrega());
		pedidoExistenteNoBanco.setDataEnvio(pedido.getDataEnvio());
		pedidoExistenteNoBanco.setStatus(pedido.getStatus());
		pedidoExistenteNoBanco.setValorTotal(pedido.getValorTotal());
		
		return pedidoRepository.save(pedidoExistenteNoBanco);
		
		//return pedidoRepository.save(pedido);
	}

	public Pedido deletePedido(Integer id) {
		pedidoRepository.deleteById(id);
		return getPedidoById(id);
	}
	
<<<<<<< HEAD
//	public Pedido toEntidade(PedidoDTO pedidoDTO ) {
//		Pedido pedido = new Pedido();
//		
//		
//		pedido.setDataPedido(pedidoDTO.getDataPedido());
//		pedido.setDataEntrega(pedidoDTO.getDataEntrega());
//		pedido.setDataEnvio(pedidoDTO.getDataEnvio());
//		pedido.setStatus(pedidoDTO.getStatus());
//		pedido.setValorToral(pedidoDTO.getValorTotal());
//		
//		return pedido;
//	}
=======
/*	
	public Pedido toEntidade(PedidoDTO pedidoDTO ) {
		Pedido pedido = new Pedido();
		
		
		pedido.setDataPedido(pedidoDTO.getDataPedido());
		pedido.setDataEntrega(pedidoDTO.getDataEntrega());
		pedido.setDataEnvio(pedidoDTO.getDataEnvio());
		pedido.setStatus(pedidoDTO.getStatus());
		pedido.setValorToral(pedidoDTO.getValorTotal());
		
		return pedido;
	}
>>>>>>> 7a22df5d4842d4946f5e08216b335e2530228a81
	
//	public PedidoDTO toDTO(Pedido pedido) {
//		PedidoDTO pedidoDTO = new PedidoDTO();
//				
//		pedidoDTO.setIdPedido(pedido.getIdPedido());
//		pedidoDTO.setDataPedido(pedido.getDataPedido());
//		pedidoDTO.setDataEntrega(pedido.getDataEntrega());
//		pedidoDTO.setDataEnvio(pedido.getDataEnvio());
//		pedidoDTO.setStatus(pedido.getStatus());
//		pedidoDTO.setValorToral(pedido.getValorTotal());
//		pedidoDTO.setCliente(pedido.getCliente());
//		
//		
//		//BeanUtils.copyProperties(pedido, pedidoDTO);
//		
//		return pedidoDTO;
//	}
	
<<<<<<< HEAD
//	public PedidoResumoDTO toPedidoResumoDTO(Pedido pedido) {
//		PedidoResumoDTO pedidoResumoDTO = new PedidoResumoDTO();
//		
//	
//		BeanUtils.copyProperties(pedido, pedidoResumoDTO);
//		
//		return pedidoResumoDTO;
//	}
=======
	public PedidoResumoDTO toPedidoResumoDTO(Pedido pedido) {
		PedidoResumoDTO pedidoResumoDTO = new PedidoResumoDTO();
		
	
		BeanUtils.copyProperties(pedido, pedidoResumoDTO);
		
		return pedidoResumoDTO;
	}
*/	
	
>>>>>>> 7a22df5d4842d4946f5e08216b335e2530228a81
}
