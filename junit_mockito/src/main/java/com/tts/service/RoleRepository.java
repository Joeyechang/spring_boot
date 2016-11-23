package com.tts.service;

import com.tts.entiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by mike on 2016/11/5.
 */
//@RepositoryRestResource(path = "role")
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @RestResource(path = "nameStartsWith")
    Role findByNameStartsWith(@Param("name")String name);

    @RestResource(path = "findByNameIn")
    Role findByNameIn(@Param("name")String name);

    @RestResource(path = "findByNameIs")
    Role findByNameIs(@Param("name")String name);

    @RestResource(path = "findByNameEquals")
    Role findByNameEquals(@Param("name")String name);
}
