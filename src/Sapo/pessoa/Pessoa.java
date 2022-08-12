package Sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

public class Pessoa {

	private String cpf;
	private String nome;
	private String[] habilidades;
	private ArrayList<Comentario> comentarios;

	// O nome e o CPF não podem ser strings vazias durante o cadastro

	/**
	 * Construtor padrão de Pessoaa.
	 * 
	 * @param atributos de Pessoa.
	 */
	public Pessoa(String cpf, String nome, String[] habilidades) {
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

	// tentativa do array de habilidades ordenado em ordem alfabética
	public String[] getHabilidadesOrdenado() {
		Arrays.sort(habilidades);
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

	// recuperar os comentários sobre uma pessoa na ordem que foram inseridas
	public String listarComentarios() {
		String resultado = "";
		for (Comentario c : comentarios) {
			resultado += c.getAutorCpf() + c.getComentario();
		}
		return resultado;
	}

	// ToString para gerar a representação textual
	// Ordenar habilidades em ordem alf

	// ToString
	@Override
	public String toString() {
		return getNome() + getCpf() + getHabilidadesOrdenado();
	}

	/**
	 * O método adicionarComentario será usado por o método de
	 * adicionarComentarioPessoa no controller.
	 */
	public void adicionarComentario(String comentario, String autorCpf) {
		comentarios.add(new Comentario(comentario, autorCpf));
	}
}
