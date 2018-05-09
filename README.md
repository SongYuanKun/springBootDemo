# springBootDemo

##注解说明

###@EnableAutoConfiguration 自动加载配置文件

###@ComponentScan   自动扫描注解

###@SpringBootApplication   springBoot主程序入口

###@Configuration   配置注解

###@Value("${mongo.repset}")   读取配置文件中配置的值

###@Document  mongodb集合名称

###@Id  实体主键

###@RestController  restful风格的接口，返回数据只能是String

###@PropertySource  读取配置文件

###@Bean    注解实例




##配置文件加载顺序
这里说了四种方式可以把配置文件放到外部的。 
第一种是在jar包的同一目录下建一个config文件夹，然后把配置文件放到这个文件夹下； 
第二种是直接把配置文件放到jar包的同级目录； 
第三种在classpath下建一个config文件夹，然后把配置文件放进去； 
第四种是在classpath下直接放配置文件。

这四种方式的优先级是从一到四依次降低的。

