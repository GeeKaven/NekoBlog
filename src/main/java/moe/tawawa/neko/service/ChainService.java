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
public class ChainService {

    private final PostRepository postRepository;

    @Autowired
    public ChainService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostChainHelper getPostChainHelper(Post post) {
        return new PostChainHelper(Lists.newArrayList(new PostVO(post)));
    }

    public PostChainHelper getPostChainHelper(List<Post> postList) {
        return new PostChainHelper(postList.stream().map(PostVO::new).collect(Collectors.toList()));
    }

    public class PostChainHelper extends BaseChainHelper<PostVO> {
        PostChainHelper(List<PostVO> objects) {
            super(objects);
        }

        // TODO: 类目

        // TODO: 用户

        // TODO: 标签
    }

    private class BaseChainHelper<T> {
        List<T> objects;

        BaseChainHelper() {

        }

        BaseChainHelper(List<T> objects) {
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
