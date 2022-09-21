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
@WebServlet("/buscar")
public class BuscarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nomeProduto = request.getParameter("nomeProduto");
		

		HttpSession session = request.getSession();
		
		Object listaBuscasObj = session.getAttribute("listaBuscados");
		
		if (listaBuscasObj == null){
			LinkedList<String> listaBuscas = 
					new LinkedList<String>();
			
			listaBuscas.add(nomeProduto);
			
			session.setAttribute("listaBuscados", listaBuscas);
			
		} else {
			
			LinkedList<String> listaBuscas = 
					(LinkedList)listaBuscasObj;
			
			listaBuscas.add(nomeProduto);
			
		}
		
		ProdutoDAO produtoDAO = 
				new ProdutoDAO();
		
		List<Produto> listaProdutos = 
				produtoDAO.buscarPorNome(nomeProduto);
		
		request.setAttribute("listaProdutos", listaProdutos);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("buscar-resposta.jsp");
		
		view.forward(request, response);
		
		
	}

}
