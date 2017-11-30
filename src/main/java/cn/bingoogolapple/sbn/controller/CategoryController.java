package cn.bingoogolapple.sbn.controller;

import cn.bingoogolapple.sbn.dto.ResultDto;
import cn.bingoogolapple.sbn.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:17/3/13 下午3:11
 * 描述:
 */
@Api(tags = "Category", description = "博客分类管理")
@RequestMapping("api/categorys")
@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取博客分类列表")
    @GetMapping
    public ResultDto getCategoryList() {
        return ResultDto.data(categoryService.findCategoryList());
    }
}