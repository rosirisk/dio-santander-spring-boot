package br.com.cursos.ti.service;

import br.com.cursos.ti.model.StackEnum;
import br.com.cursos.ti.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User findByUsername(String username);

    List<User> findByStack(StackEnum stack);

    User create(User userToCreate);

    void delete(Long id);

    User update(Long id, User user);
}
