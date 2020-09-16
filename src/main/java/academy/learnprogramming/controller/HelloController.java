package academy.learnprogramming.controller;

import academy.learnprogramming.service.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class HelloController {

    // == fields ==
    private final HelloService helloService;

    // == constructors ==
    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    // == request methods ==

    /*
        //http://localhost:8080/todo-list/hello
        @GetMapping("/hello")
        public String helloReturnsViewName() {
            return "hello";
        }
    */

    /*
        the string hello which you can see returning
        will be written to the response body
        which the browser will then display
     */

    @ResponseBody
    @GetMapping("/hello")
    public String helloServesContent() {
        //Writing ["Hello World!"]
        return "Hello World!";
    }

    /*
        Model parameter will be created by the dispatcher servlet and
        we'll get to it as a parameter and
        we can add attributes to the model and
        those attributes will be available in the view
     */

    //http://localhost:8080/todo-list/welcome
    //http://localhost:8080/todo-list/welcome?user=Tim
    //http://localhost:8080/todo-list/welcome?user=Tim&age=39
    @GetMapping("welcome")
    public String welcome(@RequestParam String user,
                          @RequestParam int age, Model model) {

        //model is set = {user=Tim}
        //model.addAttribute("user", "Tim");

        model.addAttribute("helloMessage", helloService.getHelloMessage(user));
        model.addAttribute("age", age);
        log.info("model is set = {}", model);

        //Forwarding to [/WEB-INF/view/welcome.jsp]
        return "welcome";
    }

    // == model attributes ==

    /*
        A: we can use the model attribute annotation to add attributes to the model or
        B: add them manually by calling the add attribute method
     */
    /*
        welcomeMessage() will be called before any request methods
     */
    @ModelAttribute("welcomeMessage")
    public String welcomeMessage() {

        log.info("welcomeMessage() called");
        return helloService.getWelcomeMessage();
    }
}
