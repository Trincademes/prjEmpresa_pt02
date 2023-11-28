package com.senai.desafio.pedro.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.senai.desafio.pedro.Services.FuncionarioService;
import com.senai.desafio.pedro.entities.Funcionarios;


public class FuncionarioController {
private final FuncionarioService funcionarioService;
	
	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Funcionarios> findFuncionariobyId(@PathVariable Long id) {
		Funcionarios funcionarios = funcionarioService.getFuncionarioById(id);
		if (funcionarios != null) {
			return ResponseEntity.ok(funcionarios);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/nome/{funnome}")
	public ResponseEntity<List<Funcionarios>> findFuncionariosByNomeAproximado(@PathVariable String funnome) {
	    List<Funcionarios> funcionarios = funcionarioService.getFuncionariosByFunnomeAproximado(funnome);
	    if (!funcionarios.isEmpty()) {
	        return ResponseEntity.ok(funcionarios);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	

	@GetMapping("/")
	public ResponseEntity<List<Funcionarios>> findAllUsuarioscontrol() {
		List<Funcionarios> funcionarios = funcionarioService.getAllFuncionarios();
		return ResponseEntity.ok(funcionarios);
	}

	@PostMapping("/")
	public ResponseEntity<Funcionarios> insertUsuariosControl(@RequestBody Funcionarios funcionarios) {
		Funcionarios novofuncionarios = funcionarioService.saveFuncionario(funcionarios);
		return ResponseEntity.status(HttpStatus.CREATED).body(novofuncionarios);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Funcionarios> updateFuncionarios(@PathVariable Long funcodigo, @RequestBody Funcionarios funcionarios) {
        Funcionarios funcionariosAtualizado = funcionarioService.updateFuncionarios(funcodigo, funcionarios);
        if (funcionariosAtualizado != null) {
            return ResponseEntity.ok(funcionariosAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/id")
	public ResponseEntity<String> deleteUsuarioControl(@PathVariable Long funcodigo) {
		boolean remover = funcionarioService.deleteFuncionarios(funcodigo);
		if (remover) {
			return ResponseEntity.ok().body("usuario Excluido com sucesso");
		} else {
			return ResponseEntity.notFound().build();
		}
	}}