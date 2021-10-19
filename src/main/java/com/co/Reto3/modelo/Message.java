package com.co.Reto3.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idMessage;
    @Column(length = 250)
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "idBoat")
    @JsonIgnoreProperties({"mensajesBoat", "reservations", "client"})
    private Boat boat;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"messages", "books", "client"})
    private Client client;

    public Integer getMessage_id() {
        return idMessage;
    }

    public void setMessage_id(Integer message_id) {
        this.idMessage = message_id;
    }

    public String getText() {
        return messageText;
    }

    public void setText(String text) {
        this.messageText = text;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
