package newsite.demo.dto;


import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String username;

    private String surname;

    private String email;

    private String male;

    private String phone;

    private String country;

    private String password;


    private String role;

    private String photoUrl;


    public UserDto() {
    }


    public UserDto(Long id, String username, String surname, String email, String male, String phone, String country, String password, String role, String photoUrl) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.male = male;
        this.phone = phone;
        this.country = country;
        this.password = password;
        this.role = role;
        this.photoUrl = photoUrl;
    }
}