---
title: Spring Boot
date: 2016-10-16 20:05:20
tags: Spring
categories: Spring
---

参考：《JavaEE开发的颠覆者 Spring Boot实战》

<!--more-->

# 第2章 Spring 的常用配置
## 2.1 Bean 的Scope
`@Scope` 注解：
- Singleton： 一个Spirng共享一个Bean实例，此为Spring默认配置。
- Prototype： 每次调用一个Bean实例。
- Request：web项目中，给每一个http request 新建一个Bean实例。
- Session：web项目中，给每一个http session 新建一个Bean实例。
- GlobalSession：这个只在protal应用中起作用，给每一个global http session新建一个Bean。

**示例：**

``` java
@Service //默认为Singleton，相当于@Scope("singleton")
public class DemoSingletonService {
}

@Service
@Scope("prototype") //声明为 Prototype
public class DemoPrototypeService {
}

@Configuration
@ComponentScan("springboot.chapter2.beanScope")
public class ScopeConfig {
}

public class DemoRunner {
    private static Logger logger = LoggerFactory.getLogger(DemoRunner.class);
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScopeConfig.class);

        DemoSingletonService demoSingletonService1 = context.getBean(DemoSingletonService.class);
        DemoSingletonService demoSingletonService2 = context.getBean(DemoSingletonService.class);
        logger.info("s1 与 s2 是否相等:{}", demoSingletonService1.equals(demoSingletonService2));

        DemoPrototypeService p1 = context.getBean(DemoPrototypeService.class);
        DemoPrototypeService p2 = context.getBean(DemoPrototypeService.class);
        logger.info("p1 与 p2 是否相等：{}", p1.equals(p2));
    }
}

--------
s1 与 s2 是否相等:true
p1 与 p2 是否相等:false
```
我们也可以观察日志，可以发现 `demoSingletonService` 只会 `create` 一次，第二次是从 `cache` 中返回的Bean；而 `demoPrototypeService` 需要 `create` 两次。

## 2.2 Spring EL 和资源调用
Spring EL表达式语言，支持xml和注解中使用表达式，类似于JSP的EL表达式。

Spring主要在注解@Value的参数中使用表达式：
- 注入普通字符；
- 注入操作系统属性；
- 注入表达式运算结果；
- 注入其他Bean的属性；
- 注入文件内容；
- 注入网址内容；
- 注入属性文件。

**示例：**
`commons-io` 将 file 转换成字符串：
``` xml
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.4</version>
</dependency>
```

## 2.3 Bean 的初始化和销毁
Spring 对 Bean 的生命周期操作提供了支持。在使用 Java 配置和注解配置下提供如下两种方式：
1. Java 配置方法： 使用 `@Bean` 的 `initMethod` 和 `destoryMethod` 
2. 注解方式：利用 JSR-250 的 `@PostConstruct` 和 `@PreDestory`

## 2.4 Profile
Profile 为在不同环境下使用不同的配置提供了支持。
1. 通过设定 Environment 的ActiveProfiles 来设定当前 context 需要使用的配置环境。在开发中使用 `@Profile` 注解类或者方法，达到在不同情况下选择实例化不同的 Bean。
2. 通过设定 jvm 的 `spring.profiles.active` 参数设置配置环境。
3. Web 项目在 Servlet 的 context parameter 中。



## 2.5 事件（Application Event）
Spring 的事件为 Bean 与 Bean 之间的消息通信提供了支持。当一个 Bean处理完一个任务后，希望通知另一个 Bean，这里就需要让另一个 Bean监听当前 Bean 所发送的事件。

Spring 事件要遵循下列流程：
1. 自定义事件，集成 ApplicationEvent。
2. 定义事件监听器，实现 ApplicationListener。
3. 使用窗口发布事件。

# 第3章 Spring 高级话题
## 3.1 Spring Aware
Spring 的依赖注入的最大亮点就是你所有的 Bean对 Spring 容器的存在是没有意识的。如果你需要使用 Spring 容器的功能资源，注入的 Bean 必须要意识到 Spring 窗口的存在，这就是所谓的 Spring Aware。
 
表 3-1 Spring 提供的Aware 接口

|  Aware   |   功能  |
| --- | --- |
|  BeanNameAware   |   获得窗口中 Bean 的名称  |
|  BeanFactoryAware   |  获得当前 Bean Factory，这样可以调用窗口的服务   |
|  ApplicationContextAware*   | 获得当前的Application Context，这样可以调用窗口的服务    |
|  MessgeSourceAware   |  获得Message Source，这样可以获得文本信息   |
|  ApplicationEventPublisherAware   | 应用时间发布器，可以发布事件，2.5 节中有例子    |
|  ResourcesLoaderAware   |  获得资源加载器，可以获得外部资源文件   |

## 3.2 多线程
Spring 通过任务执行器（TaskExecutor）来实现多线程和并发编程。使用 ThreadPoolTaskExecutor 可实现一个基于线程池的 TaskExecutor。而实际开发中任务一般是非阻碍的，即异步的，所以我们要在配置类中通过 `@EnableAsync` 开启对异步任务的支持，并通过在实际执行的 Bean 的方法中使用 `@Async` 注解来声明其是一个异步任务。

