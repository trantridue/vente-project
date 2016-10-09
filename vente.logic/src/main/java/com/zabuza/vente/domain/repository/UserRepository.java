package com.zabuza.vente.domain.repository;

import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zabuza.vente.domain.model.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("from User u where u.firstname like %:firstname% order by u.firstname desc")
	List<User> findByName(@Param("firstname") String firstname);

	@Query("from User u where u.username = :username")
	User findByUsername(@Param("username") String username);

	@Query("from User m where m.date between :startDate and :endDate order by m.date desc")
	List<User> findByPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
