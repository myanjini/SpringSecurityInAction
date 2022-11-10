package com.ssia.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssia.entity.Token;

public interface JpaTokenRepository extends JpaRepository<Token, Integer> {
	Optional<Token> findTokenByIdentifier(String identifier);
}
