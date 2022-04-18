package com.ey.users.repositories;

import com.ey.users.domain.PersonalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<PersonalData, Long> {

    Optional<PersonalData> findByEmail(String email);

    Optional<PersonalData> findByEmailAndPassword(String email, String password);


}
