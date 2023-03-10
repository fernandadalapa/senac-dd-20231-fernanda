package executavel;

import java.util.ArrayList;
import java.util.List;

import model.vo.telefonia.Cliente;
import model.vo.telefonia.Endereco;
import model.vo.telefonia.Telefone;

public class ExecutavelTelefonia {

	public static void main(String[] args) {

		List<telefonesDoPele> telefonesDoPele = new ArrayList<Telefone>();
		List<telefonesDoSocrates> telefonesDoSocrates = new ArrayList<Telefone>();
		
		Cliente pele = new Cliente("Edson Arantes", "11122233344", telefonesDoPele, true, end1);
		Cliente socrates = new Cliente("Sócrates Brasileiro", "33322233344", telefonesDoSocrates, true, end2);
		
		
		
		
		
		
		
		Endereco end1 = new Endereco(1, "88000123", "10", "Mauro Ramos", "Centro", "Florianópolis", "SC");
		Endereco end2 = new Endereco(2, "88000456", "20", "Lauro Linhares", "Centro", "Florianópolis", "SC");
		
		
		EnderecoDAO salvadorEnderecos = new EnderecoDAo();
		salvadorEnderecos.inserir(end1);
		
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