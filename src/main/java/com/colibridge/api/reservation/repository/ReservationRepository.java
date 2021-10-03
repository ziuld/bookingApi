package com.colibridge.api.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.colibridge.api.reservation.model.ReservationEntity;

/**
 * <h2>ReservationRepository</h2>
 * <p>
 * Communications with DataBase
 * </p>
 *
 * @author Luis Hernandez
 * @version 1.0
 * @since 2021-01-09
 */
@Repository
public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
	
	/**
	 * Find matches between dates.
	 * @param end
	 * @param start
	 * @return List<ReservationEntity>
	 */
	List<ReservationEntity> findAllByStartDateIsAfterOrEndDateIsBefore(String end, String start);
	
//	@Query(nativeQuery = true, value = "your sql query")
//	ReservationEntity methodName(String arg1, String arg2);
}
