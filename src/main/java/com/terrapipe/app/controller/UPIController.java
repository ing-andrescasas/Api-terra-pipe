package com.terrapipe.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terrapipe.app.model.entity.TypeId;
import com.terrapipe.app.model.entity.UserPersonalInformation;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/upi")
public class UPIController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @CrossOrigin(origins = "*")
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
    // Verificar si se proporcionó un tipoId
    if (uPI.getTipoId() != null) {
        // Verificar si el tipoId existe antes de guardar los datos
        TypeId tipoId = terraService.findTypeIdById(uPI.getTipoId().getId());
        if (tipoId == null) {
            return ResponseEntity.badRequest().build(); // Devolver error 400 si el tipoId no existe
        }
    }

    // Guardar los datos del usuario
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
    public ResponseEntity<UserPersonalInformation> editUPI(@PathVariable Integer id, @RequestBody UserPersonalInformation uPI) {
        try {
            UserPersonalInformation uPIExistente = terraService.findUPI(id);
            
            if (uPIExistente == null) {
                return ResponseEntity.notFound().build();
            }
    
            uPIExistente.setNombre1(uPI.getNombre1());
            uPIExistente.setNombre2(uPI.getNombre2());
            uPIExistente.setApellido1(uPI.getApellido1());
            uPIExistente.setApellido2(uPI.getApellido2());
            uPIExistente.setDireccion(uPI.getDireccion());
            uPIExistente.setTelefono(uPI.getTelefono());
            uPIExistente.setEstado(uPI.isEstado());
    
            // Actualiza el usuario en la base de datos
            terraService.updateUPI(uPIExistente);
    
            return ResponseEntity.ok(uPIExistente);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
}
