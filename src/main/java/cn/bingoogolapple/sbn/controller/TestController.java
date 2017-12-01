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
@Api(tags = "Test", description = "测试")
@RequestMapping("api/test")
@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

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