package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.Device;

public interface DeviceDao extends JpaRepository<Device, Integer>{
    
}
