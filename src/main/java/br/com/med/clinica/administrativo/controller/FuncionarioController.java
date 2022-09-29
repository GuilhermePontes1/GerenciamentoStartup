package br.com.med.clinica.administrativo.controller;

import br.com.med.clinica.administrativo.model.Funcionario;
import br.com.med.clinica.administrativo.model.FuncionarioDTO;
import br.com.med.clinica.administrativo.model.FuncionarioMapper;
import br.com.med.clinica.administrativo.repository.EnderecoRepository;
import br.com.med.clinica.administrativo.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class FuncionarioController {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/funcionario")
	public String listFuncionario(Model model, HttpServletRequest req) {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		model.addAttribute("funcionarios", funcionarios);
		req.getSession().setAttribute("funcionarios", funcionarios);
		return "/administrativo/funcionariolist";

	}

	@GetMapping("/funcionario/form")
	public String form(Model model, Long id) {

		FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
		
		if(id != null) {
			Optional<Funcionario> op = funcionarioRepository.findById(id);
			if(op.isPresent()) {
				Funcionario funcionario = op.get();
				funcionarioDTO = FuncionarioMapper.toDTO(funcionario);
			}
		}		
		model.addAttribute("funcionarioDTO", funcionarioDTO);
		return "/administrativo/funcionarioform";
	}


	@PostMapping("/funcionario/salvar")
	public String salvar(FuncionarioDTO funcionarioDTO, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "/administrativo/funcionarioform";
		}
		Funcionario funcionario = FuncionarioMapper.toEntity(funcionarioDTO);
		funcionarioRepository.save(funcionario);

		return "redirect:/funcionario";

	}

	@GetMapping("/funcionario/delete")
	public String delete(Long id) {
		funcionarioRepository.deleteById(id);
		return "redirect:/funcionario";
	}

}
