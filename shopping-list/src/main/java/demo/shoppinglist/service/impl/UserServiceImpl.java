package demo.shoppinglist.service.impl;

import demo.shoppinglist.models.entity.User;
import demo.shoppinglist.models.service.UserRegisterServiceModel;
import demo.shoppinglist.repository.UserRepository;
import demo.shoppinglist.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegisterServiceModel userRegisterServiceModel) {
        userRepository.saveAndFlush(modelMapper
                .map(userRegisterServiceModel, User.class));
    }
}
