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

import com.terrapipe.app.model.entity.TypeId;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/type_id")
public class TypeIdController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<TypeId>> allTypeIds() {
        return ResponseEntity.ok(terraService.allTypeId());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TypeId> findTypeIdById(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findTypeIdById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<TypeId> createTypeId(@RequestBody TypeId typeId) {
        TypeId typeIdCreated = terraService.saveTypeId(typeId);
        return  ResponseEntity.ok(typeIdCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TypeId> deleteTypeId(@PathVariable Integer id)  {

        TypeId typeIdDelete = terraService.findTypeIdById(id);
        terraService.deleteTypeIdById(id);;
        return ResponseEntity.ok( typeIdDelete);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TypeId> editTypeId(@PathVariable Integer id, @RequestBody  TypeId typeId) {
        try {
            TypeId typeIdExistente = terraService.findTypeIdById(id);

            if (typeId.getName()!= null && !typeId.getName().isEmpty())
            typeIdExistente.setName(typeId.getName());


            typeIdExistente.setStatus(typeId.isStatus());

            terraService.updateTypeId(typeIdExistente);

            return ResponseEntity.ok(typeIdExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
