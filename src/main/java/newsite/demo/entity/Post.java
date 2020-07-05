package newsite.demo.entity;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;


@Data
@Entity
public class Post {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String text;

    private String city;

    private String price;

    private java.util.Date date;

    private String photoUrl;


    @Enumerated(EnumType.STRING)
    private Kind kind;

    public Post() {
    }

    public Post(String name, String text, String city, String price, java.util.Date date) {
        this.name = name;
        this.text = text;
        this.city = city;
        this.price = price;
        this.date = date;
    }

    public Post(String name, String text, String city, String price, java.util.Date date, Kind kind) {
        this.name = name;
        this.text = text;
        this.city = city;
        this.price = price;
        this.date = date;
        this.kind = kind;
    }

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User user;


}
