package br.com.med.clinica.administrativo.model;

import javax.persistence.*;

@Entity
@Table(name = "especialidade")
public class Especialidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String nome;

	public Especialidade(Long oid, String nome) {
		super();
		this.oid = oid;
		this.nome = nome;
	}

	public Especialidade() {
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: ");
		builder.append(oid);
		builder.append(" | Nome: ");
		builder.append(nome);
		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Especialidade))
			return false;

		Especialidade that = (Especialidade) o;

		return getOid().equals(that.getOid());
	}

	@Override
	public int hashCode() {
		return getOid().hashCode();
	}
}

