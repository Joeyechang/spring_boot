package com.tts.service.dao;

import com.tts.entiy.Role;
import org.springframework.stereotype.Repository;

/**
 * Created by mike on 2016/11/2.
 */
@Repository
public interface RoleDAO {
    public Role fetchRole(Integer id);
    public void update(Role role);
}
