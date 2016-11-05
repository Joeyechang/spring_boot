package com.tts.controller;

import com.tts.entiy.Role;
import com.tts.service.RoleRepository;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by mike on 2016/11/5.
 */
@RestController
@RequestMapping("/mock")
public class MockMvcController {
    private final static Logger logger = LoggerFactory.getLogger(MockMvcController.class);
    private final static String SUCCESS = "success";

    @RequestMapping("/get")
    String get(@RequestParam String method) {
        logger.info("method: {}", method);
        return SUCCESS;
    }

    @RequestMapping(value = "/postByBean", method = RequestMethod.POST)
    String postByBean(Role role, String method) {
        logger.info("role: {};   method: {}", role.toString(), method);
        return SUCCESS;
    }

    @RequestMapping(value = "/postByJson", method = RequestMethod.POST)
    String postByJson(@RequestBody Role role, String method) {
        logger.info("role: {};   method: {}", role.toString(), method);
        return SUCCESS;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    String upload(@RequestPart(value = "role") Role role,
                  @RequestParam(value = "file", required = true) List<MultipartFile> files) {
        logger.info("role: {};", role.toString());
        files.stream().forEach(file -> {
            try {
                logger.info("filename: {}; originalFilename: {}; content: {}"
                        , file.getName()
                        , file.getOriginalFilename()
                        , IOUtils.toString(file.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return SUCCESS;
    }

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/rest/{id}")
    Role rest(@PathVariable Integer id){
        Role role = roleRepository.findOne(id);
        logger.info("Role Info: {}", role.toString());
        return role;
    }

    @RequestMapping("/all")
    String all( ){
        List<Role> roles = roleRepository.findAll();
        logger.info("Roles Size: {}", roles.size());
        return SUCCESS;
    }

}
