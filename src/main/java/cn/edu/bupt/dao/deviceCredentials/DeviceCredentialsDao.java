package cn.edu.bupt.dao.deviceCredentials;

import cn.edu.bupt.dao.Dao;
import cn.edu.bupt.data.DeviceCredentials;

import java.util.UUID;

/**
 * Created by CZX on 2018/4/17.
 */
public interface DeviceCredentialsDao extends Dao<DeviceCredentials> {

    DeviceCredentials findByDeviceId(UUID deviceId);
}
