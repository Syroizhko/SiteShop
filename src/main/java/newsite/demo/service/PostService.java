package newsite.demo.service;

import newsite.demo.entity.Kind;
import newsite.demo.entity.Post;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface PostService {

    Post save(Post post);

    List<Post>getAll();

    List<Post>getAllByUserId(Long Id);

    Post addPost(String name, String text, String city, String price, Date date, MultipartFile file,String kind);

    Post getOne(Long postid);

    void delete(Long id);

    Post getPostById(Long id);

    List<Post>getByKind(Kind kind);

    List<Post>getByUsername(String username);




}
