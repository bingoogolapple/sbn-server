package cn.bingoogolapple.sbn.service;

import cn.bingoogolapple.sbn.model.Blog;
import cn.bingoogolapple.sbn.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public List<Blog> findBlogList(String keyword) {
        return blogRepository.findBlogList(keyword);
    }
}