package com.terrapipe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terrapipe.app.model.entity.State;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/states")
public class StateController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<State>> allStates() {
        return ResponseEntity.ok(terraService.allState());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<State> findState(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findStateById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<State> createState(@RequestBody State state) {
        State stateCreated = terraService.saveState(state);
        return  ResponseEntity.ok(stateCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<State> deleteState(@PathVariable Integer id)  {

        State stateDelete = terraService.findStateById(id);
        terraService.deleteStateById(id);;
        return ResponseEntity.ok( stateDelete);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<State> editState(@PathVariable Integer id, @RequestBody  State state) {
        try {
            State stateExistente = terraService.findStateById(id);

            if (state.getNombre()!= null && !state.getNombre().isEmpty())
            stateExistente.setNombre(state.getNombre());


            stateExistente.setStatus(state.isStatus());

            terraService.updateState(stateExistente);

            return ResponseEntity.ok(stateExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
