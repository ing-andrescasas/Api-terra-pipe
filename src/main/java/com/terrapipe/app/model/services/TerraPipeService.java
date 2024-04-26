package com.terrapipe.app.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.terrapipe.app.model.dao.CItyDao;
import com.terrapipe.app.model.dao.CountryDao;
import com.terrapipe.app.model.dao.DataDeviceDao;
import com.terrapipe.app.model.dao.DeviceDao;
import com.terrapipe.app.model.dao.DeviceParameterDao;
import com.terrapipe.app.model.dao.HardwareCategoryDao;
import com.terrapipe.app.model.dao.ImageDeviceDao;
import com.terrapipe.app.model.dao.ProfileDao;
import com.terrapipe.app.model.dao.StateDao;
import com.terrapipe.app.model.dao.TypeIdDao;
import com.terrapipe.app.model.dao.UserDao;
import com.terrapipe.app.model.dao.UserPersonalInformationDao;
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

@Service
public class TerraPipeService implements TerraPipeServiceIface {

    @Autowired
    private DataDeviceDao dataDeviceDao;

    @Autowired
    private CItyDao cityDao;
    
    @Autowired
    private CountryDao countryDao;

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private DeviceParameterDao deviceParameterDao;

    @Autowired
    private HardwareCategoryDao hardwareCategoryDao;

   
    
    @Autowired
    private ImageDeviceDao imageDeviceDao;

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private StateDao stateDao;

    @Autowired
    private TypeIdDao typeIdDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserPersonalInformationDao uPIDao;




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

    public DataDevice updateDataDevice(DataDevice dataDevice){
        return dataDeviceDao.save(dataDevice);
    }
    
//Fin Service to data device    

//Service Device
@Override
    public List<Device> allDevices() {
        return deviceDao.findAll();
    }

    @Override
    public Device saveDevice(Device device) {
        return deviceDao.save(device);
    }

    @Override
    public Device findDeviceById(Integer id) {
        return deviceDao.findById(id).orElse(null);
    }

    @Override
    public void deleteDeviceById(Integer id) {
        deviceDao.deleteById(id);
    }

    @Override
    public Device updateDevice(Device device) {
        return deviceDao.save(device);
    }

//Service to CITY

    @Override
    @Transactional(readOnly=true)
    public List<City> allCities() {
        return cityDao.findAll();
    }

    @Override
    @Transactional
    public City saveCity(City city) {
        return cityDao.save(city);
    }

