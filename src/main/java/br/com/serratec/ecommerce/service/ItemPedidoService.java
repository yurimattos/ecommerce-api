package br.com.serratec.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommerce.entity.ItemPedido;
import br.com.serratec.ecommerce.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {

	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public List<ItemPedido> getAllItemPedidos(){
		return itemPedidoRepository.findAll();
	}
<<<<<<< HEAD
	
//	public List<ItemPedidoDTO> getAllItemPedidosDTO(){
//		List<ItemPedido> listaItemPedido = itemPedidoRepository.findAll();
//		List<ItemPedidoDTO> listaItemPedidoDTO = new ArrayList<>();
//		
//		for(ItemPedido itemPedido: listaItemPedido) {
//			ItemPedidoDTO itemPedidoDTO = toDTO(itemPedido);
//			listaItemPedidoDTO.add(itemPedidoDTO);
//		}
//		
//		return listaItemPedidoDTO;
//	}
=======

/*
	public List<ItemPedidoDTO> getAllItemPedidosDTO(){
		List<ItemPedido> listaItemPedido = itemPedidoRepository.findAll();
		List<ItemPedidoDTO> listaItemPedidoDTO = new ArrayList<>();
		
		for(ItemPedido itemPedido: listaItemPedido) {
			ItemPedidoDTO itemPedidoDTO = toDTO(itemPedido);
			listaItemPedidoDTO.add(itemPedidoDTO);
		}
		
		return listaItemPedidoDTO;
	}
*/
>>>>>>> 7a22df5d4842d4946f5e08216b335e2530228a81
	
	public ItemPedido getItemPedidoById(Integer id) {
		//return itemPedidoRepository.findById(id).get();
		return itemPedidoRepository.findById(id).orElse(null);
	}
	
	public ItemPedido saveItemPedido(ItemPedido itemPedido) {
		return itemPedidoRepository.save(itemPedido);
	}
	
	public ItemPedido updateItemPedido(ItemPedido itemPedido, Integer id) {
		//ItemPedido itemPedidoExistenteNoBanco = itemPedidoRepository.findById(id).get();
		
		ItemPedido itemPedidoExistenteNoBanco = getItemPedidoById(id);
		
//		itemPedidoExistenteNoBanco.setIdItemPedido(itemPedido.getIdItemPedido());
		itemPedidoExistenteNoBanco.setQuantidade(itemPedido.getQuantidade());
		itemPedidoExistenteNoBanco.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoExistenteNoBanco.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoExistenteNoBanco.setValorBruto(itemPedido.getValorBruto());
		itemPedidoExistenteNoBanco.setValorLiquido(itemPedido.getValorLiquido());
//		itemPedidoExistenteNoBanco.setPedido(itemPedido.getPedido());
//		itemPedidoExistenteNoBanco.setProduto(itemPedido.getProduto());
		
		
		return itemPedidoRepository.save(itemPedidoExistenteNoBanco);	
	}

	public ItemPedido deleteItemPedido(Integer id) {
		itemPedidoRepository.deleteById(id);
		return getItemPedidoById(id);
	}
	
<<<<<<< HEAD
//	public ItemPedido toEntidade(ItemPedidoDTO itemPedidoDTO ) {
//		ItemPedido itemPedido = new ItemPedido();
//		
//		itemPedido.setIdItemPedido(itemPedidoDTO.getIdItemPedido());
//		itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
//		itemPedido.setPrecoVenda(itemPedidoDTO.getPrecoVenda());
//		itemPedido.setPercentualDesconto(itemPedidoDTO.getPercentualDesconto());
//		itemPedido.setValorBruto(itemPedidoDTO.getValorBruto());
//		itemPedido.setValorLiquido(itemPedidoDTO.getValorLiquido());
//		itemPedido.setPedido(itemPedidoDTO.getPedido());
//		itemPedido.setProduto(itemPedidoDTO.getProduto());
//		
//		return itemPedido;
//	}
	
//	public ItemPedidoDTO toDTO(ItemPedido itemPedido) {
//		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
//		
//		itemPedidoDTO.setIdItemPedido(itemPedido.getIdItemPedido());
//		itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
//		itemPedidoDTO.setPrecoVenda(itemPedido.getPrecoVenda());
//		itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
//		itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
//		itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
//		itemPedidoDTO.setPedido(itemPedido.getPedido());
//		itemPedidoDTO.setProduto(itemPedido.getProduto());
//		
//		return itemPedidoDTO;
//	}
//	
//	public ItemPedidoResumoDTO toItemPedidoResumoDTO(ItemPedido itemPedido) {
//		ItemPedidoResumoDTO itemPedidoResumoDTO = new ItemPedidoResumoDTO();
//		
//		
//		BeanUtils.copyProperties(itemPedido, itemPedidoResumoDTO);
//		
//		return itemPedidoResumoDTO;
//	}
=======
/*	
	public ItemPedido toEntidade(ItemPedidoDTO itemPedidoDTO ) {
		ItemPedido itemPedido = new ItemPedido();
		
		itemPedido.setIdItemPedido(itemPedidoDTO.getIdItemPedido());
		itemPedido.setQuantidade(itemPedidoDTO.getQuantidade());
		itemPedido.setPrecoVenda(itemPedidoDTO.getPrecoVenda());
		itemPedido.setPercentualDesconto(itemPedidoDTO.getPercentualDesconto());
		itemPedido.setValorBruto(itemPedidoDTO.getValorBruto());
		itemPedido.setValorLiquido(itemPedidoDTO.getValorLiquido());
		itemPedido.setPedido(itemPedidoDTO.getPedido());
		itemPedido.setProduto(itemPedidoDTO.getProduto());
		
		return itemPedido;
	}
	
	public ItemPedidoDTO toDTO(ItemPedido itemPedido) {
		ItemPedidoDTO itemPedidoDTO = new ItemPedidoDTO();
		
		itemPedidoDTO.setIdItemPedido(itemPedido.getIdItemPedido());
		itemPedidoDTO.setQuantidade(itemPedido.getQuantidade());
		itemPedidoDTO.setPrecoVenda(itemPedido.getPrecoVenda());
		itemPedidoDTO.setPercentualDesconto(itemPedido.getPercentualDesconto());
		itemPedidoDTO.setValorBruto(itemPedido.getValorBruto());
		itemPedidoDTO.setValorLiquido(itemPedido.getValorLiquido());
		itemPedidoDTO.setPedido(itemPedido.getPedido());
		itemPedidoDTO.setProduto(itemPedido.getProduto());
		
		return itemPedidoDTO;
	}
	
	public ItemPedidoResumoDTO toItemPedidoResumoDTO(ItemPedido itemPedido) {
		ItemPedidoResumoDTO itemPedidoResumoDTO = new ItemPedidoResumoDTO();
		
		
		BeanUtils.copyProperties(itemPedido, itemPedidoResumoDTO);
		
		return itemPedidoResumoDTO;
	}
*/
>>>>>>> 7a22df5d4842d4946f5e08216b335e2530228a81
	
}
