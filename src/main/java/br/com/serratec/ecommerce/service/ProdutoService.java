package br.com.serratec.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.serratec.ecommerce.entity.Produto;
import br.com.serratec.ecommerce.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
/*
	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	CategoriaService categoriaService;

*/	
	
//	@Autowired
//	EmailService emailService;
	
//	@Value("${imgbb.host.url}")
//	private String imgBBHostUrl;
//	
//	@Value("${imgbb.host.key}")
//    private String imgBBHostKey;

		
//	@Autowired
//	EmailService emailService;
	
//	@Value("${imgbb.host.url}")
//	private String imgBBHostUrl;
//	
//	@Value("${imgbb.host.key}")
//    private String imgBBHostKey;

	
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}

	
//	public List<ProdutoDTO> getAllProdutosDTO(){
//		List<Produto> listaProduto = produtoRepository.findAll();
//		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();
//		
//		//1. Percorrer a lista de entidades Produto (chamada listaProduto)
//		//2. Na lista de entidade, pegar cada entidade existente nela
//		for(Produto produto: listaProduto) {
//			//3. Transformar cada entidade existente na lista em um DTO
//			ProdutoDTO produtoDTO = toDTO(produto);
//
//			//OBS: para converter a entidade no DTO, usar o metodo toDTO
//			//4. Adicionar cada DTO (que foi transformado a partir da entidade) na lista de DTO
//			listaProdutoDTO.add(produtoDTO);
//		}
//		
//		//5. Retornar/devolver a lista de DTO preenchida
//		return listaProdutoDTO; 


/*	
	public List<ProdutoDTO> getAllProdutosDTO(){
		List<Produto> listaProduto = produtoRepository.findAll();
		List<ProdutoDTO> listaProdutoDTO = new ArrayList<>();
		
		//1. Percorrer a lista de entidades Produto (chamada listaProduto)
		//2. Na lista de entidade, pegar cada entidade existente nela
		for(Produto produto: listaProduto) {
			//3. Transformar cada entidade existente na lista em um DTO
			ProdutoDTO produtoDTO = toDTO(produto);

			//OBS: para converter a entidade no DTO, usar o metodo toDTO
			//4. Adicionar cada DTO (que foi transformado a partir da entidade) na lista de DTO
			listaProdutoDTO.add(produtoDTO);
		}
		
		//5. Retornar/devolver a lista de DTO preenchida
		return listaProdutoDTO; 
	}
*/

	
	public Produto getProdutoById(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}


//	public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {
//		Produto produto = toEntidade(produtoDTO);
//		Produto novaProduto = produtoRepository.save(produto);
//		
//		ProdutoDTO produtoAtualizadaDTO = toDTO(novaProduto);
//		return produtoAtualizadaDTO;
//	}

/*	
	public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {
		Produto produto = toEntidade(produtoDTO);
		Produto novaProduto = produtoRepository.save(produto);
		
		ProdutoDTO produtoAtualizadaDTO = toDTO(novaProduto);
		return produtoAtualizadaDTO;
	}

	

	public ProdutoDTO saveProdutoDTOOtimizado(ProdutoDTO produtoDTO) {
		Produto novaProduto = produtoRepository.save(toEntidade(produtoDTO));
		return toDTO(novaProduto);
	}
	public ProdutoDTO saveProdutoDTOOtimizadoTwo(ProdutoDTO produtoDTO) {
		return toDTO(produtoRepository.save(toEntidade(produtoDTO)));
	}
	
	
//	public ProdutoDTO updateProdutoDTO(ProdutoDTO produtoDTO, Integer id) {
//		Produto produtoExistenteNoBanco = getProdutoById(id);
//		ProdutoDTO produtoAtualizadoDTO = new ProdutoDTO();
//		
//		if(produtoExistenteNoBanco != null) {
//			produtoDTO.setIdProduto(produtoExistenteNoBanco.getIdProduto());
//			produtoExistenteNoBanco = toEntidade(produtoDTO);
//			
//			Produto produtoAtualizado = produtoRepository.save(produtoExistenteNoBanco);
//			
//			produtoAtualizadoDTO = toDTO(produtoAtualizado);
//			
//		}
//		emailService.sendEmail("mail@mail.com", "Teste de envio de email", 
//				produtoAtualizadoDTO.toString());
//		
//		return produtoAtualizadoDTO;
//	}
	
//	private Produto toEntidade (ProdutoDTO produtoDTO) {
//		Produto produto = new Produto();
//		
//		produto.setIdProduto(produtoDTO.getIdProduto());
//		produto.setNome(produtoDTO.getNome());
//		return produto;
//	}
	
<<<<<<< HEAD
//	private ProdutoDTO toDTO(Produto produto) {
//		ProdutoDTO produtoDTO = new ProdutoDTO();
//
///*		
=======
	private ProdutoDTO toDTO(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();

		
>>>>>>> 7a22df5d4842d4946f5e08216b335e2530228a81
//		produtoDTO.setCodigoProduto(produto.getCodigoProduto());
//		produtoDTO.setNome(produto.getNome());
//		produtoDTO.setImagemFileName(produto.getImagemFileName());
//		produtoDTO.setImagemNome(produto.getImagemNome());
//		produtoDTO.setImagemUrl(produto.getImagemUrl());
<<<<<<< HEAD
//		*/
//
//		produtoDTO.setIdProduto(produto.getIdProduto());
//		produtoDTO.setNome(produto.getNome());
//		produtoDTO.setDescricao(produto.getDescricao());
//		produtoDTO.setQtdEstoque(produto.getQtdEstoque());
//		produtoDTO.setDataCadastro(produto.getDataCadastro());
//		produtoDTO.setValorUnitario(produto.getValorUnitario());
//		produtoDTO.setImagem(produto.getImagem());
//		produtoDTO.setCategoria(produto.getCategoria());
//		
//		return produtoDTO;
//	}
	
	public Produto updateProduto(Produto produto, Integer id) {
		//Produto produtoExistenteNoBanco = produtoRepository.findById(id).get();
		
		Produto produtoExistenteNoBanco = getProdutoById(id);
		produtoExistenteNoBanco.setNome(produto.getNome());
		
		return produtoRepository.save(produtoExistenteNoBanco);
		//return produtoRepository.save(produto);
	}

	public Produto deleteProduto(Integer id) {
		produtoRepository.deleteById(id);
		return getProdutoById(id);
	}

}
	
