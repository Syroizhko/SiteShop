package newsite.demo.repository;

import newsite.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

      User findByUsername(String name);

      User findByEmail (String email);

      User findUserById(Long id);



}
