package backend.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@XmlRootElement
public class UserDto {

    String userName;
    String email;
    String address;
    public UserDto(String userName, String email,String address) {
        this.userName = userName;
        this.email = email;
        this.address=address;
    }

    public UserDto() {
    }
}
