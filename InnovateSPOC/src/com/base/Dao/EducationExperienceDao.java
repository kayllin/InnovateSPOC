package com.base.Dao;

import com.base.Po.educationList;

public interface EducationExperienceDao {

	public int addeducation(String studentId, String address, String begin,
			String end, String description);

	public educationList query_education(Integer size, Integer pageindex,
			String columnName, String orderDir, String searchValue);

	public String delEducation(String str);
	
	public void updateEducation(int id,String begin,String end, String description);
}
