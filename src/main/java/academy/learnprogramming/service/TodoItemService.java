package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoItem;

import java.util.List;

public interface TodoItemService {

    List<TodoItem> getItems();

    void addItem(TodoItem toAdd);

    void removeItemById(int id);

    void updateItem(TodoItem toUpdate);

    TodoItem getItemById(int id);
}
