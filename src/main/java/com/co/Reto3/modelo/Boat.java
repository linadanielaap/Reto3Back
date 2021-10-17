package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.Integer;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table (name="boat")
public class Boat implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idBoat;
    @Column(length = 45)
    private String brand;
    @Column(length = 45)
    private String nameBoat;
    private Integer year;
    @Column(length = 250)
    private String description;

    @ManyToOne
    @JoinColumn (name="category_id")
    @JsonIgnoreProperties("boats")
    private Category category;

    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties("boat")
    private List<Message> mensajesBoat;

    @OneToMany (cascade = {CascadeType.PERSIST}, mappedBy = "boat")
    @JsonIgnoreProperties("boat")
    private List<Reservation> reservations;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public Integer getIdBoat() {
        return idBoat;
    }

    public void setIdBoat(Integer idBoat) {
        this.idBoat = idBoat;
    }

    public String getNameBoat() {
        return nameBoat;
    }

    public void setNameBoat(String nameBoat) {
        this.nameBoat = nameBoat;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMensajesBoat() {
        return mensajesBoat;
    }

    public void setMensajesBoat(List<Message> mensajesBoat) {
        this.mensajesBoat = mensajesBoat;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
