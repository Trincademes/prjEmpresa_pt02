package com.senai.desafio.pedro.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.senai.desafio.pedro.Repositories.DepartamentoRepository;
import com.senai.desafio.pedro.entities.Departamento;

public class DepartamentoService {
	private final DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
	}

	public Departamento saveDepartamento (Departamento departamento) {
		return departamentoRepository.save(departamento);
	}

	public List<Departamento> getAllDepartamento() {
		return departamentoRepository.findAll();
	}

	public Departamento getDepartamento(Long depcodigo) {
		return departamentoRepository.findById(depcodigo).orElse(null);

	}

	public void deleteDepartamento(long depcodigo) {
		departamentoRepository.deleteById(depcodigo);

	}

	public Departamento updateDepartamento(Long depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(depcodigo);
		if (departamentoOptional.isPresent()) {
			Departamento departamentoExistente = departamentoOptional.get();
			departamentoExistente.setDepcodigo(novoDepartamento.getDepcodigo());
			departamentoExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(departamentoExistente);
		} else {
			return null;
		}
	}

}