    @Override
    @Transactional(readOnly = true)
    public City findCityById(Integer id) {
        return cityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteCityById(Integer id) {
        cityDao.deleteById(id);
    }

    public City updateCity(City city){
        return cityDao.save(city);
    }

    //Fin Service to COUNTRY

    @Override
    public List<Country> allCountry() {
        return countryDao.findAll();
    }

    @Override
    public Country saveCountry(Country country) {
        return countryDao.save(country);
    }

    @Override
    public Country findCountryById(Integer id) {
        return countryDao.findById(id).orElse(null);
    }

    @Override
    public void deleteCountryById(Integer id) {
        countryDao.deleteById(id);
    }

    @Override
    public Country updateCountry(Country country) {
        return countryDao.save(country);
    }

    //Service Device Parameters

    @Override
    public List<DeviceParameters> allDevicesParameters() {
        return deviceParameterDao.findAll();
    }

    @Override
    public DeviceParameters saveDeviceParameters(DeviceParameters deviceParameters) {
        return deviceParameterDao.save(deviceParameters);
    }

    @Override
    public DeviceParameters findDeviceParametersById(Integer id) {
        return deviceParameterDao.findById(id).orElse(null);
    }

    @Override
    public void deleteDeviceParametersById(Integer id) {
        deviceParameterDao.deleteById(id);
    }

    @Override
    public DeviceParameters updateDeviceParameters(DeviceParameters deviceParameters) {
        return deviceParameterDao.save(deviceParameters);
    }


//Service Device Parameters

    @Override
    public List<DeviceCategory> allHardwareCategory() {
        return hardwareCategoryDao.findAll();
    }

    @Override
    public DeviceCategory saveHardwareCategory(DeviceCategory hardwareCategory) {
        return hardwareCategoryDao.save(hardwareCategory);
    }

    @Override
    public DeviceCategory findHardwareCategoryById(Integer id) {
        return hardwareCategoryDao.findById(id).orElse(null);
    }

    @Override
    public void deleteHardwareCategoryById(Integer id) {
        hardwareCategoryDao.deleteById(id);
    }

    @Override
    public DeviceCategory updateHardwareCategory(DeviceCategory hardwareCategory) {
        return hardwareCategoryDao.save(hardwareCategory);
    }

    

    //Service Image Device

    @Override
    public List<ImageDevice> allImageDevices() {
        return imageDeviceDao.findAll();
    }

    @Override
    public ImageDevice saveImageDevice(ImageDevice imageDevice) {
        return imageDeviceDao.save(imageDevice);
    }

    @Override
    public ImageDevice findImageDeviceById(Integer id) {
        return imageDeviceDao.findById(id).orElse(null);
    }

    @Override
    public void deleteImageDeviceById(Integer id) {
        imageDeviceDao.deleteById(id);
    }

    @Override
    public ImageDevice updateImageDevice(ImageDevice imageDevice) {
        return imageDeviceDao.save(imageDevice);
    }


     //Service Profile

    @Override
    public List<Profile> allProfiles() {
        return profileDao.findAll();
    }

    @Override
    public Profile saveProfile(Profile profile) {
        return profileDao.save(profile);
    }

    @Override
    public Profile findProfileById(Integer id) {
        return profileDao.findById(id).orElse(null);
    }

    @Override
    public void deleteProfileById(Integer id) {
        profileDao.deleteById(id);
    }

    @Override
    public Profile updateProfile(Profile profile) {
        return profileDao.save(profile);
    }


    //Service State

    @Override
    public List<State> allState() {
        return stateDao.findAll();
    }

    @Override
    public State saveState(State state) {
        return stateDao.save(state);
    }

    @Override
    public State findStateById(Integer id) {
        return stateDao.findById(id).orElse(null);
    }

    @Override
    public void deleteStateById(Integer id) {
        stateDao.deleteById(id);
    }

    @Override
    public State updateState(State state) {
        return stateDao.save(state);
    }



    //Service Type Id

    @Override
    public List<TypeId> allTypeId() {
        return typeIdDao.findAll();
    }

    @Override
    public TypeId saveTypeId(TypeId typeId) {
        return typeIdDao.save(typeId);
    }

    @Override
    public TypeId findTypeIdById(Integer id) {
        return typeIdDao.findById(id).orElse(null);
    }

    @Override
    public void deleteTypeIdById(Integer id) {
        typeIdDao.deleteById(id);
    }

    @Override
    public TypeId updateTypeId(TypeId typeId) {
        return typeIdDao.save(typeId);
    }


//Service User


    @Override
    public List<User> allUsers() {
        return userDao.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public User findUser(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(Integer id) {
        userDao.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        return userDao.save(user);
    }


    //Service UPI

    @Override
    public List<UserPersonalInformation> allUPI() {
        return uPIDao.findAll();
    }

    @Override
    public UserPersonalInformation saveUPI(UserPersonalInformation userPersonalInformation) {
        return uPIDao.save(userPersonalInformation);
    }

    @Override
    public UserPersonalInformation findUPI(Integer id) {
        return uPIDao.findById(id).orElse(null);
    }

    @Override
    public void deleteUPIById(Integer id) {
        uPIDao.deleteById(id);
    }

    @Override
    public UserPersonalInformation updateUPI(UserPersonalInformation userPersonalInformation) {
        return uPIDao.save(userPersonalInformation);
    }

    










}
