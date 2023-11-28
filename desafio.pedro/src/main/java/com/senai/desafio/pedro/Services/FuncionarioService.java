package com.senai.desafio.pedro.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.senai.desafio.pedro.Repositories.FuncionarioRepository;
import com.senai.desafio.pedro.entities.Funcionarios;


public class FuncionarioService {
	

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public List<Funcionarios> getAllFuncionarios() {
		return funcionarioRepository.findAll();
	}

	public Funcionarios getFuncionarioById(long funcodigo) {
		return funcionarioRepository.findById(funcodigo).orElse(null);
	}

	public Funcionarios saveFuncionario(Funcionarios funcionarios) {
		return funcionarioRepository.save(funcionarios);
	}

	public List<Funcionarios> getFuncionariosByFunnomeAproximado(String funnome) {
        return funcionarioRepository.findByNomeContaining(funnome);
    }

	public boolean deleteFuncionarios(Long id) {
		Optional<Funcionarios> funcionariosExistente = funcionarioRepository.findById(id);
		if (funcionariosExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Funcionarios updateFuncionarios(Long funcodigo, Funcionarios novoFuncionarios) {
		Optional<Funcionarios> funcionariosOptional = funcionarioRepository.findById(funcodigo);
		if (funcionariosOptional.isPresent()) {
			Funcionarios funcionariosExistente = funcionariosOptional.get();
			funcionariosExistente.setFunnome(novoFuncionarios.getFunnome());
			funcionariosExistente.setFunnascimento(novoFuncionarios.getFunnascimento());
			funcionariosExistente.setFunsalario(novoFuncionarios.getFunsalario());

			// Atualize o departamento
			if (novoFuncionarios.getDepartamento() != null) {
				funcionariosExistente.setDepartamento(novoFuncionarios.getDepartamento());
			}		
			return funcionarioRepository.save(funcionariosExistente);
		} else {
			return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
		}
	}}