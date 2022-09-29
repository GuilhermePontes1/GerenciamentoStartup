package br.com.med.clinica.administrativo.model;

public class IntegrantesMapper {

	public static IntegrantesDTO toDTO(IntegrantesDTO integrantes ) {
		IntegrantesDTO dto = new IntegrantesDTO();
		dto.setOid(integrantes.getOid());
		dto.setFuncionario(FuncionarioMapper.toDTO(Integrantes.getFuncionario()));

		if(integrantes.getEspecialidade() != null) {
			dto.setEspecialidade(integrantes.getEspecialidade());
	}
		return dto;
	}
	
	public static Integrantes toEntity(IntegrantesDTO dto) {

		Integrantes entity = new Integrantes();
		
		entity.setOid(dto.getOid());

		if(dto.getEspecialidade() != null) {
			Especialidade especialidade = new Especialidade();
			especialidade.setOid(dto.getEspecialidade());
			entity.setEspecialidade(especialidade);
		}else {
			entity.setEspecialidade(null);
		}
		
		entity.setFuncionario(FuncionarioMapper.toEntity(dto.getFuncionario()));

		return entity;
	}

	

	
	
}
