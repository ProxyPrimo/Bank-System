package banksystem.services;

import banksystem.data.entities.UserEntity;
import banksystem.data.services.UserServiceModel;

public interface UserService {
    void register(UserServiceModel userServiceModel);
    UserEntity findByFirstNameAndMiddleNameAndLastName(String first, String middle, String last);

    UserEntity findByEmail(String email);
}
