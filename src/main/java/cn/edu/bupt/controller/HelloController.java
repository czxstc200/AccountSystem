package cn.edu.bupt.controller;

import cn.edu.bupt.dao.device.DeviceDao;
import cn.edu.bupt.dao.deviceCredentials.DeviceCredentialsDao;
import cn.edu.bupt.dao.page.TextPageLink;
import cn.edu.bupt.data.Device;
import cn.edu.bupt.data.DeviceCredentials;
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
        device.setTenantId(UUID.fromString("5c31eb21-4212-11e8-8e70-b363097dd18e"));
        device.setLocation("1");
        device.setSearchText("2");
        return deviceDao.save(device).toString();

    }

    @RequestMapping("/delete")
    public boolean delete(){
        return deviceDao.removeById(UUID.fromString("1966f4f3-421e-11e8-99c1-b363097dd18e"));
    }

    @RequestMapping("/findbyid")
    public String findbyid(){
        return deviceDao.findById(UUID.fromString("1966f4f3-421e-11e8-99c1-b363097dd18e")).toString();
    }

    @RequestMapping("/findbyTid")
    public String findbyTid(){
        TextPageLink textPageLink = new TextPageLink(2);
        return deviceDao.findDevicesByTenantId(UUID.fromString("5c31eb21-4212-11e8-8e70-b363097dd18e"),textPageLink).toString();
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
