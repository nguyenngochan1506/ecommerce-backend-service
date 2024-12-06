package vn.ngochandev.controller.request;

import lombok.Getter;
import vn.ngochandev.common.Gender;
import vn.ngochandev.common.UserType;

import java.time.LocalDate;
import java.util.List;

@Getter
public class UserUpdateRequest {
    private Long id;
    private String fullName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private String phone;
    private String email;
    private String username;
    private UserType type;
    private List<AddressRequest> addresses;
}
