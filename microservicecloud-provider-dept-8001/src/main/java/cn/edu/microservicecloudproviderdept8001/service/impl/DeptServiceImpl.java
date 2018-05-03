package cn.edu.microservicecloudproviderdept8001.service.impl;

import java.util.List;

import cn.edu.microservicecloudapi.entities.Dept;
import cn.edu.microservicecloudproviderdept8001.dao.DeptDao;
import cn.edu.microservicecloudproviderdept8001.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeptServiceImpl implements DeptService
{
	@Autowired
	private DeptDao dao;
	
	@Override
	public boolean add(Dept dept)
	{
		return dao.addDept(dept);
	}

	@Override
	public Dept get(Long id)
	{
		return dao.findById(id);
	}

	@Override
	public List<Dept> list()
	{
		return dao.findAll();
	}

}
