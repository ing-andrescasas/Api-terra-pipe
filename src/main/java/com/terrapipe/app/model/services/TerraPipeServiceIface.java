package com.terrapipe.app.model.services;

import java.util.List;

import com.terrapipe.app.model.entity.City;
import com.terrapipe.app.model.entity.Country;
import com.terrapipe.app.model.entity.DataDevice;
import com.terrapipe.app.model.entity.Device;
import com.terrapipe.app.model.entity.DeviceParameters;
import com.terrapipe.app.model.entity.DeviceCategory;
import com.terrapipe.app.model.entity.ImageDevice;
import com.terrapipe.app.model.entity.Profile;
import com.terrapipe.app.model.entity.State;
import com.terrapipe.app.model.entity.TypeId;
import com.terrapipe.app.model.entity.User;
import com.terrapipe.app.model.entity.UserPersonalInformation;

public interface TerraPipeServiceIface {
    
    
    //Service to Data device
    public List<DataDevice> dataDevicesAll();

    public DataDevice saveDataDevice(DataDevice dataDevice);

    public DataDevice findDataDeviceById(Integer id);

    public void deleteDataById(Integer id);

    public DataDevice updateDataDevice(DataDevice dataDevice);

    //

    //Service to City
    public List<City> allCities();

    public City saveCity(City city);

    public City findCityById(Integer id);

    public void deleteCityById(Integer id);

    public City updateCity(City city);
    //

    //Service to Country
    public List<Country> allCountry();

    public Country saveCountry(Country country);

    public Country findCountryById(Integer id);

    public void deleteCountryById(Integer id);

    public Country updateCountry(Country country);
    //

    //Service to Device
    public List<Device> allDevices();

    public Device saveDevice(Device device);

    public Device findDeviceById(Integer id);

    public void deleteDeviceById(Integer id);

    public Device updateDevice(Device device);
    //

    //Service to Device Parameter
    public List<DeviceParameters> allDevicesParameters();

    public DeviceParameters saveDeviceParameters(DeviceParameters deviceParameters);

    public DeviceParameters findDeviceParametersById(Integer id);

    public void deleteDeviceParametersById(Integer id);

    public DeviceParameters updateDeviceParameters(DeviceParameters deviceParameters);
    //

    //Service to Hardware category
    public List<DeviceCategory> allHardwareCategory();

    public DeviceCategory saveHardwareCategory(DeviceCategory hardwareCategory);

    public DeviceCategory findHardwareCategoryById(Integer id);

    public void deleteHardwareCategoryById(Integer id);

    public DeviceCategory updateHardwareCategory(DeviceCategory hardwareCategory);
    //

 

    //Service to Image Device
    public List<ImageDevice> allImageDevices();

    public ImageDevice saveImageDevice(ImageDevice imageDevice);

    public ImageDevice findImageDeviceById(Integer id);

    public void deleteImageDeviceById(Integer id);

    public ImageDevice updateImageDevice(ImageDevice imageDevice);
    //


    //Service to Profile
    public List<Profile> allProfiles();

    public Profile saveProfile(Profile profile);

    public Profile findProfileById(Integer id);

    public void deleteProfileById(Integer id);

    public Profile updateProfile(Profile profile);
    //

    //Service to State
    public List<State> allState();

    public State saveState(State state);

    public State findStateById(Integer id);

    public void deleteStateById(Integer id);

    public State updateState(State state);
    //

    //Service to Type Id
    public List<TypeId> allTypeId();

    public TypeId saveTypeId(TypeId typeId);

    public TypeId findTypeIdById(Integer id);

    public void deleteTypeIdById(Integer id);

    public TypeId updateTypeId(TypeId typeId);
    //

    //Service to User
    public List<User> allUsers();

    public User saveUser(User user);

    public User findUser(Integer id);

    public void deleteUserById(Integer id);

    public User updateUser(User user);
    //
    
    //Service to User Personal Inofrmation
    public List<UserPersonalInformation> allUPI();

    public UserPersonalInformation saveUPI(UserPersonalInformation userPersonalInformation);

    public UserPersonalInformation findUPI(Integer id);

    public void deleteUPIById(Integer id);

    public UserPersonalInformation updateUPI(UserPersonalInformation userPersonalInformation);
    //


}
