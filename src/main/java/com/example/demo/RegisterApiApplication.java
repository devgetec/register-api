package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dominio.Endereco;
import com.example.demo.dominio.Usuario;
import com.example.demo.repositories.EnderecoRepository;
import com.example.demo.repositories.UsuarioRepository;

@SpringBootApplication
public class RegisterApiApplication implements CommandLineRunner{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RegisterApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Usuario u1 = new Usuario(null, "Empresa1", "99999999999", "11111111111", "Pedro Alves", "pedro@gmail.com");
		Usuario u2 = new Usuario(null, "Empresa2", "88888888888", "22222222222", "Ana Maria", "ana@gmail.com");
		Usuario u3 = new Usuario(null, "Empresa3", "77777777777", "33333333333", "Carla Pereira", "carla@gmail.com");
		Usuario u4 = new Usuario(null, "Empresa4", "99999999999", "22222222222", "Joelma de Jesus", "joelma@gmail.com");
		Usuario u5 = new Usuario(null, "Empresa5", "66666666666", "55555555555", "Carine Souza", "carine@gmail.com");
		Usuario u6 = new Usuario(null, "Empresa6", "88888888888", "66666666666", "Luiza Mata", "luiza@gmail.com");
		
		
		
		Endereco e1 = new Endereco(null, "Logradouro1", "Bairro1", "A", u1);
		Endereco e2 = new Endereco(null, "Logradouro2", "Bairro2", "B", u2);
		Endereco e3 = new Endereco(null, "Logradouro3", "Bairro3", "C", u3);
		Endereco e4 = new Endereco(null, "Logradouro4", "Bairro4", "D", u4);
		Endereco e5 = new Endereco(null, "Logradouro5", "Bairro5", "E", u5);
		Endereco e6 = new Endereco(null, "Logradouro6", "Bairro6", "F", u6);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5,u6));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3, e4, e5,e6));
		
		
	}

}
