package vn.ngochandev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ngochandev.model.AddressEntity;
@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
    AddressEntity findByUserId(Long userId);
    AddressEntity findByUserIdAndRecipientPhone(Long userId, String recipientPhone);
}
