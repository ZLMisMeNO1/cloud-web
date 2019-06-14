# cloud-web
cloud-web脚手架

### 准备工作
1. mysql创建数据库 CloudWeb
```sql
CREATE DATABASE  IF NOT EXISTS CloudWeb;
```
2. 修改配置文件数据库连接

3. host文件加入4个映射

> C:\Windows\System32\drivers\etc

```
127.0.0.1 eureka7001
127.0.0.1 eureka7002
127.0.0.1 eureka7003
127.0.0.1 zuul9527
```



### 启动服务

1. 启动eureka
- cn.i7baozh.eureka.RunServer7001
- cn.i7baozh.eureka.RunServer7002
- cn.i7baozh.eureka.RunServer7003
2. 启动provider
- cn.i7baozh.cloud.provider.RunServer8001
- cn.i7baozh.cloud.provider.RunServer8002
- cn.i7baozh.cloud.provider.RunServer8003

3. 启动consumer
- cn.i7baozh.cloud.consumer.RunServer6001

4. 启动hystrix监控
- cn.i7baozh.cloud.hystrix.dashboard.RunServer9001

5. 启动网关
- cn.i7baozh.cloud.zuul.gateway.RunServer9527

### 测试

1. 测试eureka访问地址

> http://eureka7001:7001/

> http://eureka7002:7002/

> http://eureka7003:7003/

2. 测试调用正常

> http://localhost:6001/dept/view/1

> http://localhost:6001/dept2/view/2

3. 测试负载均衡

连续访问下面URL，注意看日志。
> http://localhost:6001/dept/view/1


4. 测试 方法上注解版熔断

> http://localhost:6001/dept/view/100

5. 测试服务降级

第一种方式，访问下面URL
> http://localhost:6001/dept2/view/100

第二种方式，将provider服务关掉，访问下面URL

> http://localhost:6001/dept2/view/1

6. Druid监控界面

> http://localhost:8001/druid/index.html

> http://localhost:8002/druid/index.html

> http://localhost:8003/druid/index.html

7. 查看hystrix-dashboard

- 访问 http://localhost:9001/hystrix
- 在长输入框中输入 http://localhost:8001/hystrix.stream
- Delay使用默认，title填写 dept-provider8001
- 点击 Monitor Stream
- 疯狂访问8001服务中带有熔断的方法（使用jmeter最好啦）

8. 测试zuul网关

**坑：使用网关的时候实例名是yml文件中配置的，不要看eureka中是大写就写大写，会404**
- 不用网关
> http://localhost:8001/dept/view/1

- 使用网关（如果不能访问的话看下配置）
> http://zuul9527:9527/dept-provider/dept/view/1

> http://zuul9527:9527/mydept/dept/view/1

### hystrix-dashboard

