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

import com.terrapipe.app.model.entity.ImageDevice;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/image_devices")
public class ImageDeviceController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<ImageDevice>> allImageDevice() {
        return ResponseEntity.ok(terraService.allImageDevices());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<ImageDevice> findImageDevice(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findImageDeviceById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ImageDevice> createImageDevice(@RequestBody ImageDevice imageDevice) {
        ImageDevice imageDeviceCreated = terraService.saveImageDevice(imageDevice);
        return  ResponseEntity.ok(imageDeviceCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ImageDevice> deleteImageDevice(@PathVariable Integer id)  {

        ImageDevice imageDeviceDelete = terraService.findImageDeviceById(id);
        terraService.deleteImageDeviceById(id);;
        return ResponseEntity.ok( imageDeviceDelete);
    }


    @PutMapping("/{id}")
    public ResponseEntity<ImageDevice> editImageDevice(@PathVariable Integer id, @RequestBody  ImageDevice imageDevice) {
        try {
            ImageDevice imageDeviceExistente = terraService.findImageDeviceById(id);

            if (imageDevice.getName()!= null && !imageDevice.getName().isEmpty())
            imageDeviceExistente.setName(imageDevice.getName());

            imageDeviceExistente.setStatus(imageDevice.isStatus());

            terraService.updateImageDevice(imageDeviceExistente);

            return ResponseEntity.ok(imageDeviceExistente);

        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}
