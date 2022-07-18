package com.arcade.todo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TodoModel {
    private String content;
    private @Id @GeneratedValue Long id;

    public TodoModel() {
    }

    public TodoModel(String content) {
        this.content = content;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TodoModel content(String content) {
        setContent(content);
        return this;
    }

    public TodoModel id(Long id) {
        setId(id);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TodoModel)) {
            return false;
        }
        TodoModel todoModel = (TodoModel) o;
        return Objects.equals(content, todoModel.content) && Objects.equals(id, todoModel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, id);
    }

    @Override
    public String toString() {
        return "{" +
                " content='" + getContent() + "'" +
                ", id='" + getId() + "'" +
                "}";
    }

}
