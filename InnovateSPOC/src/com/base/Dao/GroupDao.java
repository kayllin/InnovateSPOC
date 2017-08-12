package com.base.Dao;

import com.base.Po.Group_list;

public interface GroupDao {

	public Group_list query_group(Integer size, Integer pageindex,String columnName, String orderDir, String searchValue);


	public void updateGroup(String sid, String sname,int gid, String gname);
}
