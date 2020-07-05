package newsite.demo.dto;

import lombok.Data;

@Data
public class PostDto {

    private Long id;

    private String name;

    private String text;

    private String city;

    private  String price;

    private String photoUrl;

    private String kind;

    public PostDto() {
    }

}
