# 智慧城市api接口开发_v1





## 一、项目介绍

>前言：笔者又肥来🌶，由于疫情关系专升本考试延期了一个月，利用这一个月的空闲时间，我们来愉快的做一期智慧城市api接口项目，将之前所学的sprinboot、mybatis等等知识全部贯穿一遍👻



### 1.1 项目描述

- 本项目为`智慧城市`为主题，开发一系列符合 RESTful API 规范的后台接口
- 本项目已提供MySQL数据库以及接口文档，我们只需关注接口业务逻辑处理即可





### 1.2 技术栈选型

+ SpringBoot
+ mybatis plus
+ shiro
+ lombok
+ redis
+ jwt
+ spring-boot-starter-validation



### 1.3 目录说明

![image-20220322183245069](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114950.jpg)





### 1.4 项目运行

1. 导入`smart_city_v1`数据库

2. 修改`application.yaml`配置文件，更改数据库连接配置

3. 在终端执行`java -jar xx.jar`命令，运行jar包

   ![image-20220322184519499](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114954.jpg)

4. 在浏览器输入http://localhost:7777/swagger-ui.html#/，即可查看swagger文档

   ![image-20220322184634406](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/115000.jpg)

5. 根据接口文档对接口进行测试🤓

   



## 二、环境搭建准备

### 2.1 多模块开发

>**子模块都需使用maven来创建**，maven会自动处理父子之间的依赖关系
>
>Ps：为了规范起见***三级包名***统一采用`com.belong.smart`

1. 创建sprinboot工程，删除无用目录，***仅留下pom.xml***，**主要的依赖都放在根pom.xml中**

   <img src="https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114945-1.jpg" alt="image-20220317155558420" style="zoom:50%;" />

2. 使用maven创建`smart-common`模块，该模块为**复用功能模块**以及***存放一些配置***，需***要在启动模块的pom.xml中被依赖***

3. 使用maven创建`smart-main`模块，该模块为**启动模块**，用于编写springboot启动类，引入其他子模块

   ![image-20220317155732686](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114946.jpg)

   

   ![image-20220317160048914](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114953-1.jpg)









### 2.2 common模块说明

>模块互相依赖问题：https://blog.csdn.net/weixin_44318830/article/details/104166278

​		笔者本来是想将所有可复用的东西，比如：统一接口封装、token工具类放在main模块中的，这样main模块就既是启动模块又是复用模块，岂不一举两得？结果运行springboot项目时出错了。报错的信息大致如下：`两个模块之间不能相互依赖，否则会导致死循环`。

​		我思索了一下流程，main模块作为启动模块，需要导入其他的子模块聚合打包，而其他子模块需要依赖于main模块才能使用可复用的东西，因此就导致了相互依赖关系。

​		所以main模块只能够单纯的用于启动springboot，而不能编写复用东西，***解决办法就是新建一个`common`模块***，里面存放复用的工具，让所有子模块依赖他即可。

​		由于所有子模块都需要依赖common模块，因此我们可以***直接在根pom.xml中导入common模块***

​		![image-20220317161736106](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114945.jpg)

​	





### 2.3 目录说明

![image-20220317162724273](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114948.jpg)







### 2.4 导入依赖

