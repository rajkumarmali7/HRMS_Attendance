package com.ahom.hrms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ahom.hrms.entity.OverTime;

@Repository
public interface OverTimeRepository extends JpaRepository<OverTime, Integer> {

	@Query(value = "SELECT * FROM overtime o WHERE o.employee=:name AND o.date BETWEEN :startdate AND :enddate", nativeQuery = true)
	List<OverTime> findByNameAndDateRange(String startdate, String enddate, String name);

}
