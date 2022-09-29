package br.com.med.clinica.administrativo.model;

public class IntegrantesDTO {
	private Long oid;
	private FuncionarioDTO funcionario = new FuncionarioDTO();
	private Long especialidade;

	public IntegrantesDTO() {

	}

	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	public Long getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Long especialidade) {
		this.especialidade = especialidade;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long oid) {
		this.oid = oid;
	}



}

