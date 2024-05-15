package vso.project.course.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import vso.project.course.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
