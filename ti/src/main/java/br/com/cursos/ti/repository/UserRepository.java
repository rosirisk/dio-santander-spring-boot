package br.com.cursos.ti.repository;


import br.com.cursos.ti.model.StackEnum;
import br.com.cursos.ti.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAllByStack(StackEnum stack);
    Optional<User> findByName(String name);

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);
}
