package com.terrapipe.app.model.services;

import java.util.List;

import com.terrapipe.app.model.entity.DataDevice;

public interface TerraPipeServiceIface {
    
    
    //Service to Data device
    public List<DataDevice> dataDevicesAll();

    public DataDevice saveDataDevice(DataDevice dataDevice);

    public DataDevice findDataDeviceById(Integer id);

    public void deleteDataById(Integer id);

}
