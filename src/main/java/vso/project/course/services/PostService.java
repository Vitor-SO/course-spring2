package vso.project.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vso.project.course.domain.Post;
import vso.project.course.domain.User;
import vso.project.course.dtos.UserDTO;
import vso.project.course.repositories.PostRepository;
import vso.project.course.repositories.UserRepository;
import vso.project.course.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
     @Autowired
    private PostRepository postRespository;


    public Optional<Post> findById(String id) {
        Optional<Post> post = postRespository.findById(id);

        if(post.isEmpty()){
            throw new ObjectNotFoundException("Object not found");
        }

        return post;
    }
}
