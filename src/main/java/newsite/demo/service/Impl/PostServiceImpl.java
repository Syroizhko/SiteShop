package newsite.demo.service.Impl;


import newsite.demo.entity.Kind;
import newsite.demo.entity.Post;
import newsite.demo.repository.PostRepository;
import newsite.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Value("${file.path}")
    private String path;


    @Autowired
    private PostRepository postRepository;


    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }


    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getAllByUserId(Long Id) {
        return  postRepository.findAllByUserId(Id);
    }

    @Override
    public Post getOne(Long id) {
        return postRepository.getOne(id);
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post addPost(String name, String text, String city, String price, Date date, MultipartFile file,String kind) {
        Post post=new Post(name,text,city,price,date);
        if (kind.equals("Electronic"))post.setKind(Kind.Electronic);
        else if(kind.equals("Car"))post.setKind(Kind.Car);
        else if (kind.equals("Animal"))post.setKind(Kind.Animal);
        else if (kind.equals("Phone"))post.setKind(Kind.Phone);
        else {
            post.setKind(Kind.Without);
        }
        if(file!=null&&!file.isEmpty()) {
            String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            String fileName = UUID.randomUUID().toString()+extention;
            try {
                file.transferTo(new File(path+fileName));
                post.setPhotoUrl(fileName);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }else {
            post.setPhotoUrl("Post.png");
        }
        return save(post);

    }

    @Override
    public List<Post> getByKind(Kind kind) {
        return postRepository.findPostsByKind(kind);
    }



    @Override
    public List<Post> getByUsername(String username) {
        return postRepository.findPostsByUser_Username(username);
    }
}
