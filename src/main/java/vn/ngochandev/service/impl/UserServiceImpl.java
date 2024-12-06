package vn.ngochandev.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.ngochandev.common.UserStatus;
import vn.ngochandev.controller.request.ChangePasswordRequest;
import vn.ngochandev.controller.request.UserCreationRequest;
import vn.ngochandev.controller.request.UserUpdateRequest;
import vn.ngochandev.controller.response.UserResponse;
import vn.ngochandev.exception.ResourceNotFoundException;
import vn.ngochandev.model.AddressEntity;
import vn.ngochandev.model.UserEntity;
import vn.ngochandev.repository.AddressRepository;
import vn.ngochandev.repository.UserRepository;
import vn.ngochandev.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j(topic = "USER-SERVICE")
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createUser(UserCreationRequest request) {

        UserEntity user = new UserEntity();
        user.setFullName(request.getFullName());
        user.setGender(request.getGender());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setType(request.getType());
        user.setStatus(UserStatus.NONE);
        userRepository.save(user);

        if (user.getId() != null){
            log.info("Create new user with id: {}", user.getId());
            List<AddressEntity> addresses = new ArrayList<>();
            request.getAddresses().forEach(req ->{
                AddressEntity address = new AddressEntity();
                address.setRecipientName(req.getRecipientName());
                address.setRecipientPhone(req.getRecipientPhone());
                address.setProvince(req.getProvince());
                address.setDistrict(req.getDistrict());
                address.setWard(req.getWard());
                address.setDetail(req.getDetail());
                address.setUserId(user.getId());
                addresses.add(address);
            });
            addressRepository.saveAll(addresses);
            log.info("Create new address with id: {}", addresses);
        }

        return user.getId();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateRequest request) {
        //get usser by id
        UserEntity user = getUserById(request.getId());

        //update user
        user.setFullName(request.getFullName());
        user.setGender(request.getGender());
        user.setDateOfBirth(request.getDateOfBirth());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setType(request.getType());
        userRepository.save(user);

        //update address
        List<AddressEntity> addresses = new ArrayList<>();
        request.getAddresses().forEach(req ->{
            AddressEntity address = addressRepository.findByUserIdAndRecipientPhone(user.getId(), req.getRecipientPhone());
            if(address == null){
                address = new AddressEntity();
                address.setUserId(user.getId());
            }
            address.setRecipientName(req.getRecipientName());
            address.setRecipientPhone(req.getRecipientPhone());
            address.setProvince(req.getProvince());
            address.setDistrict(req.getDistrict());
            address.setWard(req.getWard());
            address.setDetail(req.getDetail());
            addresses.add(address);
        });
        addressRepository.saveAll(addresses);
    }
    @Override
    public List<UserResponse> getAllUsers() {
        return null;
    }



    @Override
    public UserResponse getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return null;
    }

    @Override
    public void changePassword(ChangePasswordRequest request) {

    }



    @Override
    public void deleteUser(Long id) {

    }
    private UserEntity getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
