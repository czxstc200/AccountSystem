package cn.edu.bupt.controller;

import cn.edu.bupt.dao.device.DeviceDao;
import cn.edu.bupt.dao.deviceCredentials.DeviceCredentialsDao;
import cn.edu.bupt.dao.user.UserDao;
import cn.edu.bupt.data.Device;
import cn.edu.bupt.data.DeviceCredentials;
import cn.edu.bupt.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datastax.driver.core.utils.UUIDs;
import java.util.UUID;

/**
 * Created by CZX on 2018/3/23.
 */
@RestController
public class HelloController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private DeviceDao deviceDao;

    @Autowired
    private DeviceCredentialsDao deviceCredentialsDao;

    @RequestMapping("/")
    public String welcome(){
        return "hello";
    }

    @RequestMapping("/add")
    public String add(){
        Device device = new Device();
        device.setCustomerId(UUIDs.timeBased());
        device.setTenantId(UUIDs.timeBased());
        device.setLocation("1");
        return deviceDao.save(device).toString();

    }

    @RequestMapping("/delete")
    public boolean delete(){
        return deviceDao.removeById(UUID.fromString("9c06d1d2-4211-11e8-bb15-b363097dd18e"));
    }

    @RequestMapping("/findbyid")
    public String findbyid(){
        return deviceDao.findById(UUID.fromString("9c06d1d2-4211-11e8-bb15-b363097dd18e")).toString();
    }

    @RequestMapping("/addc")
    public String addc(){
        DeviceCredentials deviceCredentials = new DeviceCredentials();
        deviceCredentials.setDeviceId(UUID.fromString("5c31eb22-4212-11e8-8e70-b363097dd18e"));
        deviceCredentials.setDeviceToken("test");
        return deviceCredentialsDao.save(deviceCredentials).toString();
    }

    @RequestMapping("/findbydid")
    public String findbydid(){
        return deviceCredentialsDao.findByDeviceId(UUID.fromString("5c31eb22-4212-11e8-8e70-b363097dd18e")).toString();
    }
}
