package com.bci.users.repository;

import com.bci.users.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository <Phone,Long> {
}
