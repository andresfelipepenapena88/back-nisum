package co.com.nisum.user.userRegistry.service;

import co.com.nisum.user.userRegistry.utils.exceptions.BusinessException;
import co.com.nisum.user.userRegistry.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User saveUser(User user) throws BusinessException;
}
