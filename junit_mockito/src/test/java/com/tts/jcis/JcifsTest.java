package com.tts.jcis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFileInputStream;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import jcifs.smb.SmbFile;
import jcifs.smb.SmbNamedPipe;
import sun.net.www.protocol.http.ntlm.NTLMAuthentication;

public class JcifsTest {
    private static final String REMOTE_CONFIG = "smb://phoenix:111111@10.0.0.31/FeedFile/files/";
    private static final String REMOTE_DEOMAIN = "smb://10.0.0.31/FeedFile/files/";

    @Test
    public void testRead() {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "phoenix", "111111");
        readByPipe(REMOTE_DEOMAIN + "wc2.txt", auth);
        readBySmbFile(REMOTE_DEOMAIN + "wc2.txt", auth);
    }

    public void readByPipe(final String url, NtlmPasswordAuthentication auth){
        try {
            SmbNamedPipe pipe = new SmbNamedPipe(url, SmbNamedPipe.PIPE_TYPE_RDWR | SmbNamedPipe.PIPE_TYPE_CALL, auth);
            BufferedReader reader = new BufferedReader(new InputStreamReader(pipe.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void readBySmbFile(final String url, NtlmPasswordAuthentication auth){
        try {
            SmbFile smbFile = new SmbFile(url, auth);
            BufferedReader reader = new BufferedReader(new InputStreamReader(smbFile.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrite() {
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", "phoenix", "111111");
        writeByPipe("e:\\test.txt", REMOTE_DEOMAIN, auth);
    }

    public void writeByPipe(final String srcFilepath, final String url, NtlmPasswordAuthentication auth){
        Path path = Paths.get(srcFilepath);
        try (InputStream is = Files.newInputStream(path)) {
            SmbNamedPipe pipe = new SmbNamedPipe(url + path.getFileName(), SmbNamedPipe.PIPE_TYPE_RDWR | SmbNamedPipe.PIPE_TYPE_CALL, auth);
            OutputStream os = pipe.getOutputStream();

            int n = 0;
            byte[] buffer = new byte[2048];
            while (-1 != (n = is.read(buffer))) {
                os.write(buffer, 0, n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testFilenames() {
        getFilenamesFromSmb("smb://phoenix:111111@10.0.0.31/FeedFile/files/").forEach(System.out::println);

        getFilenamesFromSmb("smb://10.0.0.31/FeedFile/files/", "phoenix", "111111").forEach(System.out::println);
    }

    /**
     * 读取共享文件夹中的所有文件名或文件夹名
     * @param remoteUrl
     * @return
     */
    public static List<String> getFilenamesFromSmb(final String remoteUrl) {
        SmbFile file = null;
        SmbFile[] files = null;
        try {
            file = new SmbFile(remoteUrl);
            files = file.listFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> filenames = Stream.of(files).map(SmbFile::getName).collect(Collectors.toList());
        return filenames;
    }

    public static List<String> getFilenamesFromSmb(final String remoteUrl, String username, String password) {
        SmbFile file = null;
        SmbFile[] files = null;
        try {
            NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication("", username, password);
            file = new SmbFile(remoteUrl, auth);
            files = file.listFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> filenames = Stream.of(files).map(SmbFile::getName).collect(Collectors.toList());
        return filenames;
    }

}
