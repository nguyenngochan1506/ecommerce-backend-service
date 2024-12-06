package vn.ngochandev.controller.response;

import lombok.Getter;

@Getter
public class UserResponse {
    private String recipientName;
    private String recipientPhone;
    private String province;
    private String district;
    private String ward;
    private String detail;
}
