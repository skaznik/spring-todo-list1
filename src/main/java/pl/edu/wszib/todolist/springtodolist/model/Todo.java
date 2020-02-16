package pl.edu.wszib.todolist.springtodolist.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue
    public Integer id;

    public String title;
    @Temporal(value = TemporalType.TIMESTAMP) //określa jak ma być zapisywana data w bazie
    public Date dueDate;

    public Status status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
