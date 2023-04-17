package executavel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.dao.telefonia.EnderecoDAO;
import model.dao.vacina.PessoaDAO;
import model.dao.vacina.VacinaDAO;
import model.vo.telefonia.Cliente;
import model.vo.vacina.Pessoa;
import model.vo.vacina.Vacina;

public class ExecutavelVacina {

	public static void main(String[] args) {

		//VACINAS
		Vacina vacina1 = new Vacina(1, "Varíola", "EUA", LocalDate.of(1796, 5, 21), "Emanuel", 3);
		Vacina vacina2 = new Vacina(2, "Febre Amarela", "Indonésia", LocalDate.of(1927, 5, 21), "Alan", 2);
		VacinaDAO dbaVacinas = new VacinaDAO();
		
		//ADICIONANDO AS VACINAS
		dbaVacinas.cadastrar(vacina1);
		dbaVacinas.atualizar(vacina2);
	
		
		//PESSOAS
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		Pessoa valeria = new Pessoa(1, "Valéria", LocalDate.of(1990, 6, 10), "F", "123657894-10", 2);
		Pessoa daniel = new Pessoa(2, "Daniel", LocalDate.of(2000, 3, 4), "F", "6549832917-27", 3);
		
		//ADICIONANDO AS PESSOAS
		pessoas.add(valeria);
		pessoas.add(daniel);
		
		
	}
}