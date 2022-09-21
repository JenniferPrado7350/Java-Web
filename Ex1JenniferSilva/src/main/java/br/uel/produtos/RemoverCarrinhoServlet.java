package br.uel.produtos;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoverBuscaServlet
 */
@WebServlet("/removerCarrinho")
public class RemoverCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoverCarrinhoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("sequenciaBusca");
		
		int idInt = new Integer(id);
		
		LinkedList<Produto> listaCarrinho = 
				(LinkedList)request.getSession().getAttribute("listaCarrinho");
		
		
		listaCarrinho.remove(idInt);
		
		//request.getSession().setAttribute("listaBuscados", listaBuscados);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("adicionar-carrinho.jsp");
		
		view.forward(request, response);
	}

	

}