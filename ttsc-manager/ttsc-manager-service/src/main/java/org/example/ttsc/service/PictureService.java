package org.example.ttsc.service;

import org.example.ttsc.pojo.EUPictureResult;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    EUPictureResult uploadPicture(MultipartFile multipartFile);
}
