package com.terrapipe.app.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.terrapipe.app.model.entity.State;

public interface StateDao extends JpaRepository<State, Integer>{
    
}
