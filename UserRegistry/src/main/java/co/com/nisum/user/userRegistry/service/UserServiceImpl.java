package co.com.nisum.user.userRegistry.service;

import co.com.nisum.user.userRegistry.config.TokenUtils;
import co.com.nisum.user.userRegistry.utils.Constants;
import co.com.nisum.user.userRegistry.utils.exceptions.BusinessException;
import co.com.nisum.user.userRegistry.model.User;
import co.com.nisum.user.userRegistry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Value("${password-regex}")
    private String passwordRegex;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) throws BusinessException {
        this.validateFields(user);
        Date now = new Date(System.currentTimeMillis());
        user.setCreated(now);
        user.setLastLogin(now);
        user.setToken(TokenUtils.createToken(user.getName(), user.getEmail()));
        user.setPassword(encodePassword(user.getPassword()));
        user.setActive(true);
        return userRepository.save(user);

    }

    private void validateFields(User user) throws BusinessException {
        if(!fieldMatchesPattern(user.getPassword(), passwordRegex)) {
            throw new BusinessException(Constants.passworFormatError);
        }
        if(!fieldMatchesPattern(user.getEmail(), Constants.emailRegex)) {
            throw new BusinessException(Constants.emailFormatError);
        }
        if (userRepository.findByEmail(user.getEmail()).size() > 0) {
            throw new BusinessException(Constants.emailAlreadyExistError);
        }
    }

    private boolean fieldMatchesPattern(String field, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher match = pattern.matcher(field);
        return match.matches();
    }

    private String encodePassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
    }

}
