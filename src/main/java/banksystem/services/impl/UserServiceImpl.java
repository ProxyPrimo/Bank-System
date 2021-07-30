package banksystem.services.impl;

import banksystem.data.entities.UserEntity;
import banksystem.data.services.UserServiceModel;
import banksystem.repositories.UserRepository;
import banksystem.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void register(UserServiceModel userServiceModel) {
        UserEntity user = modelMapper.map(userServiceModel, UserEntity.class);
        user.setClientNumber(UUID.randomUUID()
                .toString()
                .replace("-","")
                .substring(0,20)); // This will generate a random uuid string and get the first 20 characters
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.saveAndFlush(user);
    }

    @Override
    public UserEntity findByFirstNameAndMiddleNameAndLastName(String first, String middle, String last) {
        return userRepository.findByFirstNameAndMiddleNameAndLastName(first, middle, last);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
