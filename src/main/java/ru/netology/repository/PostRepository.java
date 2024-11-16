package ru.netology.repository;

import ru.netology.model.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Stub
public class PostRepository {

  private final List<Post> posts = new ArrayList<>();


  public Optional<Post> getById(long id) {
    return Optional.empty();
  }

  public Post save(Post post) {
    Optional<Post> existingPostOpt = findById(post.getId());
    if (existingPostOpt.isPresent()) {
      Post existingPost = existingPostOpt.get();
      existingPost.setContent(post.getContent());
      return existingPost;
    } else {
      posts.add(post);
      return post;
    }
  }

  public void removeById(long id) {
    posts.removeIf(post -> post.getId() == id);
  }

  public List<Post> findAllByRemovedFalse() {
    return posts.stream()
            .filter(post -> !post.isRemoved())
            .toList();
  }
  public Optional<Post> findById(long id) {
    return posts.stream()
            .filter(post -> post.getId() == id)
            .findFirst();
  }
}