## 3.3 计划任务
首先通过在配置类注解 `@EnableScheduling` 来开启对计划任务的支持，然后在要执行计划任务的方法上注解 `@Scheduled` 声明这是一个计划任务。

## 3.4 条件注解 @Conditional
通过活动的 profile，我们可以获得不同的 Bean。 Spring 4提供了一个更通用的基于条件的 Bean创建，即 `@Conditional`。

## 3.5 组合注解和元注解
**元注解** 就是可以注解到别的注解上的注解，被注解的注解称为组合注解，组合注解具备元注解的功能。

## 3.6 @Enable* 注解的工作原理
通过 `@Enable*` 可以开启Spring的一项功能，从而避免自己配置大师的代码，大大降低使用难度。

# 第4章 Spring MVC 基本配置
## 4.3 Spring MVC 常用注解
1. @Controller：声明控制类
2. @RequestMapping：映射 Web 请求 
3. @ResponseBody：支持将返回值放在 **Response** 体内，而不返回一个页面。
4. @RequestBody：允许 **Request** 的参数在 **Request** 体中，而不是在直接链接的地址后面。放置在参数前。
5. @PathVariable：用来接收路径参数，如`/news/001`，可接收 `001` 作为参数。放置在参数前。
6. @RestController：组合了@Controller和@ResponseBody。


# 第5章 Spring Boot 基础

# 第6章 Spring Boot 核心
## 6.1 基本配置
### 6.1.1 入口类和@SrpingBootApplication

### 6.1.2 关闭特定的自动配置
``` java
@SrpingBootApplication(exclude = {SecurityAutoConfiguration.class})
或者
@EnableAutoConfiguration(exclude = {SecurityAutoConfiguration.class})
``` 

### 6.1.3 定制Banner
修改 Spring Boot 启动时的默认启动图案。在 `src/main/resource` 下新建一个 `banner.txt`，将图案放进去。
**关闭Banner：**
``` java
spring.main.banner-mode=off
//或者：
SpringApplication app = new SpringApplication(BootExerciseApplication.class);
app.setBannerMode(Banner.Mode.OFF);
app.run(args);
//或者fluent API:
new SpringApplicationBuilder(BootExerciseApplication.class).bannerMode(Banner.Mode.OFF).run(args);
``` 

### 6.1.4 Spring Boot 的配置文件
`application.properties` 或者 `application.yml` 作为全局配置文件放置在 `src/main/resources` 下或者类路径的 `/config` 下。
**示例：**
``` java
# 修改Tomcat端口
server.port=80
# 修改默认访问路径
server.context-path=/boot
``` 

### 6.1.5 starter pom

### 6.1.6 使用 xml 配置
如果有必要使用 xml 配置，可以通过 `@ImportResource` 加载。

## 6.2 外部配置
Spring Boot 允许使用 **properties**、`yaml`或者命令行参数作为外部配置。

### 6.2.1 命令行参数配置
Spring Boot 可以基于 jar 包运行，打成jar后可以通过下面命令运行：
``` java
java -jar xx.jar --server.port=80
``` 

### 6.2.2 常规属性配置
如果将配置直接配置在 `application.properties` 中，直接使用 `@Value` 注入即可。

### 6.2.3 类型安全的配置（基于 properties）
Spring Boot 提供了基于类型安全的配置方式，通过 `@ConfigurationProperties` 将 `properties` 属性和一个 Bean 及其属性关联，从而实现类型安全的配置。

## 6.3 日志配置

## 6.4 Profile 配置
Profile 是 Spring 用来针对不同环境对不同的配置提供支持的，全局 Profile 配置使用 `application-{profile}.properties`。 通过在 `application.properties`中设置 `spring.profiles.active=prod` 来指定活动的 Profile。

## 6.5 Spring Boot 运行原理
查看当前项目中已启用和未启用的自动配置的报告：
1. `java -jar xx.jar --debug`
2. 在`application.properties`中设置属性`debut=true`
3. 设置 VM 参数`--Ddebug`

### 6.5.1 运作原理

# 第7章 Spring Boot 的Web开发
## 7.2 Thymeleaf 模板引擎
Thymeleaf 是一个Java类库，它是一个 `xml/xhtml/html5` 模板引擎。

## 7.3 Web相关配置
### 7.3.2 接管 Spring Boot 的Web配置
我们可以通过一个配置类（`@Configuration`的类）加上`@EnableWebMvc`注解来实现完全自己控制的MVC配置。

一般情况下，Spring的自动配置是符合我们的大多数需求的。但是我们既想保留Spring Boot提供的便利，又需要增加自己的额外的配置的时候，可以定义一个配置类并继承**WebMvcConfigurerAdapter**，无须使用 `@EnableWebMvc`注解，重写的 `addViewControllers` 方法并不会覆盖 **WebMvcConfigurerAdapter** 中的方法。

