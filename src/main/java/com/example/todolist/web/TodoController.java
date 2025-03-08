package com.example.todolist.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;

/* Em api, é necessario o uso de um controlador, para lidar com requisicoes.
 * @RestController, serve para receber aquisicoes HTTP e devolver respostas(json). Dessa forma, o @REstController, diz que a classe é responsavel por receber requisicoes e devolve-las.
 * @RequestMapping(), serve para define o prefixo da URL para todos os endpoints dentro do controller.
 * @GetMapping(),Cria um endpoint do tipo GET (mostrar informações)
 * @PostMapping(), Cria um endpoint do tipo POST (enviar algo).
 */
@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController( TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping 
    List<Todo> criar( @RequestBody Todo todo){
    return todoService.criar(todo);
    }

    @GetMapping()
    List<Todo> listar(){
        return todoService.listar();
    }
    
    @PutMapping
    List<Todo> atualizar(@RequestBody Todo todo){
        return todoService.atualizar(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> deletar(@PathVariable Long id){
        return todoService.deletar(id);
    }
}
