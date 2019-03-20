package moe.tawawa.neko.service;

import moe.tawawa.neko.model.domain.Post;
import moe.tawawa.neko.model.domain.User;
import moe.tawawa.neko.model.request.CreatePostRequest;
import moe.tawawa.neko.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: GeeKaven
 * @date: 2019/3/18 8:10
 */
@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(CreatePostRequest request, User user) {
        return null;
    }

    public void deletePost() {

    }
}
