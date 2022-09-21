package br.uel.produtos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BuscarContatoServlet
 */
@WebServlet("/carrinho")
public class AdicionarCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarCarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ProdutoDAO produtoDAO = 
				new ProdutoDAO();
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		Produto produto = 
				produtoDAO.buscarPorId(id);
		
		HttpSession session = request.getSession();
		
		Object listaCarrinhoObj = session.getAttribute("listaCarrinho");
		
		if (listaCarrinhoObj == null){
			LinkedList<Produto> listaProdCarrinho = 
					new LinkedList<Produto>();
			
			listaProdCarrinho.add(produto);
			
			session.setAttribute("listaCarrinho", listaProdCarrinho);
			
		} else {
			
			LinkedList<Produto> listaProdCarrinho = 
					(LinkedList)listaCarrinhoObj;
			
			listaProdCarrinho.add(produto);
			
		}
		
		RequestDispatcher view = 
				request.getRequestDispatcher("adicionar-carrinho.jsp");
		
		view.forward(request, response);
		
		
	}

}
