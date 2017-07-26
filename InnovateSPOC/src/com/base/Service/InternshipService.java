package com.base.Service;

import com.base.Po.internshipList;

public interface InternshipService {

	public int addinternship(String studentId,String address,String begin,String end,String description);
	
	public internshipList query_internship(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue);
	
	public String delInternship(String str);
	
	public void updateInternship(int id,String begin,String end, String description);
}
