package ro.utcn.project.dto;
import java.util.List;

public class UserDto {

    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;

    private String errorMessage;

    public UserDto() { }


    public UserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UserDto( String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }
    public UserDto( String name, String surname, String username, String email, String password) {

        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }
    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }*/

    @Override
    public String toString() {
        return "UserDto{" +
                "name='" + name + '\'' +
                + '\'' +
                ", pho"+ '}';
    }
}
