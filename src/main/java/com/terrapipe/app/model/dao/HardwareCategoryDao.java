package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.DeviceCategory;

public interface HardwareCategoryDao extends JpaRepository<DeviceCategory, Integer>{
    
}
