package cn.bingoogolapple.sbn.repository;

import cn.bingoogolapple.sbn.model.Category;
import java.util.List;

public interface CategoryRepository {
    List<Category> findCategoryList();
}
