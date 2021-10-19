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
     *  Variable de la marca del barco
     */
    @Column(length = 45)
    private String brand;
    /**
     *  Variable del nombre del barco
     */
    @Column(length = 45)
    private String name;
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
    @JsonIgnoreProperties("boat")
    private List<Message> messages;
    /**
     *  Variable de las reservaciones del barco
     */
    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties("boat")
    private List<Reservation> reservations;

    /**
     *  Metodo get de marca
     */
    public String getBrand() {
        return brand;
    }

    /**
     *  Metodo set de marca
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *  Metodo get de modelo
     */
    public Integer getYear() {
        return year;
    }

    /**
     *  Metodo set de modelo
     */
    public void setYear(Integer year) {
        this.year = year;
    }

    /**
     *  Metodo get de descripcion
     */
    public String getDescription() {
        return description;
    }

    /**
     *  Metodo set de descripcion
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *  Metodo get de id
     */
    public Integer getIdBoat() {
        return id;
    }

    /**
     *  Metodo set de id
     */
    public void setIdBoat(Integer idBoat) {
        this.id = idBoat;
    }

    /**
     *  Metodo get de nombre
     */
    public String getNameBoat() {
        return name;
    }

    /**
     *  Metodo set de nombre
     */
    public void setNameBoat(String nameBoat) {
        this.name = nameBoat;
    }

    /**
     *  Metodo get de categoría
     */
    public Category getCategory() {
        return category;
    }

    /**
     *  Metodo set de categoría
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     *  Metodo get de mensajes
     */
    public List<Message> getMensajesBoat() {
        return messages;
    }

    /**
     *  Metodo set de mensajes
     */
    public void setMensajesBoat(List<Message> mensajesBoat) {
        this.messages = mensajesBoat;
    }

    /**
     *  Metodo get de reservaciones
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     *  Metodo set de reservaciones
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
