package cn.edu.microservicecloudconsumerdeptfeign.controller;

import java.util.List;

import cn.edu.microservicecloudapi.entities.Dept;
import cn.edu.microservicecloudapi.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController_Consumer
{
	//说明：在添加注解@EnableFeignClients(basePackages= {"cn.edu.microservicecloudapi.service"})，否则@Autowired注入失败，
	//basePackages 为 DeptClientService类 所在的包，
	@Autowired
	private DeptClientService service;

	@RequestMapping(value = "/consumer/dept/get/{id}")
	public Dept get(@PathVariable("id") Long id)
	{
		return this.service.get(id);
	}

	@RequestMapping(value = "/consumer/dept/list")
	public List<Dept> list()
	{
		return this.service.list();
	}

	@RequestMapping(value = "/consumer/dept/add")
	public Object add(Dept dept)
	{
		return this.service.add(dept);
	}
}
