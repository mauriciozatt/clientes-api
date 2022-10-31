package com.clientesapi.clientesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clientesapi.clientesapi.model.Cliente;


//responsável por interagir com o banco de dados. Faz o meio de campo entre meu controler e minha entity...
@Repository 
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
//Não preciso implementar meus métodos, pois o próprio JPArepository me fornece as  operações principais...
}
