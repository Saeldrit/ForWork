package com.example.mimicat.service.startWork;

import com.example.mimicat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BeginningWorkServiceImpl implements BeginningWorkService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    //TODO @PostConstruct запустить!
    @Override
    public void startWorkCollectDatabase() {
        collectAdmin();
        collectUser();
        collectCats();
    }

    private void collectAdmin() {

    }

    private void collectUser() {

    }

    private void collectCats() {

    }
}
