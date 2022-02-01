package com.example.mimicat.start_work;

import com.example.mimicat.model.Cat;
import com.example.mimicat.model.User;
import com.example.mimicat.repository.CatRepository;
import com.example.mimicat.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class BeginWork implements BeginWorkService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final CatRepository catRepository;

    @PostConstruct
    @Override
    public void startWork() {
        collectAdmin();
        collectCats();
    }

    private void collectCats() {
        CatStorage catStorage = new CatStorage();
        int length = catStorage.arrayName.length;

        for (int i = 0; i < length; i++) {
            catRepository.save(Cat.builder()
                    .name(catStorage.arrayName[i])
                    .url(catStorage.arrayUrl[i])
                    .rating(0)
                    .countLike(0)
                    .build());
        }
    }

    private void collectAdmin() {
        if (userRepository.count() > 0) {
            User user =
                    userRepository
                            .findUserByFirstName("I");

            if (!("Novus".equals(user.getLastName()))) {
                generateAdmin();
            }
        } else {
            generateAdmin();
        }
    }

    private void generateAdmin() {
        userRepository.save(User.builder()
                .firstName("I")
                .lastName("Novus")
                .role(User.Role.ADMIN)
                .login("admin")
                .hashPassword(passwordEncoder.encode("admin"))
                .build());
    }

    private static class CatStorage {
        private final String[] arrayUrl = {
                "https://avatars.mds.yandex.net/get-zen_doc/3630864/pub_6066b6a1a773600090600bb7_6066b6cd9f06e15305bf40fc/scale_1200",
                "https://avatars.mds.yandex.net/get-zen_doc/1108048/pub_5c6b8429b8ac0d00af322ce3_5c6b847d9d7a9a00aff8db8d/scale_1200",
                "https://cont.ws/uploads/pic/2019/9/3c4296eb88c63d2.jpg",
                "https://yt3.ggpht.com/ytc/AAUvwnj5WNGtB9mSTl0jZTRsnphnTOapg90g7nCw_nGwoA=s900-c-k-c0x00ffffff-no-rj",
                "https://content.onliner.by/news/1100x5616/87cc4ccf05472e16bec0249a0d98e281.jpeg",
                "https://s.fishki.net/upload/users/2021/04/19/1771078/tn/5fdb30bd44d290774c3dfec0430b0c24.jpg"
        };

        private final String[] arrayName = {
                "Дикий",
                "Игорь",
                "Пух",
                "Барсюк",
                "Малыш",
                "Карлсон",
        };
    }
}
