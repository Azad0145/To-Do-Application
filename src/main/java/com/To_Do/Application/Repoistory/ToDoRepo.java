package com.To_Do.Application.Repoistory;

import com.To_Do.Application.Entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo,Long> {

}
