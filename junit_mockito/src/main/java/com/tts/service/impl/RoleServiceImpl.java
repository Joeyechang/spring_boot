package com.tts.service.impl;

import com.tts.entiy.Role;
import com.tts.service.RoleRepository;
import com.tts.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by mike on 2016/11/8.
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;
    @Override
    @CachePut(value = "role", key = "#role.id")
    public Role save(Role role) {
        Role r = roleRepository.save(role);
        System.out.println("为id,key为" + r.getId() + "数据做了缓存");
        return r;
    }

    @Override
    @CacheEvict(value = "role")
    public void remove(Integer id) {
        System.out.println("删除了id, key为" + id +"的数据缓存");
        roleRepository.delete(id);
    }

    @Override
    @Cacheable(value="role", key="#role.id")
    public Role findOne(Role role) {
        Role r = roleRepository.findOne(role.getId());
        System.out.println("为id,key为" + r.getId() + "数据做了缓存");
        return r;
    }
}
