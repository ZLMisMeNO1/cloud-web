package cn.i7baozh.cloud.consumer.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Title:
 * @Package
 * @Description:
 * @author: baoqi.zhang
 * @date:
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /**
     * 以下代码用来调制ribbon 负载均衡策略（全局）
     * 如果不写则默认使用ribbon的轮询策略
     *
     * 同时要特别注意，如果对某个实例进行特殊的自定义负载均衡策略，则需要：
     *  第一步：编写类实现IRule接口（这个类不能被@ComponentScan扫描到，即该类必须不能再扫描的包及其子包下）
     *
     *  第二步：在启动类中加入注解 @RibbonClient(name = "实例名称",configuration = MyIRuleImpl.class)
     */
    @Bean
    public IRule iRule() {
        /**
         * RoundRobinRule 轮询
         * RandomRule 随机选择一个可用的服务器。
         * RetryRule 根据RoundRobinRule获取服务，如果获取失败则在指定时间内（默认500ms）进行重试，获取可用的服务.
         * AvailabilityFilteringRule
         * 对以下两种服务器进行忽略：
         *
         * （1）在默认情况下，这台服务器如果3次连接失败，这台服务器就会被设置为“短路”状态。短路状态将持续30秒，如果再次连接失败，短路的持续时间就会几何级地增加。
         *
         * 注意：可以通过修改配置loadbalancer.<clientName>.connectionFailureCountThreshold来修改连接失败多少次之后被设置为短路状态。默认是3次。
         *
         * （2）并发数过高的服务器。如果一个服务器的并发连接数过高，配置了AvailabilityFilteringRule规则的客户端也会将其忽略。并发连接数的上线，
         * 可以由客户端的<clientName>.<clientConfigNameSpace>.ActiveConnectionsLimit属性进行配置。
         *
         * WeightedResponseTimeRule
         * 为每一个服务器赋予一个权重值。服务器响应时间越长，这个服务器的权重就越小。这个规则会随机选择服务器，这个权重值会影响服务器的选择。
         *
         * ZoneAvoidanceRule
         * 以区域可用的服务器为基础进行服务器的选择。使用Zone对服务器进行分类，这个Zone可以理解为一个机房、一个机架等。
         *
         * BestAvailableRule 忽略哪些短路的服务器，并选择并发数较低的服务器。
         */
        return new RoundRobinRule();
    }

}
