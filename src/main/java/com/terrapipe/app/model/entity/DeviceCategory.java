package com.terrapipe.app.model.entity;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categorias_dispositivos")
public class DeviceCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private boolean estado;
    
    @OneToMany(mappedBy = "categoria_dispositivo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Device> dispositivos;


    public DeviceCategory() {
    }

    public DeviceCategory(Integer id, String name, boolean status) {
        this.id = id;
        this.nombre = nombre;
        this.estado = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String name) {
        this.nombre = name;
    }

    public boolean isStatus() {
        return estado;
    }

    public void setStatus(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Categoria Dispositivo [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
    }

    
}
