package com.ukidelly.springboot.myfirstapp.todo;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/todo-jpa")
@SessionAttributes("username")
public class TodoControllerJPA {
    private final TodoRepository todoRepository;

    public TodoControllerJPA(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("list-todos")
    public String listAllTodos(Model model) {
        var username = (String) model.getAttribute("username");
        var res = todoRepository.findAllByUsername(username);

        model.addAttribute("todos", res);


        return "todos";
    }
}
