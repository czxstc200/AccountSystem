package cn.edu.bupt.data;

import cn.edu.bupt.dao.BaseEntity;
import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import java.util.UUID;

import static cn.edu.bupt.dao.ModelConstants.*;

/**
 * Created by CZX on 2018/3/23.
 */
@Table(name = TENANT_COLUMN_FAMILY_NAME)
public class Tenant implements BaseEntity {

    @PartitionKey(value = 0)
    @Column(name = ID_PROPERTY)
    private UUID id;

    @Column(name = TENANT_NAME_PROPERTY)
    private String name;

    @Column(name = ADDRESS_PROPERTY)
    private String address;

    @Column(name = EMAIL_PROPERTY)
    private String email;

    @Column(name = PHONE_PROPERTY)
    private String phone;

    @Column(name = TENANT_ADDITIONAL_INFO_PROPERTY)
    private String additional_info;

    public Tenant(Tenant tenant) {
        this.id = tenant.getId();
        this.name = tenant.getName();
        this.address = tenant.getAddress();
        this.email = tenant.getEmail();
        this.phone = tenant.getPhone();
        this.additional_info = tenant.getAdditional_info();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    @Override
    public String toString() {
        return "Tenant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", additional_info='" + additional_info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tenant tenant = (Tenant) o;

        if (id != null ? !id.equals(tenant.id) : tenant.id != null) return false;
        if (name != null ? !name.equals(tenant.name) : tenant.name != null) return false;
        if (address != null ? !address.equals(tenant.address) : tenant.address != null) return false;
        if (email != null ? !email.equals(tenant.email) : tenant.email != null) return false;
        if (phone != null ? !phone.equals(tenant.phone) : tenant.phone != null) return false;
        return additional_info != null ? additional_info.equals(tenant.additional_info) : tenant.additional_info == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (additional_info != null ? additional_info.hashCode() : 0);
        return result;
    }
}
