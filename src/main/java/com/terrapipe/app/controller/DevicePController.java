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

import com.terrapipe.app.model.entity.DeviceParameters;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@RestController
@RequestMapping("/device_parameter")
public class DevicePController {
    @Autowired
    private TerraPipeServiceIface terraService;

    @GetMapping("/all")
    public ResponseEntity<List<DeviceParameters>> allDeviceParameters() {
        return ResponseEntity.ok(terraService.allDevicesParameters());
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<DeviceParameters> findDeviceParameters(@PathVariable Integer id){
        return ResponseEntity.ok(terraService.findDeviceParametersById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<DeviceParameters> createDeviceParameters(@RequestBody DeviceParameters deviceParameters) {
        DeviceParameters deviceParametersCreated = terraService.saveDeviceParameters(deviceParameters);
        return  ResponseEntity.ok(deviceParametersCreated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeviceParameters> deleteDeviceParameters(@PathVariable Integer id)  {
        DeviceParameters deviceParametersDelete = terraService.findDeviceParametersById(id);
        terraService.deleteDeviceParametersById(id);;
        return ResponseEntity.ok( deviceParametersDelete);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceParameters> editDeviceParameters(@PathVariable Integer id, @RequestBody  DeviceParameters deviceParameters) {
        DeviceParameters deviceParametersExist = terraService.findDeviceParametersById(id);
            terraService.updateDeviceParameters(deviceParametersExist);
            return ResponseEntity.ok(deviceParametersExist);

    }
}
