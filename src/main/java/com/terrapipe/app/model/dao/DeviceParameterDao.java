package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.DeviceParameters;

public interface DeviceParameterDao extends JpaRepository<DeviceParameters, Integer>{
    
}
