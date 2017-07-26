package com.base.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.Dao.EducationExperienceDao;
import com.base.Po.educationList;
import com.base.Service.EducationExperienceService;

@Service("EdecationExperienceService")
public class EducationExperienceServiceImpl implements EducationExperienceService{

	@Autowired
	private EducationExperienceDao edecationExperienceDao;

	@Override
	public int addeducation(String studentId, String address, String begin,
			String end, String description) {
		// TODO Auto-generated method stub
		int flag = edecationExperienceDao.addeducation(studentId, address, begin, end, description);
		return flag;
	}

	@Override
	public educationList query_education(Integer size, Integer pageindex,
			int order, String orderDir, String searchValue) {
		// TODO Auto-generated method stub
		String columnName = "";
		if (order == 1) {
		    columnName = "id";
		} else if (order == 2) {
		    columnName = "name";
		}
		educationList list = edecationExperienceDao.query_education(size, pageindex, columnName, orderDir, searchValue);
		return list;
	}

	@Override
	public String delEducation(String str) {
		// TODO Auto-generated method stub
		String message= edecationExperienceDao.delEducation(str);
		return message;
	}

	@Override
	public void updateEducation(int id, String begin, String end,
			String description) {
		// TODO Auto-generated method stub
		edecationExperienceDao.updateEducation(id, begin, end, description);
	}
}
