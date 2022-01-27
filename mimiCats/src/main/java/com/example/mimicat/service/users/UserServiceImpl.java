package com.example.mimicat.service.users;

import com.example.mimicat.model.User;
import com.example.mimicat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        boolean isCheck = user.getRole() == User.Role.ADMIN;

        if (isCheck) {
            writeRole(user, User.Role.ADMIN);
        } else {
            writeRole(user, User.Role.USER);
        }
    }

    private void writeRole(User user, User.Role role) {
        userRepository.save(User.builder()
                .role(role)
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .hashPassword(passwordEncoder.encode(
                        user.getHashPassword()))
                .build());
    }

    @Override
    public void updateUser(Integer id, User user) {
        userRepository.save(getById(id)
                .toBuilder()
                .userId(id)
                .role(user.getRole())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .hashPassword(passwordEncoder.encode(
                        user.getHashPassword()))
                .build());
    }

    @Override
    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
