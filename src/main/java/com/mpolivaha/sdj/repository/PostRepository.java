package com.mpolivaha.sdj.repository;

import com.mpolivaha.sdj.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {

}
