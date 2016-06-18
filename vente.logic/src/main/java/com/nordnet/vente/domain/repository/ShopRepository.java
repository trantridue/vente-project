package com.nordnet.vente.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nordnet.vente.domain.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

}
