package com.example.finalbackendproject.repository;

import com.example.finalbackendproject.model.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, String> {

    Secretary findByUsernameAndPassword(String username, String password);

    List<Secretary> findByUsernameContainingIgnoreCaseAndFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(
            String username, String firstName, String lastName
    );
}
