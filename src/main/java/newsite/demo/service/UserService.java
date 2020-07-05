package newsite.demo.service;

import newsite.demo.dto.UserDto;
import newsite.demo.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UserService {

    User save(User user);

    User registration(UserDto userDto);

    User getOne(Long id);

    User getLoginUser();

    List<User>getAll();

    User findUserById(Long id);

    void addAvatar(MultipartFile file);

    void delete(Long id);





}
