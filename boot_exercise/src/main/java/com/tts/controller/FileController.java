package com.tts.controller;

import com.tts.entiy.FeedFile;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.input.ReaderInputStream;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by : phoenix
 * Create Date: 2016/11/2
 */
@Controller
public class FileController {

    @RequestMapping("/file")
    public String file(){
        return "file";
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload( String filename) throws Exception {
        System.out.println(filename);
//        File feefile = feedFile.getFile();
//        File feedfile = new File("e:\\feedfile.txt");
//        FileUtils.writeByteArrayToFile(feedfile, file.getBytes());
//        FileUtils.copyFile(feedFile.getFile(), new File("e:\\feedfile2"));
        return "success";
    }

}
