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
    private Integer idReserva;
    private Date startDate;
    private Date endDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name="idBoat")
    @JsonIgnoreProperties("reservations")
    private Boat boat;


    @ManyToOne
    @JoinColumn(name = "idClient")
    @JsonIgnoreProperties({"books","messages"})
    private Client cliente;


    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy="reserva")
    @JsonIgnoreProperties("reserva")
    private Score calificacion;

    public Score getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Score calificacion) {
        this.calificacion = calificacion;
    }

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
        return cliente;
    }

    public void setCliente(Client cliente) {
        this.cliente = cliente;
    }
}
