package cn.edu.microservicecloudproviderdept8003.service;

import cn.edu.microservicecloudapi.entities.Dept;

import java.util.List;


public interface DeptService
{
	public boolean add(Dept dept);

	public Dept get(Long id);

	public List<Dept> list();
}
