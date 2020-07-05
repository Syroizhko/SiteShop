package newsite.demo.service.Impl;

import newsite.demo.dto.UserDto;
import newsite.demo.entity.Role;
import newsite.demo.entity.User;
import newsite.demo.repository.UserRepository;
import newsite.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("userDetailsService")
public  class UserServiceImpl implements UserService,UserDetailsService {

    @Value("D/images/")
    private String path;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder encoder;


    @Override
    public User save(User user){
        return userRepository.save(user);
    }

    public User registration(UserDto userDto){

        User user =new User();
        user.setUsername(userDto.getUsername());
        if(userDto.getUsername().equals("admin"))user.setRole(Role.ADMIN);
        else user.setRole(Role.USER);
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setMale(userDto.getMale());
        user.setPhone(userDto.getPhone());
        user.setCountry(userDto.getCountry());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setPhotoUrl("Avatar.png");

    return save(user);
    }

    @Override
    public User getOne(Long id){
        return userRepository.getOne(id);
    }

    @Override
    public User getLoginUser() {
        return userRepository.findByUsername(getUserName());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            //LOGGER.error("No user found with username: " + name);
            throw new UsernameNotFoundException("No user found with email: " + username);
        }
        ArrayList<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+user.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                simpleGrantedAuthorities
        );
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }



    @Override
    public User findUserById(Long id) {
     return userRepository.findUserById(id);
    }

    public String getUserName() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = ((UserDetails) principal).getUsername();
        return username;
    }

    @Override
    public void addAvatar(MultipartFile file) {
        User user=userRepository.findByUsername(getUserName());
        if(file!=null&&!file.isEmpty()) {
            String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String fileName = UUID.randomUUID().toString()+extention;
            try {
                file.transferTo(new File(path+fileName));
                user.setPhotoUrl(fileName);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
