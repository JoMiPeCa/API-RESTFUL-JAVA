package com.ey.users.repositories;

import com.ey.users.domain.SessionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionData, Long> {
}
