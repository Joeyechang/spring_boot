package com.tts.service;

import com.tts.entiy.Role;
import com.tts.service.dao.RoleDAO;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by mike on 2016/11/2.
 */
public class RoleService {
//    @Autowired
    private final RoleDAO roleDAO;

    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    public boolean update(Integer id, String name){
        Role role = roleDAO.fetchRole(id);
        if (role != null){
            Role updateRole = new Role(id, name);
            roleDAO.update(updateRole);
            return true;
        }
        return false;
    }
}
