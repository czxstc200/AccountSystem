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
@Table(name = USER_COLUMN_FAMILY_NAME)
public class User implements BaseEntity {


    @PartitionKey(value = 0)
    @Column(name = ID_PROPERTY)
    private UUID id;

    @PartitionKey(value = 1)
    @Column(name = USER_TENANT_ID_PROPERTY)
    private UUID tenant_id;

    @PartitionKey(value = 2)
    @Column(name = USER_CUSTOMER_ID_PROPERTY)
    private UUID customer_id;

    @PartitionKey(value = 3)
    @Column(name = USER_AUTHORITY_PROPERTY)
    private String authority;

    @Column(name = USER_NAME_PROPERTY)
    private String name;

    @Column(name = USER_EMAIL_PROPERTY)
    private String email;

    @Column(name = USER_ADDITIONAL_INFO_PROPERTY)
    private String additional_info;

    public User() {
        super();
    }

    public User(User user) {
        this.id = user.getId();
        this.tenant_id = user.getTenant_id();
        this.customer_id = user.getCustomer_id();
        this.name = user.getName();
        this.authority = user.getAuthority();
        this.email = user.getEmail();
        this.additional_info = user.getAdditional_info();
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

    public UUID getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(UUID customer_id) {
        this.customer_id = customer_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tenant_id=" + tenant_id +
                ", customer_id=" + customer_id +
                ", name='" + name + '\'' +
                ", authority='" + authority + '\'' +
                ", email='" + email + '\'' +
                ", additional_info='" + additional_info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (tenant_id != null ? !tenant_id.equals(user.tenant_id) : user.tenant_id != null) return false;
        if (customer_id != null ? !customer_id.equals(user.customer_id) : user.customer_id != null) return false;
        if (authority != null ? !authority.equals(user.authority) : user.authority != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return additional_info != null ? additional_info.equals(user.additional_info) : user.additional_info == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (tenant_id != null ? tenant_id.hashCode() : 0);
        result = 31 * result + (customer_id != null ? customer_id.hashCode() : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (additional_info != null ? additional_info.hashCode() : 0);
        return result;
    }
}
