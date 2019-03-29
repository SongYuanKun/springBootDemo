# springBootDemo

## 注解说明

### @EnableAutoConfiguration 自动加载配置文件(@SpringBootApplication注解已经引用)

### @ComponentScan   自动扫描注解(@SpringBootApplication注解已经引用)

### @SpringBootApplication   springBoot主程序入口

### @Configuration   配置注解

### @Value("${mongo.repset}")   读取配置文件中配置的值

### @Document  mongodb集合名称

### @Id  实体主键

### @RestController  restful风格的接口，返回数据只能是String

### @PropertySource  读取配置文件

### @Bean    注解实例

### @Scheduled    定时任务注解

## 配置文件加载顺序
这里说了四种方式可以把配置文件放到外部的。 
第一种是在jar包的同一目录下建一个config文件夹，然后把配置文件放到这个文件夹下； 
第二种是直接把配置文件放到jar包的同级目录； 
第三种在classpath下建一个config文件夹，然后把配置文件放进去； 
第四种是在classpath下直接放配置文件。

这四种方式的优先级是从一到四依次降低的。

## actuator 服务监控工具
`/actuator`

## 项目部署
   ### 简单部署
   使用`java -jar ***.jar`即可启动该项目
   ### 高级部署1
   本项目支持外部配置数据库，
   使用命令行<br/>
`java -jar demo.jar --spring.com.songyuankun.config.location=**.properties`<br/>
   其中文件名随便定义，无固定要求。<br/>
   ### 高级部署2
   本项目支持多环境部署，application-dev.properties文件或application-prod.properties中配置数据库连接信息。<br/>
   启动命令<br/>`java -jar ***.jar --spring.profiles.active=prod`<br/>或<br/>
   `java -jar ***.jar --spring.profiles.active=dev`<br/>

## swagger-ui
访问地址`/swagger-ui.html`<br/>
需要在`MyWebAppConfigurer.java`中增加swagger静态文件的访问权限，然后在`SwaggerConfig.java`中配置需要生成的接口