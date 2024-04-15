package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.ImageDevice;

public interface ImageDeviceDao extends JpaRepository<ImageDevice, Integer>{
    
}
