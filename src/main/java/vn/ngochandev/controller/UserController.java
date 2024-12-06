package vn.ngochandev.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.ngochandev.controller.request.UserCreationRequest;
import vn.ngochandev.controller.request.UserUpdateRequest;
import vn.ngochandev.service.UserService;

@RequiredArgsConstructor
@RestController()
@RequestMapping("/user")
@Tag(name = "User Controller", description = "User management")
public class UserController {

    private final UserService userService;
    @PostMapping("/add")
    public ResponseEntity<Long> createUser(@RequestBody UserCreationRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.CREATED);

    }

    @PutMapping("/update")
    public ResponseEntity<Long> updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
        return new ResponseEntity<>(1L, HttpStatus.OK);
    }
}
