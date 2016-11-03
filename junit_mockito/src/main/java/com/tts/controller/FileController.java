package com.tts.controller;

import com.tts.entiy.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by mike on 2016/11/3.
 */
@RestController
public class FileController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String saveAuto(@RequestPart(value = "json") Role role, @RequestParam(value = "some-random") String random,
                           @RequestParam MultipartFile file) {

        return "success";
    }
}
