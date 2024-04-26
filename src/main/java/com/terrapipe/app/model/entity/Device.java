package com.terrapipe.app.model.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "dispositivos")
public class Device {
    @Id
    private Integer id;
    private String name;
    private boolean estado;
    

    @ManyToOne(fetch = FetchType.LAZY)
    private DeviceCategory categoriaDispositivo;

    public Device() {
    }


    public Device(Integer id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.estado = status;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public boolean isStatus() {
        return estado;
    }


    public void setStatus(boolean status) {
        this.estado = estado;
    }


    @Override
    public String toString() {
        return "Dispositivo [id=" + id + ", name=" + name + ", estado=" + estado + "]";
    }



    
}
