package com.example.todolist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * To-Do entry with id, list it is assigned to and up to 16k long description
 */
@Entity
@Table(name = "entries")
public class ToDoEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "list_id", nullable = false)
    @JsonIgnore
    private ToDoList list;

    @NotNull
    @Column(length=16*1024)
    @Size(max=1*1024)
    private String description;

    public Long getId() {
        return id;
    }

    public void setList(ToDoList list) {
        this.list = list;
    }

    public ToDoList getList() {
        return list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
