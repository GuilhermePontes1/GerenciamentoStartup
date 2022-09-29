package br.com.med.clinica.administrativo.model;

import javax.persistence.*;


@Table(name = "tb_integrantes")
@Entity
public class Integrantes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long oid;

	@OneToOne
	@MapsId
	private static Funcionario funcionario;

	@ManyToOne
	@JoinColumn(name = "especialidade_oid")
	private Especialidade especialidade;

	public Integrantes() {
		super();
	}

	public Integrantes(Long oid, Especialidade especialidade) {
		this.oid = oid;
		this.especialidade = especialidade;
	}

	public Integrantes(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}

	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Integrantes))
			return false;

		Integrantes medico = (Integrantes) o;

		return getOid().equals(medico.getOid());
	}

	@Override
	public int hashCode() {
		return getOid().hashCode();
	}

}

