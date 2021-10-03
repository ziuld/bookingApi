package com.colibridge.api.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colibridge.api.reservation.model.GuestEntity;

/**
 * <h2>GuestRepository</h2>
 * <p>
 * Communications with DataBase
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@Repository
public interface GuestRepository extends JpaRepository<GuestEntity, Long> {
	/**
	 * Find all Guests Containing the name.
	 * @param name
	 * @param name2
	 * @return Iterable<ReservationEntity>
	 */
	List<GuestEntity> findByFirstNameContainingOrLastNameContaining(String name, String name2);

}
