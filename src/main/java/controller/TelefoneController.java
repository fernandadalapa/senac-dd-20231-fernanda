package controller;

import java.util.List;

import model.bo.TelefoneBO;
import model.vo.telefonia.Telefone;

public class TelefoneController {

	private TelefoneBO bo = new TelefoneBO();
	
	public Telefone inserir(Telefone novoTelefone) {
		return bo.inserir(novoTelefone);
	}
	
	public boolean atualizar(Telefone telefoneAlterado) {
		return bo.atualizar(telefoneAlterado);
	}
	
	public boolean excluir(int id) {
		return bo.excluir(id);
	}
	
	public Telefone consultarPorId(int id) {
		return bo.consultarPorId(id);
	}
	
	public List<Telefone> consultarTodos() {
		return bo.consultarTodos();
	}
	
}