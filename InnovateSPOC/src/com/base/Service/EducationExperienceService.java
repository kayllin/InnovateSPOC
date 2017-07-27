package com.base.Service;

import com.base.Po.educationList;

public interface EducationExperienceService {

	public int addeducation(String studentId, String address, String begin,
			String end, String description);

	public educationList query_education(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue);

	public String delEducation(String str);
	
	public void updateEducation(int id,String begin,String end, String description);

}
