package com.ahom.hrms.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ahom.hrms.dto.AttendanceDto;
import com.ahom.hrms.serviceImpl.AttendanceServiceImpl;

@RestController
@RequestMapping("/attendance")
@CrossOrigin
public class AttendanceController {

	@Autowired
	AttendanceServiceImpl attendanceService;

	@PostMapping("/save")
	public ResponseEntity<AttendanceDto> saveEmp(@RequestBody AttendanceDto attendancedto) {
		attendanceService.saveEmplAttendance(attendancedto);
		 return new ResponseEntity<>(attendancedto ,HttpStatus.CREATED);
	}
	
//	@GetMapping("/fetch/{dateBefore}/{dateAfter}")
//	public ResponseEntity<List<AttendanceDto>> getEmplAttendanceByDate() {
//		List<AttendanceDto> allEmployee = attendanceService.getAttendanceByDate(@RequestParam("dateBefore") int id);
//		return new ResponseEntity<>(allEmployee ,HttpStatus.OK);
//	}


	@GetMapping("/fetch")
	public ResponseEntity<List<AttendanceDto>> getEmplAttendance() {
		List<AttendanceDto> allEmployee = attendanceService.getAllEmplAttendance();
		return new ResponseEntity<>(allEmployee ,HttpStatus.OK);
	}

	@DeleteMapping("/Delete/{employeeId}")

	public void deleteEmp(@PathVariable("employeeId") int id) {
		attendanceService.deleteAttendance(id);
	}

	@PutMapping("/update")
	public ResponseEntity<AttendanceDto> updateEmplAttendance(@RequestBody AttendanceDto attendancedto) {
		attendanceService.updateEmployeeAttendance(attendancedto);

		return new ResponseEntity<> (attendancedto,HttpStatus.OK);
	}
	
	

}
