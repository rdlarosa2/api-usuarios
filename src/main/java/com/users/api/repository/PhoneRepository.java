package com.users.api.repository;

import com.users.api.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository  extends JpaRepository<Phone, Integer> {

}
