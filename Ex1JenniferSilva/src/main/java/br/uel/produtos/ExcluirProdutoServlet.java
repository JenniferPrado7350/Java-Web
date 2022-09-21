package br.uel.produtos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ExcluirContatoServlet
 */
@WebServlet("/excluir")
public class ExcluirProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProdutoDAO produtoDao = 
				new ProdutoDAO();
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		produtoDao.excluir(id);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("excluir-produto.jsp");
		
		view.forward(request, response);
		
		
	}

}
