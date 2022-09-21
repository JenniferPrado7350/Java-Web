package br.uel.produtos;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EfetuarAlteracaoServlet
 */
@WebServlet("/efetuarAlteracao")
public class EfetuarAlteracaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EfetuarAlteracaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome = request.getParameter("nome");
		Double preco = Double.parseDouble(request.getParameter("preco"));
		int quantidade = Integer.parseInt(request.getParameter("quantidade"));
		Long id = Long.parseLong(request.getParameter("id"));
		
		try {
			
			Produto produto = new Produto();
			
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.setQuantidade(quantidade);
			produto.setId(id);
			
			ProdutoDAO produtoDao = 
					new ProdutoDAO();
			
			produtoDao.alterar(produto);
			
			RequestDispatcher view = 
					request.getRequestDispatcher("alterar-resposta.jsp");
			
			view.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
