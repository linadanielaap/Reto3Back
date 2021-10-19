package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 250)
    private String name;
    @Column(length = 45)
    private String password;
    @Column(length = 45)
    private String email;
    private Integer age;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "client")
    @JsonIgnoreProperties("client")
    private List<Reservation> reservations;

    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="client")
    @JsonIgnoreProperties("client")
    public List<Message>messages;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getBooks() {
        return reservations;
    }

    public void setBooks(List<Reservation> books) {
        this.reservations = books;
    }

    public Integer getIdClient() {
        return id;
    }

    public void setIdClient(Integer idClient) {
        this.id = idClient;
    }

    public String getNameClient() {
        return name;
    }

    public void setNameClient(String nameClient) {
        this.name = nameClient;
    }

    public String getPasswordClient() {
        return password;
    }

    public void setPasswordClient(String passwordClient) {
        this.password = passwordClient;
    }

    public String getEmailClient() {
        return email;
    }

    public void setEmailClient(String emailClient) {
        this.email = emailClient;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
