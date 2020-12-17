package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.demo.dominio.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	
}
