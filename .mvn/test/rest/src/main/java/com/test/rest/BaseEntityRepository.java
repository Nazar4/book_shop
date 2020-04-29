package com.test.rest;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.io.Serializable;

@RestResource(exported = false)
public interface BaseEntityRepository<T, PK extends Serializable> extends Repository<T, PK> {

    /**
     * Retrieves an entity by its UID.
     * 
     * @param uid
     * @return
     */
    T findByUidEquals(@Param("uid") final String uid);
}
