package com.colibridge.api.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colibridge.api.reservation.model.GuestEntity;

@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {

}
