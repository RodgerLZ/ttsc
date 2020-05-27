package org.example.ttsc.controller;

import org.example.ttsc.pojo.EUPictureResult;
import org.example.ttsc.service.PictureService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
public class PictureController {

    @Resource
    private PictureService pictureService;

    @ResponseBody
    @RequestMapping(value = "/pic/upload", method = RequestMethod.POST)
    public EUPictureResult uploadPicture(MultipartFile uploadFile) {
        return pictureService.uploadPicture(uploadFile);
    }
}
