package cn.edu.bupt.dao;

import com.datastax.driver.core.utils.UUIDs;

import java.util.UUID;

/**
 * Created by CZX on 2018/3/23.
 */
public class ModelConstants {

    public static final UUID NULL_UUID = UUIDs.startOf(0);

    /**
     * Generic constants.
     */
    public static final String ID_PROPERTY = "id";
    public static final String USER_ID_PROPERTY = "user_id";
    public static final String TENANT_ID_PROPERTY = "tenant_id";
    public static final String CUSTOMER_ID_PROPERTY = "customer_id";
    public static final String ADDITIONAL_INFO_PROPERTY = "additional_info";

    /**
     * Cassandra contact constants.
     */
    public static final String ADDRESS_PROPERTY = "address";
    public static final String PHONE_PROPERTY = "phone";
    public static final String EMAIL_PROPERTY = "email";

    /**
     * Cassandra user constants.
     */
    public static final String USER_COLUMN_FAMILY_NAME = "user";
    public static final String USER_TENANT_ID_PROPERTY = TENANT_ID_PROPERTY;
    public static final String USER_CUSTOMER_ID_PROPERTY = CUSTOMER_ID_PROPERTY;
    public static final String USER_EMAIL_PROPERTY = "email";
    public static final String USER_AUTHORITY_PROPERTY = "authority";
    public static final String USER_NAME_PROPERTY = "name";
    public static final String USER_ADDITIONAL_INFO_PROPERTY = ADDITIONAL_INFO_PROPERTY;

//    public static final String USER_BY_EMAIL_COLUMN_FAMILY_NAME = "user_by_email";
//    public static final String USER_BY_TENANT_AND_SEARCH_TEXT_COLUMN_FAMILY_NAME = "user_by_tenant_and_search_text";
//    public static final String USER_BY_CUSTOMER_AND_SEARCH_TEXT_COLUMN_FAMILY_NAME = "user_by_customer_and_search_text";

    /**
     * Cassandra tenant constants.
     */
    public static final String TENANT_COLUMN_FAMILY_NAME = "tenant";
    public static final String TENANT_NAME_PROPERTY = "name";
    public static final String TENANT_ADDITIONAL_INFO_PROPERTY = ADDITIONAL_INFO_PROPERTY;

//    public static final String TENANT_BY_REGION_AND_SEARCH_TEXT_COLUMN_FAMILY_NAME = "tenant_by_region_and_search_text";

    /**
     * Cassandra customer constants.
     */
    public static final String CUSTOMER_COLUMN_FAMILY_NAME = "customer";
    public static final String CUSTOMER_TENANT_ID_PROPERTY = TENANT_ID_PROPERTY;
    public static final String CUSTOMER_NAME_PROPERTY = "name";
    public static final String CUSTOMER_ADDITIONAL_INFO_PROPERTY = ADDITIONAL_INFO_PROPERTY;

//    public static final String CUSTOMER_BY_TENANT_AND_SEARCH_TEXT_COLUMN_FAMILY_NAME = "customer_by_tenant_and_search_text";
//    public static final String CUSTOMER_BY_TENANT_AND_TITLE_VIEW_NAME = "customer_by_tenant_and_title";
}