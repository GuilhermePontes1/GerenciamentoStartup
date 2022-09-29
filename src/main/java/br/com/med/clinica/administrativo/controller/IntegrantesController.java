package br.com.med.clinica.administrativo.controller;

import br.com.med.clinica.administrativo.model.*;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import br.com.med.clinica.administrativo.repository.EspecialidadeRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import br.com.med.clinica.administrativo.repository.IntegrantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class IntegrantesController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private IntegrantesRepository integrantesRepository;

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping("/integrantes")
	public String listMedico(Model model) {
		List<Integrantes> integrantes = integrantesRepository.findAll();
		model.addAttribute("integrantes", integrantes);
		return "/administrativo/integrantes";
	}

	@GetMapping("/integrantes/form")
	public String form(Model model, @Param(value = "id") Long id) {
		IntegrantesDTO integrantesDTO = new IntegrantesDTO();
		if (id != null) {
			Optional<Integrantes> op = integrantesRepository.findById(id);
			if (op.isPresent()) {
				Integrantes integrantes = op.get();
				integrantesDTO = IntegrantesMapper.toDTO(integrantesDTO);
				
			}
		}
	
		List<Especialidade> especialidades = especialidadeRepository.findAll();
		model.addAttribute("especialidades", especialidades);
		model.addAttribute("integrantesDTO", integrantesDTO);

		return "/administrativo/integrantesform";

	}

	@GetMapping("/integrantes/form/update")
	public String formUpdate(Model model, Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id).get();
		Endereco endereco = enderecoRepository.findById(funcionarioRepository.findById(id).get().getEndereco().getOid())
				.get();
		Integrantes integrantes = integrantesRepository.findById(id).get();

		model.addAttribute("entity", new IntegrantesDTO());
		return "/administrativo/integrantesupdate";
	}

	@PostMapping("/funcionario/integrantes/update")
	public String update( IntegrantesDTO entity, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "integrantesupdate";
		}

		return "redirect:/integrantes";
	}

	@PostMapping("/integrantes/salvar")
	public String salvar(IntegrantesDTO integrantesDTO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/administrativo/integrantesform";
		}
		Integrantes integrantes = IntegrantesMapper.toEntity(integrantesDTO);
		integrantesRepository.save(integrantes);
		return "redirect:/integrantes";
	}

	@GetMapping("/integrantes/delete")
	public String delete(Long id) {
		integrantesRepository.deleteById(id);
		return "redirect:/integrantes";
	}

}
