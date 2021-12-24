// В этом файле просто создаём таблицу
package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Аннотация, мы говорим, что класс является (МОДЕЛЬЮ), которая отвечает за определённую таблицу в базе данных
public class Post {




    @Id  // аннотация, которая показывает, что id явл-ся уникальным идентефикатором
    @GeneratedValue(strategy = GenerationType.AUTO) // аннотация, позволит при добавление нового значения генерировать каждый раз новое значение внутри этого поля
    private Long id; //уникальное id

    //Мы создали уникальный идентефикатор

    private String title, anons, full_text; // поле названия статьи, anons статьи, full_text полный текст статьи
    private int views; // количество просмотров каждой из статьи


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFull_text() {
        return full_text;
    }

    public void setFull_text(String full_text) {
        this.full_text = full_text;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Post() {
    }

    public Post(String title, String anons, String full_text) {
        this.title = title;
        this.anons = anons;
        this.full_text = full_text;
    }
}
