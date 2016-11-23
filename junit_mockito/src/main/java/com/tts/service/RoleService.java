package com.tts.service;

import com.tts.entiy.Role;

/**
 * Created by mike on 2016/11/2.
 */
public interface RoleService {

    public Role save(Role role);
    public void remove(Integer id);
    public Role findOne(Role role);

}
