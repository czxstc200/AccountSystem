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
@Table(name = CUSTOMER_COLUMN_FAMILY_NAME)
public class Customer implements BaseEntity{

    @PartitionKey(value = 0)
    @Column(name = ID_PROPERTY)
    private UUID id;

    @PartitionKey(value = 1)
    @Column(name = CUSTOMER_TENANT_ID_PROPERTY)
    private UUID tenant_id;

    @Column(name = CUSTOMER_NAME_PROPERTY)
    private String name;

    @Column(name = ADDRESS_PROPERTY)
    private String address;

    @Column(name = EMAIL_PROPERTY)
    private String email;

    @Column(name = PHONE_PROPERTY)
    private String phone;

    @Column(name = CUSTOMER_ADDITIONAL_INFO_PROPERTY)
    private String additional_info;

    public Customer(Customer customer) {
        this.id = customer.getId();
        this.tenant_id = customer.getTenant_id();
        this.name = customer.getName();
        this.address = customer.getAddress();
        this.email = customer.getEmail();
        this.phone = customer.getPhone();
        this.additional_info = customer.getAdditional_info();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getTenant_id() {
        return tenant_id;
    }

    public void setTenant_id(UUID tenant_id) {
        this.tenant_id = tenant_id;
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
        return "Customer{" +
                "id=" + id +
                ", tenant_id=" + tenant_id +
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

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (tenant_id != null ? !tenant_id.equals(customer.tenant_id) : customer.tenant_id != null) return false;
        if (name != null ? !name.equals(customer.name) : customer.name != null) return false;
        if (address != null ? !address.equals(customer.address) : customer.address != null) return false;
        if (email != null ? !email.equals(customer.email) : customer.email != null) return false;
        if (phone != null ? !phone.equals(customer.phone) : customer.phone != null) return false;
        return additional_info != null ? additional_info.equals(customer.additional_info) : customer.additional_info == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tenant_id != null ? tenant_id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (additional_info != null ? additional_info.hashCode() : 0);
        return result;
    }
}
