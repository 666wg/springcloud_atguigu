package cn.edu.microservicecloudconsumerdept80.cfgbeans;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean //boot -->spring   applicationContext.xml --- @Configuration配置   ConfigBean = applicationContext.xml
{ 
	@Bean
	@LoadBalanced//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}
	
	@Bean
	public IRule myRule()
	{
		IRule iRule;
		//Ribbon提供了7种算法，默认是轮询算法
		iRule = new RoundRobinRule();//轮询算法
		iRule = new RandomRule();//随机算法
		iRule = new AvailabilityFilteringRule();
		iRule = new WeightedResponseTimeRule();//加权算法
		iRule = new RetryRule();
		iRule = new BestAvailableRule();//请求数最少算法
		iRule = new ZoneAvoidanceRule();
		return iRule;
	}

}

//@Bean
//public UserServcie getUserServcie()
//{
//	return new UserServcieImpl();
//}
// applicationContext.xml == ConfigBean(@Configuration)
//<bean id="userServcie" class="com.atguigu.tmall.UserServiceImpl">