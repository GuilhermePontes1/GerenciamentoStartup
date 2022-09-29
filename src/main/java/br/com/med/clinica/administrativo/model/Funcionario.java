package br.com.med.clinica.administrativo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;
	private String nome;
	private String rg;
	private String orgao;
	private String cpf;
	private String telefone;
	private String celular;

	public Funcionario() {

	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_oid")
	private Endereco endereco;

	@OneToOne(mappedBy = "funcionario", cascade = CascadeType.REMOVE)
	private Usuario usuario;

	@ManyToOne
	@JoinColumn(name = "integrantes_oid")
	private Integrantes integrantes;


	public Funcionario(Long oid, String nome, String rg, String orgao, String cpf, String telefone, String celular) {
		super();
		this.oid = oid;
		this.nome = nome;
		this.rg = rg;
		this.orgao = orgao;
		this.cpf = cpf;
		this.telefone = telefone;
		this.celular = celular;
	}

	public Integrantes getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(Integrantes Integrantes) {
		this.integrantes = integrantes;
	}

	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgao() {
		return orgao;
	}


	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ID: ");
		builder.append(oid);
		builder.append(" | Nome: ");
		builder.append(nome);
		builder.append(" |  RG: ");
		builder.append(rg);
		builder.append(" | Orgão: ");
		builder.append(orgao);
		builder.append(" | CPF: ");
		builder.append(cpf);
		builder.append(" | Telefone: ");
		builder.append(telefone);
		builder.append(" | Celular: ");
		builder.append(celular);

		return builder.toString();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Funcionario))
			return false;
		Funcionario that = (Funcionario) o;
		return getOid().equals(that.getOid());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getOid());
	}

}
