package vso.project.course.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vso.project.course.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
