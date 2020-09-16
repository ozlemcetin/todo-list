package academy.learnprogramming.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(of = "id")
//@EqualsAndHashCode(of = {"id", "title"})
public class TodoItem {

    // == fields ==
    private int id;
    private String title;
    private String details;
    private LocalDate deadline;

    // == constructors ==
    public TodoItem(String title, String details, LocalDate deadlineDate) {
        this.title = title;
        this.details = details;
        this.deadline = deadlineDate;
    }


}
