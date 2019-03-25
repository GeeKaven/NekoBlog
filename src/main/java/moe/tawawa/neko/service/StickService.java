package moe.tawawa.neko.service;

import com.google.common.collect.Lists;
import moe.tawawa.neko.model.domain.Post;
import moe.tawawa.neko.model.vo.PostVO;
import moe.tawawa.neko.repository.PostRepository;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: GeeKaven
 * @date: 2019/3/20 20:51
 */
@Service
public class StickService {

    private final PostRepository postRepository;

    @Autowired
    public StickService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostStickHelper getPostStickHelper(Post post) {
        return new PostStickHelper(Lists.newArrayList(new PostVO(post)));
    }

    public PostStickHelper getPostStickHelper(List<Post> postList) {
        return new PostStickHelper(postList.stream().map(PostVO::new).collect(Collectors.toList()));
    }

    public class PostStickHelper extends BaseStickHelper<PostVO> {
        PostStickHelper(List<PostVO> objects) {
            super(objects);
        }

        // TODO: 类目

        // TODO: 用户

        // TODO: 标签
    }

    private class BaseStickHelper<T> {
        List<T> objects;

        BaseStickHelper() {

        }

        BaseStickHelper(List<T> objects) {
            this.objects = objects;
        }

        public List<T> getObjects() {
            return objects;
        }

        public T getObject() {
            if (CollectionUtils.isEmpty(objects)) {
                return null;
            }
            return objects.get(0);
        }

    }
}
