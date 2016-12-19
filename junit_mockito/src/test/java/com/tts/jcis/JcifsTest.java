package com.tts.jcis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbNamedPipe;

public class JcifsTest {
    private static final String REMOTE_CONFIG = "smb://RP:123456@120.0.0.00/share/";

    @Test
    public void testRead() {
        SmbNamedPipe pipe;
        try {
            pipe = new SmbNamedPipe(REMOTE_CONFIG + "test.log", SmbNamedPipe.PIPE_TYPE_RDWR | SmbNamedPipe.PIPE_TYPE_CALL);
            InputStream in = pipe.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while ((line = reader.readLine()) != null)
                System.out.println(line);
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrite() {
        Path path = Paths.get("e:\\feedfile.txt");
        try (InputStream is = Files.newInputStream(path)) {
            SmbNamedPipe pipe = new SmbNamedPipe(REMOTE_CONFIG + "feedfile.txt", SmbNamedPipe.PIPE_TYPE_RDWR | SmbNamedPipe.PIPE_TYPE_CALL);
            OutputStream os = pipe.getOutputStream();
            IOUtils.copy(is, os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFilenames() {
        getFilenamesFromSmb(REMOTE_CONFIG).forEach(System.out::println);
    }

    public static List<String> getFilenamesFromSmb(final String remoteMachine) {
        SmbFile file = null;
        SmbFile[] files = null;
        try {
            file = new SmbFile(remoteMachine);
            files = file.listFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> filenames = Stream.of(files).map(SmbFile::getName).collect(Collectors.toList());
        return filenames;
    }
}
