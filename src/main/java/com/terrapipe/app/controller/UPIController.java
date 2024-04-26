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

import com.terrapipe.app.model.entity.UserPersonalInformation;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/upi")
public class UPIController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<UserPersonalInformation>> allUPI() {
        return ResponseEntity.ok(terraService.allUPI());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<UserPersonalInformation> findUPI(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findUPI(id));
    }

    @PostMapping("/create")
    public ResponseEntity<UserPersonalInformation> createUser(@RequestBody UserPersonalInformation uPI) {
        UserPersonalInformation uPICreated = terraService.saveUPI(uPI);
        return  ResponseEntity.ok(uPICreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserPersonalInformation> deleteUPI(@PathVariable Integer id)  {

        UserPersonalInformation uPIDelete = terraService.findUPI(id);
        terraService.deleteUPIById(id);;
        return ResponseEntity.ok(uPIDelete);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<UserPersonalInformation> editUPI(@PathVariable Integer id, @RequestBody  UserPersonalInformation uPI) {
        try {
            UserPersonalInformation uPIExistente = terraService.findUPI(id);

            if (uPI.getNombre1()!= null && !uPI.getNombre1().isEmpty())
            uPIExistente.setNombre1(uPI.getNombre1());
            if (uPI.getNombre2()!= null && !uPI.getNombre2().isEmpty())
            uPIExistente.setNombre2(uPI.getNombre2());
            if (uPI.getApellido1()!= null && !uPI.getApellido1().isEmpty())
            uPIExistente.setApellido1(uPI.getApellido1());
            if (uPI.getApellido2()!= null && !uPI.getApellido2().isEmpty())
            uPIExistente.setApellido2(uPI.getApellido2());
            if (uPI.getDireccion()!= null && !uPI.getDireccion().isEmpty())
            uPIExistente.setDireccion(uPI.getDireccion());
            if (uPI.getNumeroTelefono()!= null)
            uPIExistente.setNumeroTelefono(uPI.getNumeroTelefono());

            uPIExistente.setEstado(uPI.isEstado());

            terraService.updateUPI(uPIExistente);

            return ResponseEntity.ok(uPIExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
