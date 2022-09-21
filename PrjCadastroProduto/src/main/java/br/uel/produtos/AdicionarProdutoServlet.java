package br.uel.produtos;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionarContatoServlet
 */
@WebServlet("/adicionar")
public class AdicionarProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarProdutoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		Double preco =  Double.parseDouble(request.getParameter("preco"));
		int quantidade =  Integer.parseInt(request.getParameter("quantidade"));

		try {
			
			Produto produto = new Produto();
			
			produto.setNome(nome);
			produto.setPreco(preco);
			produto.setQuantidade(quantidade);

			
			ProdutoDAO produtoDao = new ProdutoDAO();
			
			produtoDao.inserir(produto);
			
			RequestDispatcher view = 
					request.getRequestDispatcher("adicionar-resposta.jsp");
			
			view.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		System.out.println("depois do forward");

	}

}
