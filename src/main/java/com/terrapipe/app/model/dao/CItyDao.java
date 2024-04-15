package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.City;

public interface CItyDao extends JpaRepository<City, Integer>{
    
}
