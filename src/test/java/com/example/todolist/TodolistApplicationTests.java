package com.example.todolist;
import org.springframework.boot.SpringApplication;

import org.hamcrest.collection.IsArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.example.todolist.entity.Todo;
import com.mysql.cj.xdevapi.Expression;

/*A anotação @SpringBootTest é usada para indicar que o teste vai ser executado em um contexto completo do Spring Boot. 
Ou seja, ela diz ao Spring que o teste deve rodar com todos os recursos configurados, como se fosse uma aplicação real. */
@SpringBootTest
class TodolistApplicationTests {
	/*O WebTestClient é uma classe fornecida pelo Spring WebFlux. Ela é usada para testar as APIs REST de forma assíncrona e não bloqueante. 
		Ela pode ser utilizada em testes de integração para fazer requisições HTTP a um servidor
		a classe  WebTestClient  faz parte do Spring WebFlux, que é uma extensão do Spring para criar aplicações reativas.
		Quando você usa o WebTestClient, está provavelmente dizendo ao Spring que quer testar uma aplicação baseada no Spring WebFlux, e por isso ele precisa da dependência desse módulo no pom.xml.
	 */
	

	 //O WebTestClient vai ser usado para enviar requisições HTTP e testar se a aplicação responde corretamente.
	@Autowired
	private WebTestClient webTestClient;

	//testes junit para casos de sucesso e falhas
	@Test
	void testCriarTodoSucess() {
		Todo todo = new Todo(1L, "estudar spring", " descricao", true, 1);
	/* 1 - O WebTestClient envia uma requisição POST para a rota /todos (que é a rota da API para criar um nova tarefa).
	 * 2 - Manda o corpo da requisição, que é a tarefa que foi criada
	 * 3 - Envia a requisição e espera a resposta do servidor.
	 * 4 - Esperamos que o servidor devolva o código 201 Created, que significa que a a tarefa foi criado com sucesso.
	 * 5 - Esperamos que o corpo da resposta tenha um campo chamado id, que confirma que a a tarefa foi salvo no banco de dados.
	 * 6 - E também esperamos que o nome do usuário na resposta seja "1"


	 */
		webTestClient
		.post()
		.uri("/todos")
		.bodyValue(todo)
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath(:"$").isArray()
		.jsonPath(:"$.length()").isEqualTo(1)
		.jsonPath("$[0].nome").isequalTo(todo.getNome())
		.jsonPath("$[0].descricao").isequalTo(todo.getDescricao())
		.jsonPath("$[0].realizado").isequalTo(todo.isRealizado()())
		.jsonPath("$[0].prioridade").isequalTo(todo.getPrioridade()())
	
	}

	@Test
	void testCriarTodoFailure() {
	}

}
