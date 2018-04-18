package cn.edu.bupt.dao.device;

import cn.edu.bupt.dao.Cassandra.CassandraAbstractSearchTextDao;
import cn.edu.bupt.dao.page.TextPageLink;
import cn.edu.bupt.data.Device;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static cn.edu.bupt.dao.ModelConstants.*;
import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;

/**
 * Created by CZX on 2018/4/17.
 */
@Component
public class CassandraDeviceDao extends CassandraAbstractSearchTextDao<Device> implements DeviceDao{

    @Override
    protected Class<Device> getColumnFamilyClass() {
        return Device.class;
    }

    @Override
    protected String getColumnFamilyName() {
        return DEVICE_COLUMN_FAMILY_NAME;
    }

    @Override
    public Device save(Device domain) {
        Device savedDevice = super.save(domain);
        return savedDevice;
    }

    @Override
    public List<Device> findDevicesByTenantId(UUID tenantId, TextPageLink pageLink) {
        List<Device> devices = findPageWithTextSearch(DEVICE_BY_TENANT_AND_SEARCH_TEXT_COLUMN_FAMILY_NAME,
                Collections.singletonList(eq(DEVICE_TENANT_ID_PROPERTY, tenantId)), pageLink);
        return devices;
    }
}
