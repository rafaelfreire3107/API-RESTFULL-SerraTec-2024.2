package br.com.serratec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.entity.Medico;
import br.com.serratec.repository.MedicoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

	@Autowired
	private MedicoRepository repository;

	@GetMapping
	public List<Medico> listar() {
		return repository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Medico inserir(@Valid @RequestBody Medico m) {
		return repository.save(m);
	}

	@PostMapping("/varios")
	@ResponseStatus(HttpStatus.CREATED)
	public List<Medico> inserirVarios(@RequestBody List<Medico> medicos) {
		return repository.saveAll(medicos);
	}
	
}