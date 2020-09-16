package academy.learnprogramming.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String getHelloMessage(String user) {

        StringBuilder builder = new StringBuilder();
        builder.append("Hello, ");
        builder.append(user);
        builder.append("!");
        return builder.toString();
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the Todo List Application!";
    }
}
