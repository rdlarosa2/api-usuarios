package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository  extends JpaRepository<Phone, Integer> {

}
