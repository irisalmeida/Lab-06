package sapo;

public class Pessoa {
	
	private String cpf;
	private String nome;
	private String[] habilidades;

	/**
	 * Construtor padrão de Pessoaa.
	 * 
	 * @param atributos de Pessoa.
	 */
	public Pessoa(String cpf, String nome, String[] habilidades){
	this.cpf = cpf;
    this.nome = nome;
	this.habilidades = habilidades;
	}
	
	
	/**
	 * Get e Set dos atributos de Pessoa.
	 */
	public String getCpf() {
        return this.cpf;
    }
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String[] getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String[] habilidades) {
		this.habilidades = habilidades;
	}



	/**
	 * hashCode e equals do CPF.
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Pessoa))
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
	/**
	 * Método que retorna a representação textual de pessoa, tendo como parâmetro seu CPF
	 */
	public String exibirPessoa(String cpf) {
		return "CPF = " + getCpf();
	}
}
