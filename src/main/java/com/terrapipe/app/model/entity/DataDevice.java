package com.terrapipe.app.model.entity;

import java.sql.Time;
import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "data_devices")
public class DataDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Temporal(TemporalType.DATE)
    private Date date;

	@Temporal(TemporalType.TIME)
    private Time time;

    private String info;
    
    private boolean status;


    @ManyToOne(fetch = FetchType.LAZY)
    private Device device;

    public DataDevice() {
    }

    public DataDevice(Integer id, Date date, Time time, String info, boolean status) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.info = info;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "DataDevice [id=" + id + ", date=" + date + ", time=" + time + ", info=" + info + ", status=" + status
                + "]";
    }

   
}