## 7.3.3 注册Servlet、Filter、Listener
当使用Tomcat等Servlet窗口时，我们可能将Servlet、Filter和Listener声明为Spring Bean达到注册的效果；或者注册 ServletRegistrationBean、FilterRegistrationBean和ServletListenerRegistrationBeanBean。

## 7.4 Tomcat 配置
### 7.4.1 配置 Tomcat
直接在application.properties 文件中配置Tomcat的所有属性即可。通用的Servlet窗口配置都是以`server`作为前缀，Tomcat的为`server.tomcat`。

### 7.4.2 代码配置 Tomcat
如果需要通过代码的方式配置Servlet窗口，可以注册一个实现 EmbeddedServletContainerCustomizer 接口的 Bean；若想直接配置Tomcat、Jetty等可以直接定义 TomcatEmbeddedServletContainerFactory

### 7.4.4 SSL 配置
**1. 生成证书**
``` java
keytool -genkey -alias tomcat
``` 

**2. 配置SSL** 
在`application.properties`中设置：
``` java
server.port=80
server.ssl.key-store=classpath:.keystore
server.ssl.key-store-password=111111
server.ssl.key-store-type=JKS
server.ssl.key-alias=tomcat
``` 
在日志中可以看到`Tomcat started on port(s): 80 (https)`，然后使用IE进行访问。

**3. http 转向 https**
配置TomcatEmbeddedServletContainerFactory，并且添加 Tomcat 的 connector 来实现。
``` java
@Bean
public EmbeddedServletContainerFactory servletContainer(){
    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory(){
        @Override
        protected void postProcessContext(Context context) {
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/");

            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
        }
    };
    tomcat.addAdditionalTomcatConnectors(httpConnector());
    return tomcat;
}

@Bean
public Connector httpConnector(){
    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    connector.setScheme("http");
    connector.setPort(8080);
    connector.setSecure(false);
    connector.setRedirectPort(8443);
    return connector;
}
```
当我们访问：http://localhost:8080，会自动转到https://localhost:8443

## 7.5 Favicon 配置
- 关闭：`spring.mvc.favicon.enabled=false`
- 替换：在`static`替换自己的`favicon.ico`

## 7.6 WebSocket

## 7.7 基于 Bootstrap 和 AngularJS的Web应用
### 7.7.1 Bootstrap

### 7.7.2 AngularJS

# 第8章 Spring Boot 的数据访问

## 8.1 Docker

## 8.2 Spring Data JPA
JPA即Java Persistence API，是一个基于ORM映射的标准规范。
**使用NamedQuery：**
一个Bean映射一个查询语句。
``` java
@Entity
@Table(name = "users")
@NamedQuery(name = "User.findById", query = "SELECT u FROM  User u WHERE id = ?1")
public class User {
    @Id
    @GeneratedValue
    int id;
    String name;
    //setter and getter
}
public User findById(int id);
``` 

**使用@Query：**
在接口方法上实现查询，查询语句可以使用：
- 使用参数索引，如上例的`?1`。
- 使用命名参数。如下例的`:name`和`@Param("name")`。
- 如果注入`@Modifying`和`@Transactional`则可以组合`update`
``` java
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT u FROM User u WHERE name like :name%")
    public List<User> findByNameLike(@Param("name") String name);
}
``` 

**Specification：**
JPA 提供了基于准则查询的方式，即 **Criteria** 查询。

**排序：**
``` java
@Query(value = "SELECT u FROM User u WHERE name like ?1%")
public List<User> findByNameAndSort(String name, Sort sort);
``` 

**分页：**
``` java
@Query(value = "SELECT u FROM User u WHERE name like ?1%")
public List<User> findOneByName(String name, Pageable pageable);
``` 

**自定义Repository的实现：**
Spring Data 提供了和CrudRepository、PagingAndSortingRepository；Spring Data JPA 提供了 JpaRepository。如果我们想将自己常用的数据库操作封装起来，就如何操作？
（1）定义自定义Repository接口
//TODO
``` java

``` 


## 8.3 Spring Data REST
将repository自动输出为 REST资源。

### 8.3.1 配置
我们可以通过继承或者直接在自己的配置类上`@Import` RepositoryMvcConfiguration 类。

``` java

``` 
``` java

``` 
``` java

``` 
``` java

``` 
## 8.4 声明式事务

## 8.5 数据缓存Cache

## 8.6 NoSQL

# 第9章 Spring Boot 企业级开发
## 9.1 Spring Security

## 9.2 Spring Batch

## 9.3 异步消息

## 9.4 系统集成Spring Integration


# 第10章 Spring Boot 部署与测试
## 10.1 热部署

## 10.2 常规部署

## 10.3 云部署——基于Docker

## 10.4 测试

# 第11章 应用监控
## 11.1 http
## 11.2 JMX
## 11.3 SSH

# 第12章 分布式系统开发
## 12.1 微服务、原生云应用

## 12.2 Spring Cloud

## 12.3 实战

## 12.4 基于Docker部署


``` java

``` 

