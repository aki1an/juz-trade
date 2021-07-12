package com.akilan.juztrade.helpers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class FileHelper {
    public String path;
    public boolean writeFile(MultipartFile img, String name) {

        try {

            path = new ClassPathResource("static/image").getFile().getAbsolutePath();

            Files.copy(
                    img.getInputStream(),
                    Paths.get(path+File.separator+img.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }
}
