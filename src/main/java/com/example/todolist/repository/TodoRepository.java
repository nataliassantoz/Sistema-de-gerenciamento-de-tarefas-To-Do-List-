package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entity.Todo;

/*Repositorios com spring data, é construido com interface que estende o jpa repository/uso do generic, onde o objeto é o todo e o tipo é long.
O JPA (Java Persistence API) é uma ferramenta que facilita a comunicação entre o código Java e o banco de dados. O JPA (Java Persistence API) é a especificação padrão do Java para ORM, e o Hibernate é uma das implementações mais populares do JPA.*/

public interface  TodoRepository extends JpaRepository<Todo, Long>{
    
}
