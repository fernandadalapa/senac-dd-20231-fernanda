package model.dao.vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.vacina.Vacina;

public class VacinaDAO {

	
	public Vacina cadastrar(Vacina novaVacina) {
		Connection conexao = Banco.getConnection(); //LINHA PARA ENTRAR NO BANCO
		String sql = " INSERT INTO VACINA(IDVACINA, NOMEVACINA, PAISORIGEM, DATAINICIOPESQUISA, PESQUISADORRESPONSAVEL, ESTAGIO) "
				     + " VALUES (?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		
		try {
			query.setInt(1, novaVacina.getIdVacina());
			query.setString(2, novaVacina.getNomeVacina());
			query.setString(3, novaVacina.getPaisOrigem());
			query.setDate(4, java.sql.Date.valueOf(novaVacina.getDataInicioPesquisa())); 
			query.setString(5, novaVacina.getPesquisadorResponsavel());
			query.setInt(6, novaVacina.getEstagio());
			query.execute();
			

			ResultSet resultado = query.getGeneratedKeys(); 
			if(resultado.next()) {
				novaVacina.setIdVacina(resultado.getInt(1));
			}
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar vacina. \nCausa: " + erro.getMessage());
			erro.printStackTrace();
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);	
		}
		return novaVacina;
	}
	
	
	
	public boolean atualizar(Vacina vacinaAtualizada) {
		boolean atualizado = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE VACINA "
				   + " SET NOMEVACINA = ?, PAISORIGEEM = ?, "
				   + " DATAINICIOPESQUISA = ?, PESQUISADORRESPONSAVEL = ?, ESTAGIO = ? "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, vacinaAtualizada.getNomeVacina());
			query.setString(2, vacinaAtualizada.getPaisOrigem());
			query.setDate(3, java.sql.Date.valueOf(vacinaAtualizada.getDataInicioPesquisa()));
			query.setString(4, vacinaAtualizada.getPesquisadorResponsavel());
			query.setInt(5, vacinaAtualizada.getEstagio());
			query.setInt(6, vacinaAtualizada.getIdVacina());
			
			int linhasAtualizadas = query.executeUpdate();
			atualizado = linhasAtualizadas > 0;
			
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar vacina. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return atualizado;
	}
	
	
	public Vacina consultarPorId(int id) {
		Vacina vacinaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM VACINA "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				vacinaConsultada = new Vacina();
				vacinaConsultada.setIdVacina(resultado.getInt("idvacina"));
				vacinaConsultada.setNomeVacina(resultado.getString("idcliente"));
				vacinaConsultada.setPaisOrigem(resultado.getString("paisorigem"));
				vacinaConsultada.setPesquisadorResponsavel(resultado.getString("pesquisadorresposnsavel"));
				vacinaConsultada.setEstagio(resultado.getInt("estagio"));
				
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao buscar vacina com o id: " + id 
								+ "\nCausa: " + erro.getMessage());	
		}
		return vacinaConsultada;
	}
	
	
	public boolean excluir(int id) {
		boolean excluir = false;
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM VACINA "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			int linhasAtualizadas = query.executeUpdate();
			excluir = linhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir vacina. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluir;
	}
	
	
}