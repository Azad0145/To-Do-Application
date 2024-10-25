package com.To_Do.Application.Service;

import com.To_Do.Application.Entity.ToDo;
import com.To_Do.Application.Repoistory.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    @Autowired
    ToDoRepo repo;
    public List<ToDo> getAllToDoItems() {
        ArrayList<ToDo> todoList = new ArrayList<>();
        todoList.addAll( repo.findAll() );

        return todoList;
    }

    public ToDo getToDoItemById(Long id) {
        return repo.findById(id).get();
    }

    public boolean updateStatus(Long id) {
        ToDo todo = getToDoItemById(id);
        todo.setStatus("Completed");

        return saveOrUpdateToDoItem(todo);
    }


    public boolean saveOrUpdateToDoItem(ToDo todo) {
        if (todo.getId() != null) {

            ToDo existingToDo = repo.findById(todo.getId()).orElse(null);
                if (existingToDo != null) {
                    existingToDo.setTitle(todo.getTitle());
                    existingToDo.setStatus(todo.getStatus());
                    repo.save(existingToDo);
                    return true;
                }
            } else {

                repo.save(todo);
                return true;
            }
            return false;
        }


        public boolean deleteToDoItem(Long id) {
        repo.deleteById(id);

        if (repo.findById(id).isEmpty()) {
            return true;
        }

        return false;
    }
}
