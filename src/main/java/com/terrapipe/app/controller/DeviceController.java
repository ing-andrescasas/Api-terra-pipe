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

import com.terrapipe.app.model.entity.Device;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<Device>> allDevice() {
        return ResponseEntity.ok(terraService.allDevices());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Device> findDevice(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findDeviceById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Device> createDevice(@RequestBody Device device) {
        Device deviceCreated = terraService.saveDevice(device);
        return  ResponseEntity.ok(deviceCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Device> deleteDevice(@PathVariable Integer id)  {

        Device deviceDelete = terraService.findDeviceById(id);
        terraService.deleteDeviceById(id);;
        return ResponseEntity.ok( deviceDelete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> editDevice(@PathVariable Integer id, @RequestBody  Device device) {
        Device deviceExist = terraService.findDeviceById(id);
            terraService.updateDevice(deviceExist);
            return ResponseEntity.ok(deviceExist);

    }
}
