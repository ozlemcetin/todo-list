package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mappings;
import academy.learnprogramming.util.Views;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Controller
public class TodoItemController {

    // == fields ==
    private final TodoItemService todoItemService;

    // == constructors ==
    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    //  == model attributes ==
    @ModelAttribute("todoItemList")
    public List<TodoItem> getItems() {

        log.info("items added as a model attribute with @ModelAttribute");
        return todoItemService.getItems();
    }

    // == request methods ==

    //http://localhost:8080/todo-list/items
    @GetMapping(Mappings.ITEMS_MAPPING)
    public String items() {

        log.info("items() called with @GetMapping");

        //Forwarding to [/WEB-INF/view/items.jsp]
        return Views.ITEMS_VIEW;
    }


    //Add: http://localhost:8080/todo-list/addItem
    //Update:  http://localhost:8080/todo-list/addItem?id=1
    @GetMapping(Mappings.ADD_ITEM_MAPPING)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id,
                              Model model) {

        log.info("addEditItem() called with @GetMapping");
        log.info("id request parameter is OPTIONAL id={}", id);

        TodoItem item = todoItemService.getItemById(id);
        log.info("todo item is requested from database with getItemById() ");
        log.info("the todo item form the database ={}", item);

        if (item == null) {
            item = new TodoItem("", "", LocalDate.now());
            log.info("an empty todo item is created ={}", item);
        }

        model.addAttribute(AttributeNames.TODO_ITEM_ATTRIBUTE_NAME, item);
        log.info("todo item added as a model attribute with addAttribute() ");

        //Forwarding to [/WEB-INF/view/add_item.jsp]
        return Views.ADD_ITEM_VIEW;
    }


    /*
        After the form is submitted,
        to automatically get the object from the form, add @ModelAttribute
        Spring MVC will bind the form data to the parameter
     */
    @PostMapping(Mappings.ADD_ITEM_MAPPING)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM_ATTRIBUTE_NAME) TodoItem todoItem) {

        log.info("processItem() called with @PostMapping");
        log.info("the todo item submitted form the form={}", todoItem);

        TodoItem item = todoItemService.getItemById(todoItem.getId());
        log.info("todo item is requested from database with getItemById() ");
        log.info("the todo item form the database ={}", item);

        if (item == null) {
            todoItemService.addItem(todoItem);
            log.info("todo item is added to database with addItem() ");

        } else {

            todoItemService.updateItem(todoItem);
            log.info("todo item is edited in database with updateItem() ");
        }
        /*
            Post Redirect Get Pattern:
            Once the form is submitted, return (redirect)
            to the items table and see the new item right away.
         */
        return "redirect:/" + Mappings.ITEMS_MAPPING;
    }

    @GetMapping(Mappings.DELETE_ITEM_MAPPING)
    public String deleteItem(@RequestParam int id) {

        log.info("deleteItem() called with @GetMapping");
        log.info("id request parameter is REQUIRED id={}", id);

        todoItemService.removeItemById(id);
        log.info("todo item with id {} is removed from database with removeItemById() ", id);

        return "redirect:/" + Mappings.ITEMS_MAPPING;
    }

    @GetMapping(Mappings.VIEW_ITEM_MAPPING)
    public String viewItem(@RequestParam int id, Model model) {

        log.info("viewItem() called with @GetMapping");
        log.info("id request parameter is REQUIRED id={}", id);

        TodoItem item = todoItemService.getItemById(id);
        log.info("todo item is requested from database with getItemById() ");
        log.info("the todo item form the database ={}", item);

        model.addAttribute(AttributeNames.TODO_ITEM_ATTRIBUTE_NAME, item);
        log.info("todo item added as a model attribute with addAttribute() ");

        //Forwarding to [/WEB-INF/view/view_item.jsp]
        return Views.VIEW_ITEM_VIEW;
    }


}
