package produtosJ.model;

import java.util.Objects;

//esta classe implementa o transfer object od design pattern DAO
public class Carrinho extends Produto{
	
	private Integer quantidadeCarrinho;
	private Double precoTotal;
	
	public Carrinho(Long id, String nome, Double preco, Integer quantidade, Integer quantidadeCarrinho) {
		super(id, nome, preco, quantidade);
		this.quantidadeCarrinho = quantidadeCarrinho;
		this.precoTotal = quantidadeCarrinho*preco;
	}

	public Integer getQuantidadeCarrinho() {
		return quantidadeCarrinho;
	}

	public void setQuantidadeCarrinho(Integer quantidadeCarrinho) {
		this.quantidadeCarrinho = quantidadeCarrinho;
	}
	
	public Double getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(Double precoTotal) {
		this.precoTotal = precoTotal;
	}


}