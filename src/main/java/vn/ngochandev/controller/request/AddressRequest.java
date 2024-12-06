package vn.ngochandev.controller.request;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class AddressRequest implements Serializable {
    private String recipientName;
    private String recipientPhone;
    private String province;
    private String district;
    private String ward;
    private String detail;
}

