package com.clientesapi.clientesapi.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.clientesapi.clientesapi.model.Cliente;
import com.clientesapi.clientesapi.repository.ClienteRepository;


/// Estou definindo que quando bater uma requisição com essa URL caia nesse andpoint...
@RestController
@RequestMapping("/clientes") 
public class ClienteController {

	// injeta uma instância nessa var...
	@Autowired 
	private ClienteRepository clienteRepository;

	
	// Estou defindo que quando bater uma requisição do tipo Get para a url clientes execute esse método ...
	@GetMapping 
	public List<Cliente> listarClientes() {
		return clienteRepository.findAll();
	};
	
	
	//O @RequestBody vai converter meu Json para um objeto do tipo Cliente já..
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public Cliente cadastrarCliente(@RequestBody Cliente cliente){
		return clienteRepository.save(cliente); 
		
	}; 
	
	
	@DeleteMapping
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void deletarCliente(Long id) {
	clienteRepository.deleteById(id);		
	}
	
	
	
	//O método save se receber o ID no body já irá saber que deve atualizar o mesmo 
	@PutMapping
	@ResponseStatus(value = HttpStatus.OK)
	public Cliente atualizaNomeCliente(long id, @RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	};
	
	
	
	
	
	

}
