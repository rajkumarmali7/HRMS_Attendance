package com.ahom.hrms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.ahom.hrms.entity.Attendance;

@EnableJpaRepositories
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{

//	@Query("select mvt from Attendance mvt where mvt.date between :x and :y")
//	public List<Attendance> getAttendanceByDate(@Param("x")String dateBefore, @Param("y")String dateAfter);
}
