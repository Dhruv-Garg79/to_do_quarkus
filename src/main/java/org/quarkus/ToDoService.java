package org.quarkus;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ToDoService {
    ArrayList<ToDo> list = new ArrayList<>();

    public ToDoService(){

    }

    public boolean addTask(String task){
        ToDo toDo = new ToDo(task, false, new Date());
        return list.add(toDo);
    }

    public List<ToDo> allTasks(){
        return list;
    }

    public ToDo getTask(String id){
        Optional<ToDo> item = list.stream().filter(toDo -> toDo.id.equals(id)).findFirst();
        return item.orElse(null);
    }

    public ToDo changeStatus(String id){
        ToDo todo = getTask(id);
        todo.isComplete = !todo.isComplete;
        return todo;
    }

    public boolean delete(String id){
        return list.remove(getTask(id));
    }
}
