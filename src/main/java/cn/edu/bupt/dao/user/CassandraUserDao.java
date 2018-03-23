package cn.edu.bupt.dao.user;

import cn.edu.bupt.dao.Cassandra.CassandraAbstractModelDao;
import cn.edu.bupt.dao.ModelConstants;
import cn.edu.bupt.data.User;
import com.datastax.driver.core.querybuilder.Select;
import org.springframework.stereotype.Component;

import static com.datastax.driver.core.querybuilder.QueryBuilder.eq;
import static com.datastax.driver.core.querybuilder.QueryBuilder.select;

/**
 * Created by CZX on 2018/3/23.
 */
@Component
public class CassandraUserDao extends CassandraAbstractModelDao<User> implements UserDao{

    @Override
    protected Class<User> getColumnFamilyClass() {
        return User.class;
    }

    @Override
    protected String getColumnFamilyName() {
        return ModelConstants.USER_COLUMN_FAMILY_NAME;
    }

    @Override
    public User findByEmail(String email) {
        Select.Where query = select().from(ModelConstants.USER_BY_EMAIL_COLUMN_FAMILY_NAME).where(eq(ModelConstants.USER_EMAIL_PROPERTY, email));
        User user = findOneByStatement(query);
        return user;
    }


}
