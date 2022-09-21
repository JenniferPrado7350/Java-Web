package produtosJ.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import produtosJ.model.Produto;
import produtosJ.model.Carrinho;

@Named
@SessionScoped
public class ProdutosEscolhidosController implements Serializable{
	int i;
	List<Carrinho> listaProdutosEscolhidos;
	
	public List<Carrinho> getListaProdutosEscolhidos() {
		return listaProdutosEscolhidos;
	}

	public void setListaProdutosEscolhidos(List<Carrinho> lista) {
		this.listaProdutosEscolhidos = lista;
	}
	
	public void adicionarEscolhido(Produto produto) {

		Carrinho prodCarr = new Carrinho(produto.getId(),produto.getNome(),produto.getPreco(),produto.getQuantidade(),1);
		
		if (!listaProdutosEscolhidos.contains(prodCarr)) {
			listaProdutosEscolhidos.add(prodCarr);
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto escolhido com sucesso"));
		} else {
			Carrinho c = listaProdutosEscolhidos.get(listaProdutosEscolhidos.indexOf(prodCarr));
			c.setQuantidadeCarrinho(c.getQuantidadeCarrinho()+1);	
			c.setPrecoTotal(c.getQuantidadeCarrinho()*c.getPreco());	
				
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto no Carrinho"));
		}
		
	}
	
	public void remover(Carrinho produto) { 
		
		Carrinho c = listaProdutosEscolhidos.get(listaProdutosEscolhidos.indexOf(produto));
		
		if (c.getQuantidadeCarrinho() > 1) {
			c.setQuantidadeCarrinho(c.getQuantidadeCarrinho()-1);
			c.setPrecoTotal(c.getQuantidadeCarrinho()*c.getPreco());	
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("1 Unidade do Produto Removido do Carrinho"));
		} else {
			listaProdutosEscolhidos.remove(c);		
			
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage("Produto Removido do Carrinho"));
		}
		
	}


	@PostConstruct
	public void init() {
		listaProdutosEscolhidos = 
				new ArrayList<Carrinho>();
	}

}
