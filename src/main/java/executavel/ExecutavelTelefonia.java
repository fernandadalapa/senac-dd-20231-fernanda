package executavel;

import java.util.ArrayList;
import java.util.List;

import model.dao.telefonia.EnderecoDAO;
import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {

		List<Telefone> telefonesDoPele = new ArrayList<Telefone>();
		List<Telefone> telefonesDoSocrates = new ArrayList<Telefone>();
		List<Cliente> clientes = new ArrayList<Cliente>();
		
		//ENDEREÇOS
		Endereco end1 = new Endereco(1, "88000123", "10", "Mauro Ramos", "Centro", "Florianópolis", "SC");
		Endereco end2 = new Endereco(2, "88000456", "20", "Lauro Linhares", "Centro", "Florianópolis", "SC");
		EnderecoDAO dbaEnderecos = new EnderecoDAO();	
		Endereco end3 = new Endereco(3, "88000123", "Felipe Schmidt", "9", "Centro", "Florianópolis", "SC");
		
		//adicionando os endereços
		dbaEnderecos.cadastrar(end1);
		dbaEnderecos.atualizar(end2);
		//dbaEnderecos.excluir(end3);
		
		//CLIENTES
		Cliente pele = new Cliente(1, "Edson Arantes", "11122233344", telefonesDoPele, true, end1);
		Cliente socrates = new Cliente(2,"Sócrates Brasileiro", "33322233344", telefonesDoSocrates, true, end2);
		
		//adicionando os clientes
		clientes.add(pele);
		clientes.add(socrates);
		
		//TELEFONES
		Telefone tel1 = new Telefone(1, 1,"48", "32328888", true, false);
		Telefone tel2 = new Telefone(2, 2, "48", "84569119", true, false);
		
		//adicionando os telefones
		telefonesDoPele.add(tel1);
		telefonesDoPele.add(new Telefone(1, 1,"48", "32328888", true, false));
		telefonesDoSocrates.add(tel2);
		telefonesDoSocrates.add(new Telefone(2, 2, "48", "84569119", true, false));
		
		
		
		if(end1.getId() != null) {
			System.out.print("Novo endereço cadastrado");
		}else {
			System.out.print("Erro ao cadastrar endereço");
		}
		
		
		System.out.println("---------- Clientes da firma ----------");
		for(Cliente c : clientes) {
			System.out.println(c.toString());
		}
		
	}
}