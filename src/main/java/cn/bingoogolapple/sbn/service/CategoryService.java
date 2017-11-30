package cn.bingoogolapple.sbn.service;

import cn.bingoogolapple.sbn.repository.CategoryRepository;
import cn.bingoogolapple.sbn.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findCategoryList() {
        return categoryRepository.findCategoryList();
    }
}