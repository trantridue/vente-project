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

	@Query("from User u where u.name like %:name% order by u.name desc")
	List<User> findByName(@Param("name") String name);

	@Query("from User u where u.username = :username")
	User findByUsername(@Param("username") String username);

	@Query("from User m where m.createDate between :startDate and :endDate order by m.createDate desc")
	List<User> findByPeriod(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
