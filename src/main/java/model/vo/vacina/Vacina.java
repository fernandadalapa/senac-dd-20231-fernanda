package model.vo.vacina;

import java.time.LocalDate;

public class Vacina {

	private int idVacina;
	private String nomeVacina;
	private String paisOrigem;
	private LocalDate dataInicioPesquisa;
	private String pesquisadorResponsavel;
	private int estagio;
	
	public Vacina(int idVacina, String nomeVacina, String paisOrigem, LocalDate dataInicioPesquisa,
			String pesquisadorResponsavel, int estagio) {
		super();
		this.idVacina = idVacina;
		this.nomeVacina = nomeVacina;
		this.paisOrigem = paisOrigem;
		this.dataInicioPesquisa = dataInicioPesquisa;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
		this.estagio = estagio;
	}

	public Vacina() {
		super();
	}

	public int getIdVacina() {
		return idVacina;
	}

	public void setIdVacina(int idVacina) {
		this.idVacina = idVacina;
	}

	public String getNomeVacina() {
		return nomeVacina;
	}

	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}

	public String getPaisOrigem() {
		return paisOrigem;
	}

	public void setPaisOrigem(String paisOrigem) {
		this.paisOrigem = paisOrigem;
	}

	public LocalDate getDataInicioPesquisa() {
		return dataInicioPesquisa;
	}

	public void setDataInicioPesquisa(LocalDate dataInicioPesquisa) {
		this.dataInicioPesquisa = dataInicioPesquisa;
	}

	public String getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}

	public void setPesquisadorResponsavel(String pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

	public int getEstagio() {
		return estagio;
	}

	public void setEstagio(int estagio) {
		this.estagio = estagio;
	}
	
	
	
	
	
}