- 根pom.xml

  ```xml
  <!--公共模块-->
  <dependencies>
      <!--自定义common模块，里面存放了大量复用东西-->
      <dependency>
          <groupId>com.belong</groupId>
          <artifactId>smart-common</artifactId>
          <version>0.0.1-SNAPSHOT</version>
      </dependency>
  
      <!--JSR303校验-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-validation</artifactId>
      </dependency>
  
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-configuration-processor</artifactId>
          <optional>true</optional>
      </dependency>
  
      <!-- hutool工具类-->
      <dependency>
          <groupId>cn.hutool</groupId>
          <artifactId>hutool-all</artifactId>
          <version>5.3.3</version>
      </dependency>
  
      <!-- 生成和校验token的工具类-->
      <dependency>
          <groupId>com.auth0</groupId>
          <artifactId>java-jwt</artifactId>
          <version>3.8.2</version>
      </dependency>
  
      <!-- swagger2 -->
      <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-swagger2</artifactId>
          <version>2.9.2</version>
      </dependency>
  
      <dependency>
          <groupId>io.springfox</groupId>
          <artifactId>springfox-swagger-ui</artifactId>
          <version>2.9.2</version>
      </dependency>
  
  
      <!--MP 代码生成器-->
      <dependency>
          <groupId>com.baomidou</groupId>
          <artifactId>mybatis-plus-generator</artifactId>
          <version>3.4.0</version>
      </dependency>
  
      <!--代码生成器所需的模板-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-freemarker</artifactId>
      </dependency>
  
      <!--MP-->
      <dependency>
          <groupId>com.baomidou</groupId>
          <artifactId>mybatis-plus-boot-starter</artifactId>
          <version>3.5.1</version>
      </dependency>
  
      <!--springboot-->
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-jdbc</artifactId>
      </dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
  
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-devtools</artifactId>
          <scope>runtime</scope>
          <optional>true</optional>
      </dependency>
      <dependency>
          <groupId>mysql</groupId>
          <artifactId>mysql-connector-java</artifactId>
          <scope>runtime</scope>
      </dependency>
      <dependency>
          <groupId>org.projectlombok</groupId>
          <artifactId>lombok</artifactId>
          <optional>true</optional>
      </dependency>
      <dependency>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-test</artifactId>
          <scope>test</scope>
      </dependency>
  </dependencies>
  
  
  <build>
      <plugins>
          <plugin>
              <groupId>org.springframework.boot</groupId>
              <artifactId>spring-boot-maven-plugin</artifactId>
              <configuration>
                  <!--指定主入口类-->
                  <mainClass>com.belong.smart.Application</mainClass>
              </configuration>
          </plugin>
      </plugins>
  </build>
  ```



### 2.5 yaml配置

- 在***启动模块中编写yaml配置***：`application.yaml`

  ```yaml
  spring:
    datasource:
      username: root
      password: 12345678
      url: jdbc:mysql://localhost:3306/smart_city_v1
  
  mybatis-plus:
    configuration:
      # 配置日志（默认控制台输出）
      log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
    # 扫描resources -> mapper目录下的所有xml文件
    mapper-locations: classpath:mapper/*.xml
  
  belong:
    jwt:
      SECRET_KEY: belong_token # 密钥
      ExpiresIn: 604800000   # token有效时间  7天
  ```

  <img src="https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114949.jpg" alt="image-20220317162238559" style="zoom:50%;" />





## 三、common复用模块

### 3.1 整合mybatis-plus

- **分页插件**：config.MybatisPlusConfig

  ```java
  @Configuration
  @MapperScan("com.belong.**.mapper")
  public class MybatisPlusConfig {
      // 注册分页插件 - 最新版
      @Bean
      public MybatisPlusInterceptor mybatisPlusInterceptor() {
          MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
          interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.H2));
          return interceptor;
      }
  }
  ```

  

- **代码生成工具**：utils.CodeGenerator

  ```java
  public class CodeGenerator {
      public static void main(String[] args) {
          // 构建一个代码生成器对象
          AutoGenerator mpg = new AutoGenerator();
  
          // 1. 全局配置
          GlobalConfig gc = new GlobalConfig();
          String projectPath = System.getProperty("user.dir");  // 获取当前IDEA的project目录
  
          //将代码生成到哪个目录下
          gc.setOutputDir(projectPath + "/smart-04-service/src/main/java");
          gc.setAuthor("belong");  // 新增作者注释
          gc.setOpen(false);  // 执行成功后是否打开资源文件夹
          gc.setFileOverride(false);  // 是否覆盖原有的文件
          gc.setSwagger2(true); // 实体属性 Swagger2 注解
          gc.setServiceName("%sService");  // 去除Service的I前缀
          mpg.setGlobalConfig(gc);
  
          // 2. 数据源配置
          DataSourceConfig dataSource = new DataSourceConfig();
          dataSource.setUrl("jdbc:mysql://localhost:3306/smart_city_v1");
          dataSource.setDriverName("com.mysql.cj.jdbc.Driver");
          dataSource.setUsername("root");
          dataSource.setPassword("12345678");
          mpg.setDataSource(dataSource);
  
          // 3. 包配置
          PackageConfig pc = new PackageConfig();
          pc.setParent("com.belong.smart");
          mpg.setPackageInfo(pc);
  
          // 4. 策略配置
          StrategyConfig strategy = new StrategyConfig();
          // 根据数据表名来生成代码，可以传入多个数据库名
          strategy.setInclude("all_service");
          // 数据库驼峰转下划线规则
          strategy.setNaming(NamingStrategy.underline_to_camel);
          // 实体类字段如上
          strategy.setColumnNaming(NamingStrategy.underline_to_camel);
          // 开启驼峰命名
          strategy.setRestControllerStyle(true);
          // 接口路径采用下划线风格：localhost:8080/hello_id_2
          strategy.setControllerMappingHyphenStyle(true);
          strategy.setEntityLombokModel(true);  // 是否使用lombok开启注解
          strategy.setTablePrefix("m_"); // 设置数据表前缀
  
          // 4.1 自动填充功能(可选，也可以在数据库层实现)
          TableFill create_time = new TableFill("create_time", FieldFill.INSERT);
          TableFill update_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);
          ArrayList<TableFill> tableFills = new ArrayList<>();
          tableFills.add(create_time);
          tableFills.add(update_time);
          strategy.setTableFillList(tableFills);
  
          mpg.setStrategy(strategy);
          mpg.setTemplateEngine(new FreemarkerTemplateEngine());
          mpg.execute();  // 执行
      }
  }
  ```



