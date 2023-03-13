package model.dao.telefonia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.Banco;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class EnderecoDAO {

	//INSERT
	//INSET INTO ENDERECO(RUA, CEP, BAIRRO, CIDADE, ESTADO, NUMERO)
	//VALUES ('', '', '', '', '', '');
	
	
	//DOCUMENTAÇÃO DO MÉTODO:
	/**
	 * INSERE UM NOVO ENDERECO NO BANCO
	 * @param novoTelefone O ENDERECO A SER PERSISTIDO
	 * @return O ENDERECO INSERIDO COM A CHAVE PRIMARIA GERADA
	 */
	
	public Endereco cadastrar(Endereco novoEndereco) {
		//CONECTAR AO BANCO
		Connection conexao = Banco.getConnection(); //LINHA PARA ENTRAR NO BANCO
		String sql = " INSET INTO ENDERECO(RUA, CEP, BAIRRO, CIDADE, ESTADO, NUMERO) "
				     + " VALUES (?, ?, ?, ?, ?, ?) ";
		
		PreparedStatement query = Banco.getPreparedStatementWithPk(conexao, sql);
		
		
		//EXECUTAR O INSERT
		try {
			query.setString(1, novoEndereco.getRua());
			query.setString(2, novoEndereco.getCep());
			query.setString(3, novoEndereco.getBairro());
			query.setString(4, novoEndereco.getCidade());
			query.setString(5, novoEndereco.getEstado());
			query.setString(6, novoEndereco.getNumero());
			query.execute();
			
			//PREENCHER O ID GERADO NO BANCO NO OBJETO
			ResultSet resultado = query.getGeneratedKeys(); 
			if(resultado.next()) { //pega cada linha da consulta
				novoEndereco.setId(resultado.getInt(1));
			}
			
			
		} catch (SQLException erro) {
			System.out.println("Erro ao inserir endereço. \nCausa: " + erro.getMessage());
			erro.printStackTrace();
		} finally {
			//FECHAR A CONECXÃO
			Banco.closePreparedStatement(query);
			Banco.closeConnection(conexao);	
		}
		return novoEndereco;
	}
}