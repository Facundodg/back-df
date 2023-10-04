package com.dim.Services.InterfaceServices;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileServices {

    public void save(MultipartFile file) throws Exception;

    public Resource load(String name) throws Exception;

}