- **填充策略**：handler.MyMetaObjectHandler

  ```java
  @Slf4j
  @Component //把处理器加到IOC容器中
  public class MyMetaObjectHandler implements MetaObjectHandler {
      // 插入时的填充策略
      @Override
      public void insertFill(MetaObject metaObject) {
          this.setFieldValByName("createTime",new Date(),metaObject);
          this.setFieldValByName("updateTime",new Date(),metaObject);
      }
  
      // 更新时的填充策略
      @Override
      public void updateFill(MetaObject metaObject) {
          this.setFieldValByName("updateTime",new Date(),metaObject);
      }
  }
  ```

  



### 3.2 统一结果封装

- **统一返回结果Bean**：entiy.ResultBean

  ```java
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  public class ResultBean {
      private String code;
      private String msg;
      private Object data;
  
      // 成功的数据响应
      public static ResultBean success(Object data) {
          return new ResultBean("200", "操作成功", data);
      }
  
      public static ResultBean success(String code, String msg, Object data) {
          return new ResultBean(code, msg, data);
      }
  
      // 失败的数据响应
      public static ResultBean fail(String msg) {
          return new ResultBean("500", msg, null);
      }
  
      public static ResultBean fail(String code, String msg, Object data) {
          return new ResultBean(code, msg, data);
      }
  }
  ```





### 3.3 拦截器 + JWT拦截资源

- **token工具类**：utils.JwtUtils

  - 注：***这里token的密钥和过期时间也可以通过yaml配置文件进行注入***，需要导入个依赖防止报错
  - 为什么笔者没有使用yaml注入呢？因为yaml注入的属性不能被`static`修饰，而工具类使用`static`修饰比较规范，所以笔者就弃用了yaml配置注入

  ```java
  @Data
  @Component // 将当前实体类交给spring容器进行托管
  //@ConfigurationProperties(prefix = "belong.jwt")
  public class JwtUtils {
      // 密钥
      public static String SECRET_KEY = "belong_token";
  
      // token 过期时间 24小时
      public static int ExpiresIn = 1000 * 60 * 60 * 24;
  
      // 生成token
      public static String createToken(String username) {
          String token = "";
  
          // 传入用户信息和密钥来生成token
          token = JWT.create()
                  .withAudience(username) // 传入用户信息
                  .withExpiresAt(new Date(System.currentTimeMillis() + ExpiresIn))  // token过期时间
                  .sign(Algorithm.HMAC256(SECRET_KEY));  // 传入密钥生成token
  
          return token;
      }
  
      // 校验token
      public static Boolean verifyToken(String token) {
          try {
              // 根据密钥来校验token
              JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(SECRET_KEY)).build();
              jwtVerifier.verify(token);
              return true;
  
          } catch (JWTVerificationException e) {
              throw new RuntimeException("token校验失败");
          }
      }
  }
  ```



