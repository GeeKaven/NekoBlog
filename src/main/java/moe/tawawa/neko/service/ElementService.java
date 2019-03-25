package moe.tawawa.neko.service;

import moe.tawawa.neko.model.domain.Category;
import moe.tawawa.neko.model.domain.Tag;
import moe.tawawa.neko.model.domain.User;
import moe.tawawa.neko.model.request.CategoryCreateRequest;
import moe.tawawa.neko.model.request.TagCreateRequest;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.repository.CategoryRepository;
import moe.tawawa.neko.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: GeeKaven
 * @date: 2019/3/22 23:00
 */
@Service
public class ElementService {

    private final CategoryRepository categoryRepository;

    private final TagRepository tagRepository;

    @Autowired
    public ElementService(CategoryRepository categoryRepository, TagRepository tagRepository) {
        this.categoryRepository = categoryRepository;
        this.tagRepository = tagRepository;
    }

    /**
     * 创建类目
     * @param request 类目信息
     * @param user 用户
     * @return 创建Id
     */
    public CreateData createCategory(CategoryCreateRequest request, User user) {
        Category category = new Category();
        category.setName(request.getName());
        category.setStatus(Category.STATUS_NORMAL);
        category.setUserId(user.getId());
        categoryRepository.save(category);
        return new CreateData(category.getId());
    }

    public CreateData createTag(TagCreateRequest request, User user) {
        Tag tag = new Tag();
        tag.setName(request.getName());
        tag.setStatus(Tag.STATUS_NORMAL);
        tagRepository.save(tag);
        return new CreateData(tag.getId());
    }
}
