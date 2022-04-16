package com.hsob.repository;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @author carlos
 */
public abstract class DAO {

    @Autowired
//    @Qualifier(Anon.BASE_MONGO_CONECTION)
    protected MongoTemplate hsobdb;

    protected final Log logger = LogFactory.getLog(getClass());
}

