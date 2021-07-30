package banksystem.repositories;

import banksystem.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByFirstNameAndMiddleNameAndLastName(String firstName, String middleName, String lastName);
    UserEntity findByEmail(String email);
}
