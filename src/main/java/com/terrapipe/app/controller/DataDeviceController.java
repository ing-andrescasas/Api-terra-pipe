package com.terrapipe.app.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terrapipe.app.model.entity.DataDevice;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@Controller
@RequestMapping("/dataDevices")
public class DataDeviceController {
    
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<DataDevice>> allDataDevice() {
        return ResponseEntity.ok(terraService.dataDevicesAll());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<DataDevice> findDataDevice(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findDataDeviceById(id));
    }

    @PostMapping
    public ResponseEntity<DataDevice> createProduct(@RequestBody DataDevice dataDevice) {
        DataDevice deviceCreated = terraService.saveDataDevice(dataDevice);
        return  ResponseEntity.ok(deviceCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataDevice> deleteDataDevice(@PathVariable Integer id)  {

        DataDevice dataDeviceDelete = terraService.findDataDeviceById(id);
        terraService.deleteDataById(id);
        return ResponseEntity.ok( dataDeviceDelete);
    }


}
