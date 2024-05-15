package vso.project.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vso.project.course.domain.User;
import vso.project.course.dtos.UserDTO;
import vso.project.course.repositories.UserRepository;
import vso.project.course.services.exception.ObjectNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
     @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(String id) {
        Optional<User> user = userRepository.findById(id);

        if(user == null){
            throw new ObjectNotFoundException("Object not found");
        }

        return user;
    }

    public User insert(User obj) {
        return userRepository.insert(obj);
    }

    public void detele(String id) {
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        Optional<User> newObj = this.findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj.get());
    }

    private void updateData(Optional<User> newObj, User obj) {
       newObj.get().setName(obj.getName());
       newObj.get().setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDTO) {
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}
