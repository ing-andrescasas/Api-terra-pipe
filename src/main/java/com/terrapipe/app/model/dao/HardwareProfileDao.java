package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.HardwareProfile;


public interface HardwareProfileDao extends JpaRepository<HardwareProfile, Integer>{
    
}