- **用户登录拦截器**：handler.UserLoginInterceptor

  ```java
  /**
   * 拦截器：验证用户是否登录
   */
  public class UserLoginInterceptor implements HandlerInterceptor {
      @Override
      public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
          // 设置响应数据格式，防止浏览器接收中文出现乱码
          response.setContentType("text/html;charset=utf-8");
  
          // 1. 从请求头中获取token
          String token = request.getHeader("Authorization");
          if (token == null) {
              throw new RuntimeException("你还未登录，请先去登录");
          }
  
          // 2. 校验token
          Boolean verifyToken = JwtUtils.verifyToken(token);
          if (!verifyToken) {
              throw new RuntimeException("当前登录已过期，请重新登录");
          }
  
          return true;
      }
  }
  ```



- 配置拦截器：config.WebMvcConfig

  ```java
  @Configuration
  public class WebMvcConfig implements WebMvcConfigurer {
      /**
       * 注册自定义拦截器
       */
      @Override
      public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new UserLoginInterceptor())
                  // 拦截器拦截指定路径
                  .addPathPatterns(
                          "/05_press/list3",
                          "/07_profile/**",
                          "/08_live/**",
                          "/09_hospital/userinfo/patient/**",
                          "/09_hospital/userinfo/types/list",
                          "/09_hospital/userinfo/order/**",
                          "/10_bus/userinfo/busOrders/**",
                          "/13_car_check/userinfo/apt/**",
                          "/13_car_check/userinfo/cars/**",
                          "/15_job/userinfo/deliver/**",
                          "/15_job/userinfo/resume/**",
                          "/16_move_car/**"
                  );
      }
  }
  ```





### 3.4 全局异常处理

- 捕获全局异常处理：handler.GlobalExceptionHandler

  ```java
  @Slf4j
  @RestControllerAdvice
  public class GlobalExceptionHandler {
      // 断点异常
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      @ExceptionHandler(value = IllegalArgumentException.class)
      public ResultBean handler(IllegalArgumentException e) throws IOException {
          log.error("Assert异常:-------------->",e);
          return ResultBean.fail(e.getMessage());
      }
  
      // 实体类校验异常
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      @ExceptionHandler(value = MethodArgumentNotValidException.class)
      public ResultBean handler(MethodArgumentNotValidException e) throws IOException {
          log.error("实体类校验异常:-------------->",e);
          BindingResult bindingResult = e.getBindingResult();
          ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
          return ResultBean.fail("401", objectError.getDefaultMessage(), null);
      }
  
      // 处理运行时异常
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      @ExceptionHandler(value = RuntimeException.class)
      public ResultBean handler(RuntimeException e) throws IOException {
          log.error("运行时异常:-------------->",e);
          return ResultBean.fail(e.getMessage());
      }
  }
  ```





### 3.5 解决跨域

- **filter解决跨域**：filter.CorsFilter

  ```java
  // 拦截器解决跨域问题
  @WebFilter("/*")
  public class CorsFilter implements Filter {
      @Override
      public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
  
          HttpServletRequest req = (HttpServletRequest) servletRequest;
          HttpServletResponse res = (HttpServletResponse) servletResponse;
  
          res.setHeader("Access-Control-Allow-Origin", "*");
          res.setHeader("Access-Control-Allow-Credentials", "true");
          res.setHeader("Access-Control-Allow-Methods", "*");
          res.setHeader("Access-Control-Max-Age", "3600");
          res.setHeader("Access-Control-Allow-Headers", "Authorization,Origin,X-Requested-With,Content-Type,Accept,"
                  + "content-Type,origin,x-requested-with,content-type,accept,authorization,token,id,X-Custom-Header,X-Cookie,Connection,User-Agent,Cookie,*");
          res.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");
          res.setHeader("Access-Control-Expose-Headers", "*");
          filterChain.doFilter(servletRequest, servletResponse);
      }
  }
  ```



- 别忘了给***Springboot入口类***添加`@ServletComponentScan`注解

  ```java
  @SpringBootApplication
  @ServletComponentScan
  public class Main {
      public static void main(String[] args) {
          SpringApplication.run(Main.class, args);
      }
  }
  ```







### 3.6 集成Swagger2