//	public List<CategoriaDTO> getAllCategoriasDTO(){
//		List<Categoria> listaCategoria = categoriaRepository.findAll();
//		List<CategoriaDTO> listaCategoriaDTO = new ArrayList<>();
//		
//		
//		for(Categoria categoria: listaCategoria) {
//			CategoriaDTO categoriaDTO = toDTO(categoria);
//			List<Produto> listaProdutos = new ArrayList<>();
//			List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();
//				
//			listaProdutos = produtoRepository.findByProduto(categoria);
//			for(Produto produto : listaProdutos) {
//				ProdutoDTO produtoDTO = produtoService.toDTO(produto);
//				listaProdutosDTO.add(produtoDTO);
//			}
//			
//			categoriaDTO.setListaProdutosDTO(listaProdutosDTO);
//			listaCategoriaDTO.add(categoriaDTO);
//		}
//		return listaCategoriaDTO; 
//	}
//	
//}
	
	

	
	
	
/*	
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> getAllProdutos(){
		return produtoRepository.findAll();
	}
	
	public Produto getProdutoById(Integer id) {
		return produtoRepository.findById(id).orElse(null);
	}
	
	public Produto saveProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {
		Produto produto = toEntidade(produtoDTO);
		Produto novoProduto = produtoRepository.save(produto);
		
		ProdutoDTO produtoAtualizadoDTO = toDTO(novoProduto);
		
		return produtoAtualizadoDTO;
	}
	
	public Produto updateProduto(Produto produto, Integer id) {
		Produto produtoExistenteNoBanco = getProdutoById(id);

		produtoExistenteNoBanco.setIdProduto(produto.getIdProduto());
		produtoExistenteNoBanco.setNome(produto.getNome());
		produtoExistenteNoBanco.setDescricao(produto.getDescricao());
		produtoExistenteNoBanco.setQtdEstoque(produto.getQtdEstoque());
		produtoExistenteNoBanco.setDataCadastro(produto.getDataCadastro());
		produtoExistenteNoBanco.setValorUnitario(produto.getValorUnitario());
		produtoExistenteNoBanco.setImagem(produto.getImagem());
//		produtoExistenteNoBanco.setCategoria(produto.getCategoria());
		
		
		return produtoRepository.save(produtoExistenteNoBanco);
	}
	
	public ProdutoDTO updateProdutoDTO(ProdutoDTO produtoDTO, Integer id) {
		Produto produtoExistenteNoBanco = getProdutoById(id);
		ProdutoDTO produtoAtualizadoDTO = new ProdutoDTO();
		
		if(produtoExistenteNoBanco != null) {
			produtoExistenteNoBanco = toEntidade(produtoDTO);
			
			Produto produtoAtualizado = produtoRepository.save(produtoExistenteNoBanco);
			
			produtoAtualizadoDTO = toDTO(produtoAtualizado);
		}
		
		return produtoAtualizadoDTO;
	}
	
	public ProdutoDTO toDTO(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		BeanUtils.copyProperties(produto, produtoDTO);
		return produtoDTO;
	}
	
	public Produto toEntidade(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		BeanUtils.copyProperties(produtoDTO, produto);
		return produto;
	}

	public Produto deleteProduto(Integer id) {
		produtoRepository.deleteById(id);
		return getProdutoById(id);
	}
	*/

/*	
	public List<CategoriaDTO> getAllCategoriasDTO(){
		List<Categoria> listaCategoria = categoriaRepository.findAll();
		List<CategoriaDTO> listaCategoriaDTO = new ArrayList<>();
		
		
		for(Categoria categoria: listaCategoria) {
			CategoriaDTO categoriaDTO = toDTO(categoria);
			List<Produto> listaProdutos = new ArrayList<>();
			List<ProdutoDTO> listaProdutosDTO = new ArrayList<>();
				
			listaProdutos = produtoRepository.findByProduto(categoria);
			for(Produto produto : listaProdutos) {
				ProdutoDTO produtoDTO = produtoService.toDTO(produto);
				listaProdutosDTO.add(produtoDTO);
			}
			
			categoriaDTO.setListaProdutosDTO(listaProdutosDTO);
			listaCategoriaDTO.add(categoriaDTO);
		}
		return listaCategoriaDTO; 
	}

*/

