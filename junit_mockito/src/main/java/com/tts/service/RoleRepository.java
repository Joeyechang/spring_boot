package com.tts.service;

import com.tts.entiy.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mike on 2016/11/5.
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
