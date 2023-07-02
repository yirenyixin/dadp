.# dadp4.3

#### 介绍

中电金信DADP微服务快速开发平台4.3

#### 软件架构

1. 此版本使用springcloud-alibaba，需要启动redis，nacos2.0.3 提供了oracle和mysql数据库的建表文件。
2. 没有使用Spring Security组件，自己写的aop鉴权。
3. 2021年初启动此版本，相对dadp4.1版本，重组了工程结构，取消了pagehelper的分页写法。使用了mybatis-plus的分页写法。

#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 一、使用说明

1、修改logback日志路径（可选）

    1.1、修改service-* 模块 src\main\resource 下的 logback.xml ，路径改成需要的。
            <!-- 日志存放路径 -->
            <property name="log.path" value="${BUILD_FOLDER:-build}/log/${springAppName}"/>

2、使用代码生成功能

3、 nacos2.0.3

    3.1、修改bin目录下startup.cmd或startup.sh 把 export MODE="cluster"  改成 export MODE="standalone"
        注意：【生产环境，请用集群模式】
    3.2、运行bin目录下的startup.cmd（windows系统）或startup.sh (mac、Linux、unix) 命令 。
    3.3、控制台地址：http://localhost:8848/nacos
    3.4、控制台用户名/密码 nacos/nacos
	3.5、官方说明：https://nacos.io/zh-cn/docs/quick-start.html

4、redis

	4.1、非windows系统直接解压 redis-6.2.6.zip （可用其他版本）
			运行命令： src\redis-server
			执行redis命令：src\redis-cli
			帮助命令，可以执行：
			help @ hash
			help @list
	4.2、windows版本 （可用其他版本）
		下载 Redis-x64-3.0.504.zip 解压运行

5、配置 resources/application*文件

    5.1、初始项目只有application.yml 和application-dev.yml 配置文件。可以根据自己的项目需要增加配置文件，如
        application-test.yml,application-pre.yml等。
    5.2、注意修改里面的 nacos、redis、数据库地址 都要改成自己的
    5.3、配置文件中数据库密码是密文
        到dadp-core模块 com.gientech.core.util.JasyptUtil中根据明文密码生成加密密码

6、初始化建表语句

    6.1 到 dadp-codeCreate模块的,【数据库设计】目录下，找到相应的建表语句和初始化脚本
        目录下有oracle和mysql的建表语句及初始化脚本

7、 启动项目

    7.1、本地启动nacos、redis。 然后启动service-* 模块下的  Start* 方法
    7.2、系统登录： 用户名：admin 密码：admin 或查看t_sys_config 表查看配置的超级密码

8、查看接口：

    8.1、swagger 路径：localhost:服务端口/doc.html 
    8.2、service-sys:访问http://localhost:9801/doc.html
    8.3、service-demo:访问http://localhost:9901/doc.html

## 二、spring cloud,boot ,alibaba 版本要求

    1、本系统alibaba、cloud、boot版本
        spring-cloud-alibaba.version= 2.2.7.RELEASE
        spring-boot.version=2.3.12.RELEASE
        spring-cloud.version=Hoxton.SR12
    2、spring-boot 2.3.12 要求的软件 https://docs.spring.io/spring-boot/docs/2.3.12.RELEASE/reference/html/getting-started.html#getting-started-system-requirements
         docs/2.3.12.RELEASE 后面的"2.3.12.RELEASE"替换成其他版本，可以要求其他版本的软件要求
        2.1 jdk  
            8<=jdk<=15
        2.2 Maven/gradele
            MavremindTempen 3.5+、
            Gradle 6 (6.3 or later). 5.6.x is also supported but in a deprecated form
        2.3 容器：
            Jetty 9.4 （Servlet Version  3.1）
            Tomcat 9.0（Servlet Version  4.0）
    3、spring cloud Hoxton.SR12 参考资料：https://start.spring.io/actuator/info
        3.1 要求的Spring boot
            Spring Boot >=2.2.0.RELEASE and <2.4.0.M1
    4、spring cloud alibaba  2.2.7.RELEAS要求的版本  参考资料：https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E
        3.1 Sentinel Version 1.8.1
        3.2 Nacos Version 2.0.3
        3.3 RocketMQ Version 4.6.1
        3.4 Dubbo Version 2.7.13
        3.5 Seata Version 1.3.0
        3.6 Spring Cloud =  Spring Cloud Hoxton.SR12
        3.7 Spring Boot  =2.3.12.RELEASE

#### 参与贡献

1. Fork 本仓库
2. 新建 Feat_xxx 分支
3. 提交代码
4. 新建 Pull Request

####                                                                   
