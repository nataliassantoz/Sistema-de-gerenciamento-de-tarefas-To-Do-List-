package com.example.todolist;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.todolist.entity.Todo;

@SpringBootTest
class TodolistApplicationTests {

	@Autowired
	private WebTestClient WebTestClient;

	//testes junit para casos de sucesso e falhas
	@Test
	void testCriarTodoSucess() {
		Todo todo = new Todo(1L, "estudar spring", " descricao", true, 1);
	}

	@Test
	void testCriarTodoFailure() {
	}

}
