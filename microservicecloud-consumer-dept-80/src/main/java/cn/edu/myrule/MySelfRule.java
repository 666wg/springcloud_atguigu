package cn.edu.myrule;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：
 *      官方文档明确给出警告：
 *      Ribbon的自定义配置类不能放在@ComponentScan（补充：@SpringBootApplication注解中包含@ComponentScan）所扫描的当前包以及子包下，
 *      否则我们自定义的这个配置类就会被所有的Ribbon客户端所共享，也就是说达不到自定义的目的了
 */

@Configuration
public class MySelfRule
{
	@Bean
	public IRule myRule()
	{
	    //Ribbon提供了7种算法，默认是轮询算法
//        return new RoundRobinRule();//轮询算法
//        return new RandomRule();//随机算法
//        new AvailabilityFilteringRule();
//        new WeightedResponseTimeRule();//加权算法
//        new RetryRule();
//        new BestAvailableRule();//请求数最少算法
//        new ZoneAvoidanceRule();

		return new RandomRule_ZY();//自定义算法，自定义为每台机器5次
	}
}
