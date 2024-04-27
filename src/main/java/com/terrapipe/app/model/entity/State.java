package com.terrapipe.app.model.entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "departamentos")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private boolean estado;
    
    @OneToMany(mappedBy = "departamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<City> municipio;

    @ManyToOne(fetch = FetchType.LAZY)
    private Country pais;

    public State() {
    }

    public State(Integer id, String nombre, boolean status) {
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isStatus() {
        return estado;
    }

    public void setStatus(boolean status) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "State [id=" + id + ", nombre=" + nombre + ", estado=" + estado + "]";
    }

    
}