- **swagger配置**：config.SwaggerConfig

  ```java
  @Configuration
  @EnableSwagger2
  public class SwaggerConfig {
      @Bean
      public Docket docket() {
          return new Docket(DocumentationType.SWAGGER_2)
              	.groupName("必龙同学的接口文档")
                  .apiInfo(apiInfo())
                  .select()
                  .apis(RequestHandlerSelectors.basePackage("com.belong.smart.controller"))
                  .build();
      }
  
      //配置文档信息
      private ApiInfo apiInfo() {
          // 作者信息
          Contact contact = new Contact("belong", "", "33158742@qq.com");
          return new ApiInfo(
                  "SmartCity", // 标题
                  "移动应用开发api接口", // 描述
                  "v1.0", // 版本
                  "", // 组织链接
                  contact, // 作者信息
                  "", // 许可
                  "", // 许可连接
                  new ArrayList<>()// 扩展
          );
      }
  }
  ```





### 3.7 小结

>完成了common复用模块，后面的接口实现就会非常的轻松了！

<img src="https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114947-1.jpg" alt="image-20220317164917368" style="zoom:50%;" />









## 四、业务开发

### 4.1 登录注册接口

在使用代码生成器生成了三层架构的基础上，我们来快速实现一下登录注册逻辑功能



>JSR实体类校验

- entity.dto.LoginDto

  ```java
  @Data
  @Validated
  public class LoginDto {
      @NotBlank(message = "昵称不能为空")
      private String username;
  
      @NotBlank(message = "密码不能为空")
      private String password;
  }
  ```



>controller层

```java
@Api(tags = "01、登录注册")
@RestController
public class SysUserController {
    @Autowired
    SysUserService userService;

    // 登录
    @ApiOperation("1.1 登录")
    @PostMapping("/login")
    public ResultBean login(@Validated @RequestBody LoginDto loginDto) {
        // 1. 判断用户名密码是否为空，JSR303校验已经帮我们做好了
        // 2. 查询数据库是否有该用户
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", loginDto.getUsername());
        SysUser user = userService.getOne(wrapper);
        Assert.notNull(user, "用户不存在");

        // 3. 校验密码是否与数据库匹配匹对
        String password = loginDto.getPassword();
        if (!password.equals(user.getPassword())) {
            return ResultBean.fail("密码错误");
        }

        // 4. 生成token返回给前端
        String token = JwtUtils.createToken(loginDto.getUsername());
        return  ResultBean.success(token);
    }

    // 注册
    @ApiOperation("1.2 注册")
    @PostMapping("/system/user/register")
    public ResultBean register(@RequestBody SysUser user) {
        // 1. 判断用户名是否在数据库中已存在
        QueryWrapper<SysUser> wrapper = new QueryWrapper<SysUser>().eq("user_name", user.getUserName());
        int count = userService.count(wrapper);
        if (count > 0) {
            return ResultBean.fail("用户名已存在，请重新注册");
        }
        // 2. 存入数据库
        boolean b = userService.save(user);
        if (b) {
            return ResultBean.success("注册成功");
        }
        return ResultBean.fail("注册失败");
    }
}
```



### 4.2 多表查询

- 遇到多表查询的情况下，我们就只能自定义SQL了，springboot中自定义SQL的实现方式有两种
  - ① 从零搭建三层架构，使用mybatis的原生方式编写SQL
  - ② 基于MP生成的三层架构上扩展自定义SQL 【**摸鱼必备**】



- 这里顺便谈谈在springboot中使用**mybatis**开发和**MP**开发的利弊：
  - 使用mybatia开发
    - 优点：**一个mapper映射文件即可完成多个不同表之间的增删改查**，工程目录会更加干净整洁
    - 缺点：需手写三层架构以及简单的SQL语句，过于繁琐
  - 使用MP开发
    - 优点：自动生成三层架构，简单的SQL语句只需调用API即可。
    - 缺点：会根据一个表生成一个三层架构，**工程目录相对会多**



### 4.3 结果集嵌套

>多表查询时，我们往往希望查询结果返回给客户端是**嵌套关系**的，而不是处于同一层级的关系。

<img src="https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114953.jpg" alt="image-20220322143426155" style="zoom:50%;" />



- 实现结果集嵌套的方式有两种：

  1. 编写结果集的实体类，通过逻辑代码处理，设置嵌套对象的属性值 【不优雅】

     <img src="https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114956.jpg" alt="image-20220322141320097" style="zoom:50%;" />

  2. 编写结果集的实体类，**使用mybatis 的一对多或多对一处理**关系查询结果并返回结果集对象，还不会的去重学mybatis吧！

     ![image-20220322141559785](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114951.jpg)





