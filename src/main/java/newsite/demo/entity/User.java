package newsite.demo.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String surname;

    private String email;

    private String male;

    private String phone;

    private String country;

    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> postList;


    private String photoUrl;


    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public String toString() {
        return " "+username+" ";
    }

}
