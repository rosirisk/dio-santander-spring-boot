package br.com.cursos.ti.service.impl;


import br.com.cursos.ti.model.StackEnum;
import br.com.cursos.ti.model.User;
import br.com.cursos.ti.repository.UserRepository;
import br.com.cursos.ti.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<User> findByStack(StackEnum stack) {
        return repository.findAllByStack(stack);
    }

    @Override
    public User create(User userToCreate) {
        if (repository.existsByUsername(userToCreate.getUsername())) {
            throw new IllegalArgumentException("This username already exists.");
        }
        return repository.save(userToCreate);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public User update(Long id, User user) {
        Optional<User> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new IllegalArgumentException("Users not exists.");
        }
        user.setId(id);
        repository.save(user);
        return user;
    }
}
