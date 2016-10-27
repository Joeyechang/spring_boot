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
2. 通过设定 jvm 的 spring.profiles.active 参数设置配置环境。
3. Web 项目在 Servlet 的 context parameter 中。

## 2.5 事件（Application Event）
Spring 的事件为 Bean 与 Bean 之间的消息通信提供了支持。当一个 Bean处理完一个任务后，希望通知另一个 Bean，这里就需要让另一个 Bean监听当前 Bean 所发送的事件。

Spring 事件要遵循下列流程：
- 自定义事件，集成 ApplicationEvent。
- 定义事件监听器，实现 ApplicationListener。
- 使用窗口发布事件。

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


# 第4章 Spring MVC 基本配置

# 第5章 Spring Boot 基础
## 5.1 概述

