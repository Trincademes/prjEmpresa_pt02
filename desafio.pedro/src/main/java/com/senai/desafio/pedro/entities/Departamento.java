package com.senai.desafio.pedro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;





@Entity
@Table(name="tb_departamneto")
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long depcodigo;
	@NotNull
	@NotBlank
private String depnome;

public long getDepcodigo() {
	return depcodigo;
}

public void setDepcodigo(Long depcodigo) {
	this.depcodigo = depcodigo;
}

public String getDepnome() {
	return depnome;
}

public void setDepnome(String depnome) {
	this.depnome = depnome;
}
}
