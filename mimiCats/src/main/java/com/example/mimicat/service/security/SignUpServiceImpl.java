package com.example.mimicat.service.security;

import com.example.mimicat.model.User;
import com.example.mimicat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void signUpUser(User user) {
        userRepository.save(User.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(User.Role.USER)
                .login(user.getLogin())
                .hashPassword(passwordEncoder.encode(user.getHashPassword()))
                .build());
    }
}
