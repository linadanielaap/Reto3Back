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
    /**
     *  Metodo get de id
     */
    public Integer getId() {
        return id;
    }
    /**
     *  Metodo set de id
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     *  Metodo get de brand
     */
    public String getBrand() {
        return brand;
    }
    /**
     *  Metodo set de brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     *  Metodo get de name
     */
    public String getName() {
        return name;
    }
    /**
     *  Metodo set de name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *  Metodo get de year
     */
    public Integer getYear() {
        return year;
    }
    /**
     *  Metodo set de year
     */
    public void setYear(Integer year) {
        this.year = year;
    }
    /**
     *  Metodo get de description
     */
    public String getDescription() {
        return description;
    }
    /**
     *  Metodo set de description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     *  Metodo get de category
     */
    public Category getCategory() {
        return category;
    }
    /**
     *  Metodo set de category
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     *  Metodo get de message
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     *  Metodo set de message
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     *  Metodo get de reservations
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     *  Metodo set de reservations
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
