package cn.edu.bupt.dao.Cassandra;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class CassandraCluster {

    @Value("${cassandra.contactpoints}")
    private String contactpoints;

    @Value("${cassandra.port}")
    private int port;

    @Value("${cassandra.keyspace_name}")
    private String keyspaceName;

    private Cluster cluster;

    private Session session;

    private MappingManager mappingManager;


    /*
    * 连接到cassandra数据库集群，
    * 目前只需要url，其他具体配置
    * 使用默认配置。
    */
    @PostConstruct
    protected void init() {
        Cluster.Builder builder = Cluster.builder()
                .addContactPoints(contactpoints).withPort(port);
        cluster = builder.build();
        cluster.init();
        initSession();
    }

    private void initSession() {
        if (this.keyspaceName != null) {
            session = cluster.connect(keyspaceName);
        } else {
            session = cluster.connect();
        }
        mappingManager = new MappingManager(session);
    }

    public Session getSession() {
        if (session == null) {
            initSession();
        }
        return session;
    }

    public String getKeyspaceName() {
        return keyspaceName;
    }

    @PreDestroy
    public void close() {
        if (cluster != null) {
            cluster.close();
        }
    }

}
