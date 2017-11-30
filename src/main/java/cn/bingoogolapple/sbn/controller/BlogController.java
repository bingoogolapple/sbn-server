package cn.bingoogolapple.sbn.controller;

import cn.bingoogolapple.sbn.dto.ResultDto;
import cn.bingoogolapple.sbn.model.Blog;
import cn.bingoogolapple.sbn.service.BlogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Blog", description = "博客管理")
@RequestMapping("api/blogs")
@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @ApiOperation(value = "查询博客列表")
    @ApiImplicitParam(name = "keyword", value = "博客标题或内容", paramType = "query", dataType = "string")
    @GetMapping
    public ResultDto findBlogList(@RequestParam(value = "keyword", required = false) String keyword) {
        return ResultDto.data(blogService.findBlogList(keyword));
    }

    @ApiOperation(notes = "添加博客", value = "添加博客")
    @ApiImplicitParam(name = "blog", value = "博客实体", required = true, paramType = "body", dataType = "Blog")
    @PostMapping
    public ResultDto create(@RequestBody Blog blog) {
        return ResultDto.data(blog);
    }
}