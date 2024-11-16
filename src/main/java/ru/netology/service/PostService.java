package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

  @Autowired
  private final PostRepository repository;

  public PostService(PostRepository repository) {
    this.repository = repository;
  }

  public List<Post> all() {
    return repository.findAllByRemovedFalse();
  }

  public Post getById(long id) {
    return repository.getById(id).orElseThrow(NotFoundException::new);
  }

  public Post save(Post post) {
    return repository.save(post);
  }


  public void removeById(long id) {
    Post post = repository.findById(id).orElseThrow(() -> new NotFoundException("Post not found with id: " + id));
    post.setRemoved(true);
    repository.save(post);
  }

  public void removePostById(Long id) {
    Post post = repository.findById(id)
            .orElseThrow(() -> new NotFoundException("Post not found with id: " + id));
    post.setRemoved(true);
    repository.save(post);
  }

}

