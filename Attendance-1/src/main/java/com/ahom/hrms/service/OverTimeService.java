package com.ahom.hrms.service;

import java.util.List;

import com.ahom.hrms.dto.OverTimeDto;
import com.ahom.hrms.entity.OverTime;

public interface OverTimeService {
	
	public void EmployeeSave(OverTimeDto overtimedto);
	public List<OverTimeDto> Employeefetch();
	public List<OverTime> getOverTime(String startdate
			, String enddate
			, String name);
	

}
