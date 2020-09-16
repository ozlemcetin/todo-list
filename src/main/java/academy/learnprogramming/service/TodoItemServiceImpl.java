package academy.learnprogramming.service;

import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.repository.TodoItemsInMemoryDatabase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemServiceImpl implements TodoItemService {

    // == fields ==
    private final TodoItemsInMemoryDatabase repository = new TodoItemsInMemoryDatabase();

    @Override
    public List<TodoItem> getItems() {
        return repository.getItems();
    }

    @Override
    public void addItem(TodoItem toAdd) {
        repository.addItem(toAdd);
    }

    @Override
    public void removeItemById(int id) {
        repository.removeItemById(id);
    }

    @Override
    public void updateItem(TodoItem toUpdate) {
        repository.updateItem(toUpdate);
    }

    @Override
    public TodoItem getItemById(int id) {
        return repository.getItemById(id);
    }
}
