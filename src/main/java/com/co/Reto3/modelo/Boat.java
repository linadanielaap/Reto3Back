package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.Integer;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name="boat")
/**
 *
 * @author linad
 */
public class Boat implements Serializable {
    /**
     *  Variable del id del barco
     */
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    /**
     *  Variable del nombre del barco
     */
    @Column(length = 45)
    private String name;
    /**
     *  Variable de la marca del barco
     */
    @Column(length = 45)
    private String brand;
    /**
     *  Variable del modelo del barco
     */
    private Integer year;
    @Column(length = 250)
    /**
     *  Variable de la descripción del barco
     */
    private String description;
    /**
     *  Variable de la categoría del barco
     */
    @ManyToOne
    @JoinColumn (name="category_id")
    @JsonIgnoreProperties("boats")
    private Category category;
    /**
     *  Variable de los mensajes del barco
     */
    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat","client"})
    private List<Message> messages;
    /**
     *  Variable de las reservaciones del barco
     */
    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties({"boat","client"})
    private List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
