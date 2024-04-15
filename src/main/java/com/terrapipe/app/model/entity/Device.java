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
@Table(name = "devices")
public class Device {
    
    @Id
    private Integer id;
    private String name;
    private boolean status;

    // @ManyToOne(fetch = FetchType.LAZY)
    // private HardwareProfile hardwareProfile;
    
    // @ManyToOne(fetch = FetchType.LAZY)
    // private HardwareCategory hardwareCategory;
    
    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DataDevice> dataDevices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_parameter_id")
    private DeviceParameters deviceParameters;

    @OneToMany(mappedBy = "device", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<ImageDevice> imageDevices;

    public Device() {
    }


    public Device(Integer id, String name, boolean status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Device [id=" + id + ", name=" + name + ", status=" + status + "]";
    }



    
}
