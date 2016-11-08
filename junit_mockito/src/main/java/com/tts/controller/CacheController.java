package com.tts.controller;

import com.tts.entiy.Role;
import com.tts.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mike on 2016/11/8.
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/put")
    Role put(Role role){
        return roleService.save(role);
    }

    @RequestMapping("/able")
    Role able(Role role){
        return roleService.findOne(role);
    }

    @RequestMapping("/evit")
    String evit(Integer id){
        roleService.remove(id);
        return "SUCCESS";
    }
}
