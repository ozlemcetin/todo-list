package academy.learnprogramming.repository;

import academy.learnprogramming.model.TodoItem;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoItemsInMemoryDatabase {

    // == fields ==
    private static int idValue = 1;
    private final List<TodoItem> itemList = new ArrayList<>();

    // == constructors ==
    public TodoItemsInMemoryDatabase() {

        //add some data
        addItem(new TodoItem("First", "First Details", LocalDate.now()));
        addItem(new TodoItem("Second", "Second Details", LocalDate.now()));
        addItem(new TodoItem("Third", "Third Details", LocalDate.now()));

    }

    // == public methods ==

    /*
        This class represents the in memory database.
        We don't want the list to be modified
        other than by the public methods provided.
     */
    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(itemList);
    }

    public void addItem(@NonNull TodoItem toAdd) {

        /*
        if (toAdd == null) {
            throw new NullPointerException("toAdd is a required parameter.");
        }
        */

        toAdd.setId(idValue);
        itemList.add(toAdd);
        idValue++;
    }

    public void removeItemById(int id) {

        ListIterator<TodoItem> iterator = itemList.listIterator();
        while (iterator.hasNext()) {

            TodoItem item = iterator.next();
            if (item.getId() == id) {
                iterator.remove();
                break;
            }
        }//While loop
    }

    public void updateItem(@NonNull TodoItem toUpdate) {

        ListIterator<TodoItem> iterator = itemList.listIterator();
        while (iterator.hasNext()) {

            TodoItem item = iterator.next();
            if (item.equals(toUpdate)) {
                iterator.set(toUpdate);
                break;
            }
        }//While loop
    }

    public TodoItem getItemById(int id) {

        Optional<TodoItem> optional
                = itemList.stream().filter(i -> i.getId() == id).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }
}
