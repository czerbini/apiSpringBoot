package zerbini.apispringboot.APISpringBoot.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import zerbini.apispringboot.APISpringBoot.model.User;
import zerbini.apispringboot.APISpringBoot.repository.UserRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }
    public User save(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {;
        userRepository.deleteById(id);
    }

    public User updateUserById(Long id, User updatedUser) {;
        User userToUpdate = userRepository.findUserById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        userToUpdate.setAge(updatedUser.getAge());
        userToUpdate.setName(updatedUser.getName());
        return userRepository.save(userToUpdate);
    }
}
