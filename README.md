# cloud-web
cloud-web脚手架

### 准备工作
1. mysql创建数据库 CloudWeb
```sql
CREATE DATABASE  IF NOT EXISTS CloudWeb;
```
2. 修改配置文件数据库连接

3. host文件加入3个映射

```
127.0.0.1 eureka7001
127.0.0.1 eureka7002
127.0.0.1 eureka7003
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


### 测试

1. 测试eureka访问地址

> http://eureka7001:7001/

> http://eureka7002:7002/

> http://eureka7003:7003/

2. 测试调用正常

> http://localhost:6001/dept/view/1

> http://localhost:6001/dept2/view/2

3. 测试负载均衡，注意看日志

> http://localhost:6001/dept/view/1

> http://localhost:6001/dept/view/1

> http://localhost:6001/dept/view/1

4. 测试 方法上注解版熔断

> http://localhost:6001/dept/view/100

5. 测试服务降级

> http://localhost:6001/dept2/view/100



