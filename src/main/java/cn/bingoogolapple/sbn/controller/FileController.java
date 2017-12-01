package cn.bingoogolapple.sbn.controller;

import cn.bingoogolapple.sbn.dto.ResultDto;
import cn.bingoogolapple.sbn.model.UploadToken;
import cn.bingoogolapple.sbn.util.WebUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.UUID;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:17/3/13 下午3:11
 * 描述:
 */
@Api(tags = "Upload", description = "上传管理")
@RequestMapping("api/file")
@RestController
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);
    public static final String UPLOAD_DIR = "upload-dir";

    @Autowired
    private ResourceLoader resourceLoader;

    @ApiOperation(value = "获取文件上传token")
    @GetMapping("token")
    public ResultDto token() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + 1);

        UploadToken uploadToken = new UploadToken();
        uploadToken.setToken(UUID.randomUUID().toString());
        uploadToken.setExpireTime(calendar.getTimeInMillis());

        WebUtil.applicationPut("uploadToken", uploadToken);
        return ResultDto.data(uploadToken);
    }

    @PostMapping("upload")
    public ResultDto upload(@RequestHeader(value = "uploadToken") String token, @RequestHeader(value = "expireTime") Long expireTime, HttpServletRequest request) {
        Object uploadTokenObject = WebUtil.applicationGet("uploadToken");
        if (uploadTokenObject == null) {
            return ResultDto.invalidToken();
        }
        UploadToken uploadToken = (UploadToken) uploadTokenObject;
        if (uploadToken.getToken().equals(token) && uploadToken.getExpireTime() == expireTime) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartHttpServletRequest.getFile("file");
            String originalFilename = file.getOriginalFilename();
            String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
            String newFilename = UUID.randomUUID().toString() + ext;
            LOGGER.debug("originalFilename: " + originalFilename);
            LOGGER.debug("newFilename: " + newFilename);

            try {
                Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR, newFilename));
                return ResultDto.data(newFilename);
            } catch (Exception e) {
                e.printStackTrace();
                return ResultDto.failure("文件上传失败");
            }
        } else {
            return ResultDto.invalidToken();
        }
    }

    @GetMapping("browse/{filename:.+}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        try {
            return ResponseEntity.ok(resourceLoader.getResource("file:" + Paths.get(UPLOAD_DIR, filename).toString()));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "测试返回的 data 字段为字符串")
    @GetMapping("stringData")
    public ResultDto stringData() {
        return ResultDto.data("返回的 data 字段为字符串");
    }

    @ApiOperation(value = "测试返回的数据为字符串")
    @GetMapping("string")
    public String string() {
        return "返回的数据为字符串";
    }
}