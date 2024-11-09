package com.zosh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zosh.model.Coin;

public interface CoinRepository extends JpaRepository<Coin,String> {
}
