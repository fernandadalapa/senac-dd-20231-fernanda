package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class TelefoneDAO {

	//INSERT
		//INSET INTO TELEFONE(ID, IDCLIENTE, DDD, NUMERO, ATIVO, MOVEL)
		//VALUES ('', '', '', '', '', '');
		
		
		//DOCUMENTAÇÃO DO MÉTODO:
		/**
		 * INSERE UM NOVO TELEFONE NO BANCO
		 * @param novoTelefone O TELEFONE A SER PERSISTIDO
		 * @return O TELEFONE INSERIDO COM A CHAVE PRIMARIA GERADA
		 */
		
		public Telefone cadastrar(Telefone novoTelefone) {
			//CONECTAR AO BANCO
			Connection conexao = Banco.getConnection(); //LINHA PARA ENTRAR NO BANCO
			String sql = " INSET INTO TELEFONE(ID, IDCLIENTE, DDD, NUMERO, ATIVO, MOVEL) "
					     + " VALUES (?, ?, ?, ?, ?, ?) ";
			
			PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
			
			
			//EXECUTAR O INSERT
			try {
				query.setInt(1, novoTelefone.getId());
				query.setInt(2, novoTelefone.getIdCliente());
				if(novoTelefone != null) {
					query.setInt(2, novoTelefone.getIdCliente());
				} else {
					query.setInt(2, 0);
				}
				query.setString(3, novoTelefone.getDdd());
				query.setString(4, novoTelefone.getNumero());
				query.setBoolean(5, novoTelefone.isAtivo());
				query.setBoolean(6, novoTelefone.isMovel());
				query.execute();
				
				//PREENCHER O ID GERADO NO BANCO NO OBJETO
				ResultSet resultado = query.getGeneratedKeys(); 
				if(resultado.next()) { //pega cada linha da consulta
					novoTelefone.setId(resultado.getInt(1));
				}
				
				
			} catch (SQLException erro) {
				System.out.println("Erro ao inserir telefone. \nCausa: " + erro.getMessage());
				erro.printStackTrace();
			} finally {
				//FECHAR A CONECXÃO
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conexao);	
			}
			return novoTelefone;
		}
		
		
		
		
		public boolean atualizar(Telefone telefoneAtualizado) {
			boolean atualizado = false;
			Connection conexao = Banco.getConnection();
			String sql = " UPDATE TELEFONE "
					   + " SET DDD = ?, NUMERO = ?, "
					   + " ATIVO = ?, MOVEL = ? "
					   + " WHERE ID = ? ";
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			try {
				query.setString(1, telefoneAtualizado.getDdd());
				query.setString(2, telefoneAtualizado.getNumero());
				query.setBoolean(3, telefoneAtualizado.isAtivo());
				query.setBoolean(4, telefoneAtualizado.isMovel());
				query.setInt(5, telefoneAtualizado.getId());
				
				int quantidadeLinhasAtualizadas = query.executeUpdate();
				atualizado = quantidadeLinhasAtualizadas > 0;
				
			} catch (SQLException excecao) {
				System.out.println("Erro ao atualizar telefone. "
						+ "\n Causa: " + excecao.getMessage());
			}finally {
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conexao);
			}
			return atualizado;
		}
		
		
		
		
		public Telefone consultarPorId(int id) {
			Telefone telefoneConsultado = null;
			Connection conexao = Banco.getConnection();
			String sql =  " SELECT * FROM TELEFONE "
					    + " WHERE ID = ?";
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			
			try {
				query.setInt(1, id);
				ResultSet resultado = query.executeQuery();
				
				if(resultado.next()) {
					telefoneConsultado = new Telefone();
					telefoneConsultado.setId(resultado.getInt("id"));
					telefoneConsultado.setIdCliente(resultado.getInt("idcliente"));
					telefoneConsultado.setDdd(resultado.getString("ddd"));
					telefoneConsultado.setNumero(resultado.getString("numero"));
					telefoneConsultado.setAtivo(resultado.getBoolean("ativo"));
					telefoneConsultado.setMovel(resultado.getBoolean("movel"));
				}
			} catch (SQLException erro) {
				System.out.println("Erro ao buscar telefone com id: " + id 
									+ "\nCausa: " + erro.getMessage());	
			}
			return telefoneConsultado;
		}
		
		
		
		
		public boolean excluir(int id) {
			boolean excluir = false;
			Connection conexao = Banco.getConnection();
			String sql = " DELETE FROM TELEFONE "
					   + " WHERE ID = ? ";
			PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
			try {
				query.setInt(1, id);
				int quantidadeLinhasAtualizadas = query.executeUpdate();
				excluir = quantidadeLinhasAtualizadas > 0;
			} catch (SQLException excecao) {
				System.out.println("Erro ao excluir telefone. "
						+ "\n Causa: " + excecao.getMessage());
			}finally {
				Banco.closePreparedStatement(query);
				Banco.closeConnection(conexao);
			}
			return excluir;
		}
		
}