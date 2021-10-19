package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name="idBoat")
    @JsonIgnoreProperties("reservations")
    private Boat boat;


    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;


    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy="reserva")
    @JsonIgnoreProperties("reserva")
    private Score score;

    public Score getCalificacion() {
        return score;
    }

    public void setCalificacion(Score calificacion) {
        this.score = calificacion;
    }

    public Integer getIdReserva() {
        return idReservation;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReservation = idReserva;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return devolutionDate;
    }

    public void setEndDate(Date endDate) {
        this.devolutionDate= endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client cliente) {
        this.client = cliente;
    }
}
