package com.dim.Services.ImplementServices;

import com.dim.Services.InterfaceServices.FileServices;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ImpFileServices implements FileServices {

    private final Path rootFolder = Paths.get("uploads");

    @Override
    public void save(MultipartFile file) throws Exception {

        Files.copy(file.getInputStream(), this.rootFolder.resolve(file.getOriginalFilename()));

    }

    @Override
    public Resource load(String name) throws Exception {

        Path file = rootFolder.resolve(name);
        Resource resource = new UrlResource(file.toUri());
        return resource;

    }

}
