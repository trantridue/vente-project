package com.zabuza.vente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zabuza.vente.domain.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
