package com.job.util;

import com.job.domain.entity.Company;
import com.job.domain.entity.Users;
import com.job.domain.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersDataInit {

    private final UsersRepository usersRepository;

    public void insertUsersData() {
        usersRepository.save(new Users("가나다"));
    }
}
