package vn.ngochandev.controller.request;

import lombok.Builder;
import lombok.Getter;
import vn.ngochandev.common.Gender;
import vn.ngochandev.common.UserStatus;
import vn.ngochandev.common.UserType;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class UserCreationRequest  implements Serializable {
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String username;
    private UserType type;
    private List<AddressRequest> addresses;

}
