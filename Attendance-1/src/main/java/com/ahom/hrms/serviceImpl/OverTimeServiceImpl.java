package com.ahom.hrms.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahom.hrms.dto.OverTimeDto;
import com.ahom.hrms.entity.OverTime;
import com.ahom.hrms.repository.OverTimeRepository;
import com.ahom.hrms.service.OverTimeService;

@Service
public class OverTimeServiceImpl implements OverTimeService {

	@Autowired
	OverTimeRepository overRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public void EmployeeSave(OverTimeDto overtimedto)
	{
		overRepository.save(OverTimeDtoToOverTime(overtimedto));
		
	}
	
	@Override
	public List<OverTimeDto> Employeefetch()
	{
		List<OverTimeDto> EmployeeList=new ArrayList<OverTimeDto>();
		overRepository.findAll().forEach(li->EmployeeList.add(OverTimeToOverTimeDto(li)));
		return EmployeeList;
	}
	
	@Override
	public List<OverTime> getOverTime(String startdate, String enddate, String name) {
		List<OverTime> list = overRepository.findByNameAndDateRange(startdate, enddate, name);
		System.out.println("haaaaaa"   +list);
		
		//List<OverTime> filteredoverTimes = new ArrayList<>();

//		for (OverTime overTime: list) {
//			filteredoverTimes.add(overTime);
//
//			System.out.println(overTime);
//
//		}
//		return filteredoverTimes;


		List<OverTimeDto> collect = list.stream().map(dt -> OverTimeToOverTimeDto(dt)).collect(Collectors.toList());
        System.out.println("affafafa   "+collect);
		return list;
	}

		
	/** -------------Using DTO Class in OverTimeDtoToOverTime --------------------------*/
	
	public OverTime OverTimeDtoToOverTime(OverTimeDto overtimedto)
	{
		OverTime addOvertime =this.modelMapper.map(overtimedto, OverTime.class);
		
		return addOvertime;
	}

	/** ------------Using DTO Class in OverTimeToOverTimeDto --------------------------*/
	
	 public OverTimeDto OverTimeToOverTimeDto(OverTime addOvertime)
	    {
		 OverTimeDto overtimeDto= this.modelMapper.map(addOvertime, OverTimeDto.class);

	     
	        return overtimeDto;
	    }	
}
