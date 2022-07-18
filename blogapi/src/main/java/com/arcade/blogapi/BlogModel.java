package com.arcade.blogapi;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BlogModel {

    private @Id @GeneratedValue Long id;
    private String blogTitle;
    private String blogText;
    private LocalDateTime createdAt;

    public BlogModel() {
    }

    public BlogModel(Long id, String blogTitle, String blogText) {
        this.id = id;
        this.blogTitle = blogTitle;
        this.blogText = blogText;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return this.blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogText() {
        return this.blogText;
    }

    public void setBlogText(String blogText) {
        this.blogText = blogText;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BlogModel id(Long id) {
        setId(id);
        return this;
    }

    public BlogModel blogTitle(String blogTitle) {
        setBlogTitle(blogTitle);
        return this;
    }

    public BlogModel blogText(String blogText) {
        setBlogText(blogText);
        return this;
    }

    public BlogModel createdAt(LocalDateTime createdAt) {
        setCreatedAt(createdAt);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BlogModel)) {
            return false;
        }
        BlogModel blogModel = (BlogModel) o;
        return Objects.equals(id, blogModel.id) && Objects.equals(blogTitle, blogModel.blogTitle)
                && Objects.equals(blogText, blogModel.blogText) && Objects.equals(createdAt, blogModel.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blogTitle, blogText, createdAt);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", blogTitle='" + getBlogTitle() + "'" +
                ", blogText='" + getBlogText() + "'" +
                ", createdAt='" + getCreatedAt() + "'" +
                "}";
    }

}
