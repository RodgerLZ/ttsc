package org.example.ttsc.service.impl;

import org.example.ttsc.pojo.EUPictureResult;
import org.example.ttsc.service.PictureService;
import org.example.ttsc.utils.FtpUtil;
import org.example.ttsc.utils.IDUtil;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PictureServiceImpl implements PictureService {

    @Value("${ftp.host}")
    private String ftpHost;

    @Value("${ftp.port}")
    private Integer ftpPort;

    @Value("${ftp.username}")
    private String ftpUsername;

    @Value("${ftp.password}")
    private String ftpPassword;

    @Value("${ftp.basePath}")
    private String ftpBasePath;

    @Value("${static.base.url}")
    private String baseUrl;

    @Override
    public EUPictureResult uploadPicture(MultipartFile multipartFile) {

        try {
            String pictureName = IDUtil.genImageName() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."));
            String filepath = new DateTime().toString("/yyyy/MM/dd");

            if (FtpUtil.uploadFile(
                    ftpHost,
                    ftpPort,
                    ftpUsername,
                    ftpPassword,
                    ftpBasePath,
                    filepath,
                    pictureName,
                    multipartFile.getInputStream())) {
                // 上传文件成功
                return new EUPictureResult(0, baseUrl + ftpBasePath + filepath + "/" + pictureName, null);

            } else {
                // 上传文件失败
                return new EUPictureResult(1, null, "上传文件失败");
            }
        } catch (IOException e) {
            // 上传文件异常
            return new EUPictureResult(1, null, e.toString());
        }
    }
}
