package com.example.AttestYoutube.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //Эта аннотация указывает, что класс Message является сущностью JPA, которая будет соответствовать таблице в базе данных.
public class Message {
    @Id //Эта аннотация обозначает, что поле id — это первичный ключ сущности.
    @GeneratedValue(strategy=GenerationType.AUTO) //позволяет JPA автоматически выбрать стратегию генерации значений для этого поля
    private Integer id; //тут и далее данные, которые храним в таблице
    private String text;
    private String tag;

    public Message() {
    }

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    //геттеры и сеттеры для полей требуются для JPA, чтобы он мог получать и устанавливать значения полей, когда будет работать с экземплярами сущностей
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
