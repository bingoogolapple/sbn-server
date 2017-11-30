package cn.bingoogolapple.sbn.repository;

import cn.bingoogolapple.sbn.model.Blog;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface BlogRepository {
    List<Blog> findBlogList(@Param("keyword") String keyword);
}
