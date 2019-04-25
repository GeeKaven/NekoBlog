package moe.tawawa.neko.service;

import moe.tawawa.neko.model.domain.Category;
import moe.tawawa.neko.model.domain.Tag;
import moe.tawawa.neko.model.domain.User;
import moe.tawawa.neko.model.request.CategoryCreateRequest;
import moe.tawawa.neko.model.request.ListRequest;
import moe.tawawa.neko.model.request.TagCreateRequest;
import moe.tawawa.neko.model.response.data.CreateData;
import moe.tawawa.neko.model.response.data.ListData;
import moe.tawawa.neko.model.vo.CategoryVO;
import moe.tawawa.neko.model.vo.TagVO;
import moe.tawawa.neko.repository.CategoryRepository;
import moe.tawawa.neko.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public ListData<CategoryVO> queryAllCategory() {
        List<Category> catList = categoryRepository.findAll();
        ListData<CategoryVO> result = new ListData<>();
        result.setList(catList.stream().map(CategoryVO::new).collect(Collectors.toList()));
        result.setSize(catList.size());
        return result;
    }

    public ListData<TagVO> queryAllTag() {
        List<Tag> tagList = tagRepository.findAll();
        ListData<TagVO> result = new ListData<>();
        result.setList(tagList.stream().map(TagVO::new).collect(Collectors.toList()));
        result.setSize(tagList.size());
        return result;
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
        categoryRepository.save(category);
        return new CreateData(category.getId());
    }

    public CreateData createTag(TagCreateRequest request, User user) {
        Tag tag = new Tag();
        tag.setName(request.getName());
        tagRepository.save(tag);
        return new CreateData(tag.getId());
    }
}
