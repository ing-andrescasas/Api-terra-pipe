package com.terrapipe.app.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.terrapipe.app.model.entity.DataDevice;
import com.terrapipe.app.model.services.TerraPipeServiceIface;

@Controller
@RequestMapping("/dataDevices")
public class DataDeviceController {
    
    @Autowired
    private TerraPipeServiceIface terraIface;

    public ResponseEntity<List<DataDevice>> allDataDevice() {
        return ResponseEntity.ok(terraIface.dataDevicesAll());
    }


}
