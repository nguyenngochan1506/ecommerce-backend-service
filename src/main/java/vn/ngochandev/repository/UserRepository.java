package vn.ngochandev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.ngochandev.model.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
