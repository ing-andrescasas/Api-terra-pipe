package com.terrapipe.app.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terrapipe.app.model.dao.DataDeviceDao;
import com.terrapipe.app.model.entity.DataDevice;

@Service
public class TerraPipeService implements TerraPipeServiceIface {

    @Autowired
    private DataDeviceDao dataDeviceDao;

//Service to data device

    @Override
    @Transactional(readOnly=true)
    public List<DataDevice> dataDevicesAll() {
        return dataDeviceDao.findAll();
    }

    @Override
    @Transactional
    public DataDevice saveDataDevice(DataDevice dataDevice) {
        return dataDeviceDao.save(dataDevice);
    }

    @Override
    @Transactional(readOnly = true)
    public DataDevice findDataDeviceById(Integer id) {
        return dataDeviceDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteDataById(Integer id) {
        dataDeviceDao.deleteById(id);
    }
    
//Fin Service to data device    
}
