package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.HardwareCategory;

public interface HardwareCategoryDao extends JpaRepository<HardwareCategory, Integer>{
    
}