### 4.4 其他接口开发流程

>其他业务接口**无非就是增删改查、多表查询**，都是一样的套路，就不再赘述了，这里直接上干货 - **接口开发流程**！

- 在编写接口时，其流程最好如下
  1. 在Navicat中编写SQL语句调试， 理解**表与表之间的关系**
  2. 根据表的关系，选择性的***自动生成三层架构***，**一般情况下中间表不用生成**
  3. 如果涉及到多表查询，那么在MP的基础上***扩展自定义SQL功能***，并注意**文件名是否与其他模块文件冲突**
  4. 编写完一个接口使用postman进行调试









## 五、项目打包

### 5.1 启动模块的pom.xml

- Smart-main

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <project xmlns="http://maven.apache.org/POM/4.0.0"
           xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
      <parent>
          <artifactId>workspace</artifactId>
          <groupId>com.belong</groupId>
          <version>0.0.1-SNAPSHOT</version>
      </parent>
      <modelVersion>4.0.0</modelVersion>
  
      <artifactId>smart-main</artifactId>
  
      <properties>
          <maven.compiler.source>8</maven.compiler.source>
          <maven.compiler.target>8</maven.compiler.target>
      </properties>
  
      <!--处理启动模块和其他模块之间的依赖关系-->
      <dependencies>
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-01-user</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-02-start</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-03-home</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-04-service</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-05-new</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-06-metro</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-07-profile</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-08-living-expense</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-09-hospital</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-10-bus</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-11-violation</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-12-parking-lot</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-13-car-appointment-check</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-14-house</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-15-job</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
          <dependency>
              <groupId>com.belong</groupId>
              <artifactId>smart-16-car-move</artifactId>
              <version>0.0.1-SNAPSHOT</version>
          </dependency>
  
      </dependencies>
  </project>
  ```





### 5.2 父工程的pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
    <groupId>com.belong</groupId>
    <artifactId>workspace</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>workspace</name>
    <description>workspace</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>

    <packaging>pom</packaging>
    <modules>
        <module>smart-01-user</module>
        <module>smart-main</module>
        <module>smart-common</module>
        <module>smart-02-start</module>
        <module>smart-03-home</module>
        <module>smart-04-service</module>
        <module>smart-05-new</module>
        <module>smart-06-metro</module>
        <module>smart-07-profile</module>
        <module>smart-08-living-expense</module>
        <module>smart-09-hospital</module>
        <module>smart-10-bus</module>
        <module>smart-11-violation</module>
        <module>smart-12-parking-lot</module>
        <module>smart-13-car-appointment-check</module>
        <module>smart-14-house</module>
        <module>smart-15-job</module>
        <module>smart-16-car-move</module>
    </modules>

    <!--公共模块-->
    <dependencies>
        <!--自定义common模块，里面存放了大量复用东西-->
        <dependency>
            <groupId>com.belong</groupId>
            <artifactId>smart-common</artifactId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>

        <!--对JSON字符串和Java实体类对象进行转换-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.62</version>
        </dependency>

        <!--JSR303校验-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- hutool工具类-->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.3.3</version>
        </dependency>

        <!-- 生成和校验token的工具类-->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.8.2</version>
        </dependency>

        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger2 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/io.springfox/springfox-swagger-ui -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>


        <!--MP 代码生成器-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.4.0</version>
        </dependency>

        <!--代码生成器所需的模板-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>

        <!--MP-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.5.1</version>
        </dependency>

        <!--springboot-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!--指定主入口类-->
                    <mainClass>com.belong.smart.Application</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```



### 5.3 common模块的pom.xml

