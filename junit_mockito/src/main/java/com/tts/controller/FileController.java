package com.tts.controller;

import com.tts.entiy.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by mike on 2016/11/3.
 */
@RestController
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String saveAuto(@RequestPart(value = "json") JsonPojo pojo, @RequestParam(value = "some-random") String random,
                           @RequestParam(value = "data", required = true) List<MultipartFile> files, @RequestBody Role role) {
        System.out.println("random:" + random);
        System.out.println("pojo:" + pojo.getJson());
        files.forEach(file -> System.out.println("filename: " + file.getOriginalFilename()));
        System.out.println("role" + role.toString());
        return "success";
    }

    static class JsonPojo {
        private String json;

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

    }
}
