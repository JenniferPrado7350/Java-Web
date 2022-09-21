package br.uel.produtos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uel.produtos.Produto;



//DAO para acessar tabela Produto
/**
 * @author jenni
 *
 */
/**
 * @author jenni
 *
 */
public class ProdutoDAO {
	
	private Connection connection;
	
	public ProdutoDAO(){
		
		this.connection = new ConnectionFactory().getConnection();
		
	}
	
	public void inserir(Produto produto){
		
		String sql = 
				"INSERT INTO produto (NOME, PRECO, QUANTIDADE) VALUES (?,?,?)";
		
		//utilize sempre prepared statement pois ele é mais rápido que statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, produto.getNome());
			prstate.setDouble(2, produto.getPreco());
			prstate.setInt(3, produto.getQuantidade());
			
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
				
		
	}
	
	public void excluir(Long id){
		
		String sql = 
				"DELETE FROM produto WHERE ID=?";
		
		//utilize sempre prepared statement pois ele é mais rápido que statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setLong(1, id);
			
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
				
		
	}
	
	public void alterar(Produto produto){
		
		String sql = 
				"UPDATE produto SET NOME=?, PRECO=?, QUANTIDADE=? WHERE ID=?";
		
		//utilize sempre prepared statement pois ele é mais rápido que statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, produto.getNome());
			prstate.setString(2, Double.toString(produto.getPreco()));
			prstate.setString(3, Integer.toString(produto.getQuantidade()));
			prstate.setLong(4, produto.getId());
			
			prstate.execute();
			
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
				
		
	}
	
	public List<Produto> buscarPorNome(String nome){
		
		String sql = 
				"SELECT * FROM produto WHERE NOME LIKE UPPER(?)";
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		//utilize sempre prepared statement pois ele é mais rápido que statement -> consulta parametrizada
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setString(1, new String("%"+nome+"%").toUpperCase());
					
			ResultSet resultado = 
					prstate.executeQuery();
			
			while (resultado.next()){
				Produto produto = new Produto();
				produto.setId(resultado.getLong("ID"));
				produto.setNome(resultado.getString("NOME"));
				produto.setPreco(Double.parseDouble(resultado.getString("PRECO")));
				produto.setQuantidade(Integer.parseInt(resultado.getString("QUANTIDADE")));

				produtos.add(produto);
			}
			resultado.close();
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
		
		return produtos;
		
	}

	public Produto buscarPorId(Long id){
		
		String sql = 
				"SELECT * FROM produto WHERE ID = ?";
		
		//utilize sempre prepared statement pois ele � mais r�pido que statement -> consulta parametrizada
		
		Produto produto = new Produto();
		
		try {
			PreparedStatement prstate = connection.prepareStatement(sql);
			
			prstate.setLong(1, id);
					
			ResultSet resultado = 
					prstate.executeQuery();
			
			resultado.next();
			
			
			produto.setId(resultado.getLong("ID"));
			produto.setNome(resultado.getString("NOME"));
			produto.setPreco(Double.parseDouble(resultado.getString("PRECO")));
			produto.setQuantidade(Integer.parseInt(resultado.getString("QUANTIDADE")));
			
			resultado.close();
			prstate.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException(e);
			}
		}
		
		return produto;
		
	}

}
