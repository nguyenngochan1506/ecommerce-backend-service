package vn.ngochandev.service;

import vn.ngochandev.controller.request.ChangePasswordRequest;
import vn.ngochandev.controller.request.UserCreationRequest;
import vn.ngochandev.controller.request.UserUpdateRequest;
import vn.ngochandev.controller.response.UserResponse;

import java.util.List;

public interface UserService {
    Long createUser(UserCreationRequest request);
    List<UserResponse> getAllUsers();
    UserResponse getUserByUsername(String username);
    UserResponse getUserByEmail(String email);
    void changePassword(ChangePasswordRequest request);
    void updateUser(UserUpdateRequest request);
    void deleteUser(Long id);
}
