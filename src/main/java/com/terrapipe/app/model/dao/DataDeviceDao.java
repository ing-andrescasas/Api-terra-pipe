package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.DataDevice;

public interface DataDeviceDao extends JpaRepository<DataDevice, Integer>{
    
}