>**common模块的父依赖不能是父工程**，因为***父工程引入了common依赖***，如果common模块的父依赖是父工程，那么就会自动继承父工程的依赖，就相当于common模块自己依赖自己，导致套娃依赖。
>
>虽然在开发阶段没有出现这个问题，但是在项目发布阶段却出现了，值得小心嗷🤓
>
>解决方法就是<u>将common模块变成独立的springboot模块</u>即可！

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.4</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>

    <groupId>com.belong</groupId>
    <artifactId>smart-common</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>smart-common</name>
    <description>common</description>
    <properties>
        <java.version>1.8</java.version>
    </properties>

    <dependencies>
        <!--对JSON字符串和Java实体类对象进行转换-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>fastjson</artifactId>
            <version>1.2.62</version>
        </dependency>

        <!--JSR303校验-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- hutool工具类-->
        <dependency>
            <groupId>cn.hutool</groupId>
            <artifactId>hutool-all</artifactId>
            <version>5.3.3</version>
        </dependency>

        <!-- 生成和校验token的工具类-->
        <dependency>
            <groupId>com.auth0</groupId>
            <artifactId>java-jwt</artifactId>
            <version>3.8.2</version>
        </dependency>

        <!-- swagger2 -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>2.9.2</version>
        </dependency>
        <!-- swagger-ui -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>2.9.2</version>
        </dependency>

        <!--MP 代码生成器-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-generator</artifactId>
            <version>3.4.0</version>
        </dependency>

        <!--代码生成器所需的模板-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-freemarker</artifactId>
        </dependency>

        <!--MP-->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.5.1</version>
        </dependency>

        <!--springboot-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-jdbc</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <optional>true</optional>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>
</project>
```



### 5.4 其他子模块的pom.xml

统一加入build相关配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>workspace</artifactId>
        <groupId>com.belong</groupId>
        <version>0.0.1-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>smart-16-car-move</artifactId>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
    </properties>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <classifier>exec</classifier>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```



### 5.5 jar包部署

1. 将当前项目打包成jar包

   ![image-20220322171351162](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114956-1.jpg)

   

2. 打包成功后可在main模块的`target目录`中看到jar包

   <img src="https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114952.jpg" alt="image-20220322171450089" style="zoom:50%;" />

3. 将jar包复制到dist目录，并在同层级目录下编写`application.yaml`文件

   ![image-20220322171919090](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114955.jpg)

   

4. 执行`java -jar jar包`命令运行jar包

   ![image-20220322171702742](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114950-1.jpg)





### 5.6 jar包部署后如何再修改配置文件

1. 第一种比较麻烦，在本地修改完配置后，重新打包再部署。
2. 第二种可以在这个jar包同级目录下在创建一个application.properties或者application.yml;SpringBoot首先会加载外面的配置文件这样内部的配置文件就不需要再更改了。
3. 也可以再运行的时候通过命令行参数指定加载配置文件的位置；例如
   `java -jar xxxx.jar -spring.config.location=/x/x/appliction.properties`



- 参考：https://blog.csdn.net/qq_43672652/article/details/113808207



### 5.7 结语

>历时5天完成了本项目🥳，感觉后端just so so 嘛，本项目对以前所学的Java知识做了一个整合复盘，其大部分都在CRUD，至于多模块开发总是容易出Bug
>
>笔者再打算做一个v2版本的智慧城市api接口，下个版本使用平常的springboot工程进行开发，童鞋们下期见🥺







## 遇到的坑

### 1. 多模块命名冲突

>多模块开发中，要确保**各个模块之间三层架构下的文件没有命名冲突**，否则会报错或者会有奇怪的调试结果(不容易排查)，尤其是使用***MP生成三层架构代码时***，要格外**注意是否与其他模块之间的存在命名冲突**！笔者被这个问题坑了一天。
>
>PS：笔者在测试环境时发现就算模块的文件之间发生命名冲突了也没有报错，这是因为命名重复的文件，他们的文件内容相同，所以不会报错！所以不要存在侥幸心理噢😇

![image-20220318120426169](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114959.jpg)





### 2. Getmapping报错

- Controller中**不能定义相同的GetMapping**（指的是路径和请求方式不能相同），**否则启动会报错**

  ```java
  @GetMapping("/test01")
  public ResultBean test01() {
      return  ResultBean.success("");
  }
  
  @GetMapping("/test01")
  public ResultBean test2() {
      return  ResultBean.success("");
  }
  ```







### 3. MP的坑

- 实体类属性报错
  - MP自动生成的**实体类**的数据类型可能会与**数据库**字段的**数据类型不对应**，需注意查看



- SQL语句查询出错

  - 如果**数据库字段名是sql的关键字**，那么查询时会拼接关键字进行查询，导致查询出错

    ![image-20220322160606189](https://belong-1304212339.cos.ap-nanjing.myqcloud.com/img/114947.jpg)

   -  解决方式：①更改数据库字段（不推荐）   ②手写原生的mybatis sql

      



















