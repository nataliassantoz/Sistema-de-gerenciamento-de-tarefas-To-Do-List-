package com.example.todolist.service;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;


//para ser um serviço no spring ou seja, passivo de injeção de dependencia, é necessario usar a anotação @Service
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    /*passando o objeto da interface todoRepository para o construtor, que por sua vez, estende o 
     JpaRepositorie<Todo, Long>, onde oferece metodos prontos para interagir com o bando de dados.*/
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    public List<Todo> criar(Todo todo){
        /*save(todo) -> salva o objeto no banco de dados e retorna a listagem de tarefas.
        Se TodoRepository herda de JpaRepository<Todo, Long>, o Spring Data JPA faz:
        -Abre uma transação com o banco de dados
        -Executa um INSERT ou UPDATE, dependendo se o objeto já existe ou nao bno banco*/
        todoRepository.save(todo);
        return listar();
    }

    public List<Todo> listar(){
        /*antes de listar as tarefas, é necessario ordena-las, por meio da prioridade e nome. 
        Sort no Spring Data JPA é uma classe que permite definir critérios de ordenação ao recuperar dados do banco. 
        Ele é usado como argumento no método findAll(Sort sort) e pode combinar múltiplos critérios.*/
        Sort sort = Sort.by(Sort.Order.desc("prioridade"))
                    .and(Sort.by(Sort.Order.asc("nome")));
        // findé um método do Spring Data JPA,retorna uma lista com todos os registros da tabela correspondente à entidade Todo.
        return todoRepository.findAll(sort);
    }

    public List<Todo> atualizar(Todo todo){
        //salva a atualizacao que houve no todo e lista os todos atualizados
        todoRepository.save(todo);
        return listar();
    }

    public List<Todo> deletar(Long id){
        todoRepository.deleteById(id);
        return listar();
    }
    
}
