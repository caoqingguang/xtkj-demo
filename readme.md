## demo工程

## 技术说明
- 项目为maven项目，git代码托管
- web 架构：ratpack微服务
- 依赖管理：guice
- 数据库  ：postgresql  （待添加）
- 缓存数据库：ssdb  (待添加)


## 包说明
- 主函数：com.xtkj.demo 下 WebMain
- conf包：对应配置文件相关配置，主配置文件为ConfManager
- router包：各url对应的handler
- service包：业务处理类
- tools包：工具包
- pojo包： 项目用的pojo定义
- guice包：依赖注入

## demo url
- 获取user信息
- http://localhost:8080/demo/user  
- 获取cell信息
- http://localhost:8080/demo/cell 
- 获取map信息
- http://localhost:8080/demo/map
 
## 项目启动
1. 安装jdk1.8
2. 执行打包命令 mvn clean package
3. 拷贝  web-demo.jar 和 config.conf 到指定目录  
4. 执行  java -jar  web-demo.jar
ok
