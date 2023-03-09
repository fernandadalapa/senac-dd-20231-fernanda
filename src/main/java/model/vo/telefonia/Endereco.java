package model.vo.telefonia;

public class Endereco {

	private Integer id;
	private String cep;
	private String numero;
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	
	public Endereco(Integer id, String cep, String numero, String rua, String bairro, String cidade, String estado) {
		super();
		this.id = id;
		this.cep = cep;
		this.numero = numero;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco "
				+ "\n id: " + id 
				+ "\n cep: " + cep 
				+ "\n numero: " + numero 
				+ "\n rua: " + rua 
				+ "\n bairro: " + bairro
				+ "\n cidade: " + cidade 
				+ "\n estado: " + estado;
	}
}