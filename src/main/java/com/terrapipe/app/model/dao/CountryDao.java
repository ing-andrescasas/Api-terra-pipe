package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer >{
    
}
