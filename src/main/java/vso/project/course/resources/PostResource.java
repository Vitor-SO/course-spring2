package vso.project.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import vso.project.course.domain.Post;
import vso.project.course.domain.User;
import vso.project.course.dtos.UserDTO;
import vso.project.course.services.PostService;
import vso.project.course.services.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/posts")
public class PostResource {
    @Autowired
    private PostService postService;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Optional<Post> post = postService.findById(id);

        return ResponseEntity.ok().body(post.get());
    }

}
