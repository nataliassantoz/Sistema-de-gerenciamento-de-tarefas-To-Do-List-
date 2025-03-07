package com.example.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todolist.entity.Todo;

//Repositorios com spring data, é construido com interface que estende o jpa repository
//uso do generic, onde o objeto é o todo e o tipo é long
public interface  TodoRepository extends JpaRepository<Todo, Long>{
    
}
