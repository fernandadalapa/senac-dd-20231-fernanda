package model.dao.vacina;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.vacina.Pessoa;

public class PessoaDAO {

	
	public Pessoa cadastrar(Pessoa novaPessoa) {
		//CONECTAR AO BANCO
		Connection conexao = Banco.getConnection(); //LINHA PARA ENTRAR NO BANCO
		String sql = " INSERT INTO PESSOA(ID, NOME, DATANASCIMENTO, SEXO, CPF, TIPOPESSOA) "
				     + " VALUES (?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		
		//EXECUTAR O INSERT
		try {
			query.setInt(1, novaPessoa.getIdPessoa());
			query.setString(2, novaPessoa.getNome());
			query.setDate(3, java.sql.Date.valueOf(novaPessoa.getDataNascimento())); 
			query.setString(4, novaPessoa.getSexo());
			query.setString(5, novaPessoa.getCpf());
			query.setInt(6, novaPessoa.getTipoPessoa());
			query.execute();
			
			//PREENCHER O ID GERADO NO BANCO NO OBJETO
			ResultSet resultado = query.getGeneratedKeys(); 
			if(resultado.next()) { //pega cada linha da consulta
				novaPessoa.setIdPessoa(resultado.getInt(1));
			}
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar pessoa. \nCausa: " + erro.getMessage());
			erro.printStackTrace();
		} finally {
			Banco.closePreparedStatement(query); //PREPARED STATEMENT PEGA DIRETAMENTE CADA UM DOS VALORES;
			Banco.closeConnection(conexao);	
		}
		return novaPessoa;
	}
	
	
	public boolean atualizar(Pessoa pessoaAtualizada) {
		boolean atualizada = false;
		Connection conexao = Banco.getConnection();
		String sql = " UPDATE PESSOA "
				   + " SET NOME = ?, DATANASCIMENTO = ?, "
				   + " SEXO = ?, CPF = ? "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setString(1, pessoaAtualizada.getNome());
			query.setDate(2, java.sql.Date.valueOf(pessoaAtualizada.getDataNascimento()));
			query.setString(3, pessoaAtualizada.getSexo());
			query.setString(4, pessoaAtualizada.getCpf());
			query.setInt(5, pessoaAtualizada.getIdPessoa());
			
			int linhasAtualizadas = query.executeUpdate();
			atualizada = linhasAtualizadas > 0;
			
		} catch (SQLException excecao) {
			System.out.println("Erro ao atualizar pessoa. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return atualizada;
	}
	
	public Pessoa consultarPorId(int id) {
		Pessoa pessoaConsultada = null;
		Connection conexao = Banco.getConnection();
		String sql =  " SELECT * FROM PESSOA "
				    + " WHERE ID = ?";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		
		try {
			query.setInt(1, id);
			ResultSet resultado = query.executeQuery();
			
			if(resultado.next()) {
				pessoaConsultada = new Pessoa();
				pessoaConsultada.setIdPessoa(resultado.getInt("idpessoa"));
				pessoaConsultada.setNome(resultado.getString("nome"));
				pessoaConsultada.setDataNascimento(resultado.getDate("datanascimento").toLocalDate());//toLocalDate >> para converter
				pessoaConsultada.setSexo(resultado.getString("sexo"));
				pessoaConsultada.setCpf(resultado.getString("cpf"));
				pessoaConsultada.setTipoPessoa(resultado.getInt("tipopessoa"));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao buscar pessoa com o id: " + id 
								+ "\nCausa: " + erro.getMessage());	
		} finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return pessoaConsultada;
	}
	
	public boolean excluir(int id) {
		boolean excluir = false;
		Connection conexao = Banco.getConnection();
		String sql = " DELETE FROM PESSOA "
				   + " WHERE ID = ? ";
		PreparedStatement query = Banco.getPreparedStatement(conexao, sql);
		try {
			query.setInt(1, id);
			int linhasAtualizadas = query.executeUpdate();
			excluir = linhasAtualizadas > 0;
		} catch (SQLException excecao) {
			System.out.println("Erro ao excluir pessoa. "
					+ "\n Causa: " + excecao.getMessage());
		}finally {
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);
		}
		return excluir;
	}
	
	
}