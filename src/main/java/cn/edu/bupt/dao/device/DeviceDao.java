package cn.edu.bupt.dao.device;

import cn.edu.bupt.dao.Dao;
import cn.edu.bupt.dao.page.TextPageLink;
import cn.edu.bupt.data.Device;

import java.util.List;
import java.util.UUID;

/**
 * Created by CZX on 2018/4/17.
 */
public interface DeviceDao extends Dao<Device> {
    Device save(Device device);

    List<Device> findDevicesByTenantId(UUID tenantId, TextPageLink pageLink);
}
