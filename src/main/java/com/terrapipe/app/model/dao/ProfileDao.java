package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{
    
}
