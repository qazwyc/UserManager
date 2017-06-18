## 1. 新建maven项目
+ 点击“File”->“New”->"Other"->输入“Maven”，新建一个“Maven Project”，如下图所示：

	 ![这里写图片描述](http://images2015.cnblogs.com/blog/63651/201607/63651-20160704090408092-633191076.png)
+ 请勾选“Create a simple project”，创建一个简单的项目。

	![这里写图片描述](http://img.blog.csdn.net/20170617204748187?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 填写好包名、项目名，选择打包类型为：war，如下图所示

	![这里写图片描述](http://img.blog.csdn.net/20170617205302987?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 项目创建好后可能会发现有错误，选择项目，右键“属性properties”->"层面Project Facets"->"Java"修改版本号为1.7，默认为1.5；点击“Ok”保存后关闭。如下图所示

	![这里写图片描述](http://img.blog.csdn.net/20170617205931083?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	
+ 重复上一个步骤，反勾Dynamic Web Module，将项目暂时变成非Web项目。点击“Ok”保存后关闭

	![这里写图片描述](http://img.blog.csdn.net/20170617210151897?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 重复上一个步骤，勾选“Dynamic Web Module”选择Version为3.0。点击左下角的超链接“Further Configuration available...“

	![这里写图片描述](http://images2015.cnblogs.com/blog/63651/201607/63651-20160704090851624-1036703005.png)

+ 勾选“Generate web.xml deployment descriptor”生成web.xml部署描述文件。点击“Ok”保存后关闭。

	![这里写图片描述](http://img.blog.csdn.net/20170617210619003?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 将生成的WebContent目录下的两个文件夹“META-INF”与“WEB-INF”复制到src/main/webapp目录下

	![这里写图片描述](http://img.blog.csdn.net/20170617210809365?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 删除WebContent目录

	![这里写图片描述](http://img.blog.csdn.net/20170617210934339?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 删除后会发现项目的pom.xml文件报错，是因为找不到指定位置的web.xml文件引起的。再进入项目的属性，选择“Deployment Assembly”项目部署项，删除“src/test/java”、“src/test/resources”与“WebContent”目录，因为这三项不需要部署出去。

	![这里写图片描述](http://img.blog.csdn.net/20170617211057636?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 点击“Add添加”后选择“Folder文件夹”为项目的最终部署结果指定Web内容根文件夹

	![这里写图片描述](http://img.blog.csdn.net/20170617211151839?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	
+ 选择src\main\webapp目录为目标目录，点击“Finish完成”保存并关闭

	![这里写图片描述](http://images2015.cnblogs.com/blog/63651/201607/63651-20160704091349327-2042140044.png)

+ 如果此时项目还报错，随便修改pom.xml文件后保存后错误就会消失

+ 在src\main\webapp目录下新建一个index.jsp文件，作为测试使用
	
	![这里写图片描述](http://img.blog.csdn.net/20170617211518763?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 新建完成后发现有错误，是因为没有JavaEE Server Runtime引起的，在项目上右键属性选择“Java Build Path”项，点击“Add Library...”添加引用

	![这里写图片描述](http://img.blog.csdn.net/20170617211650330?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 选择Server Runtime项，点击“Next下一步”，再选择“Apache Tomcat v7.0”，要根据自己的运行环境选择，如果没Server先整合Tomcat。

	![这里写图片描述](http://img.blog.csdn.net/20170617211737029?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

	![这里写图片描述](http://img.blog.csdn.net/20170617211813113?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 在index.jsp文件中写上测试内容

	```
	<%@ page language="java" contentType="text/html; charset=UTF-8"
	    pageEncoding="UTF-8"%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	</head>
	<body>
		hello the world!
	</body>
	</html>
	```

+ 在项目上右键选择“Run as”-> “Run on Server”运行项目，运行结果如下

	![这里写图片描述](http://img.blog.csdn.net/20170617212207883?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 2. 添加依赖

+ 依赖包可以去共享资源库中搜索，地址是：http://mvnrepository.com/. 这里以搜索连接驱动为示例，搜索后的结果有5.xx版许多，也有6.xx版，但不建议使用6.xx版，因为MyBatis3不支持

	![这里写图片描述](http://images2015.cnblogs.com/blog/63651/201607/63651-20160704101042936-924407774.png)

+ 选择版本后，将Maven的依赖信息复制到项目中的pom.xml的dependencies结点下

	![这里写图片描述](http://images2015.cnblogs.com/blog/63651/201607/63651-20160704101354921-1283041689.png)

+ 项目的pom.xml文件如下：

	```
	<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	  <modelVersion>4.0.0</modelVersion>
	  <groupId>com.yc</groupId>
	  <artifactId>UserManager</artifactId>
	  <version>0.0.1-SNAPSHOT</version>
	  <packaging>war</packaging>
	  <dependencies>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>3.8.1</version>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>javax.servlet-api</artifactId>
			<version>3.0.1</version>
			<scope>provided</scope>
		</dependency>
		<!-- spring-mvc包 -->  
	     <dependency>  
	         <groupId>org.springframework</groupId>  
	         <artifactId>spring-webmvc</artifactId>  
	         <version>4.2.0.RELEASE</version>  
	     </dependency>  
		<dependency>
		    <groupId>org.springframework</groupId>
		    <artifactId>spring-web</artifactId>
		    <version>4.2.0.RELEASE</version>
		</dependency>
		     <dependency>  
	         <groupId>org.springframework</groupId>  
	         <artifactId>spring-jdbc</artifactId>  
	         <version>4.2.0.RELEASE</version>  
	     </dependency>  
	     <!--spring事务tx包的引用 -->  
	     <dependency>  
	         <groupId>org.springframework</groupId>  
	         <artifactId>spring-tx</artifactId>  
	         <version>4.2.0.RELEASE</version>  
	     </dependency>  
	     <dependency>
	     	<groupId>org.springframework</groupId>
	     	<artifactId>spring-core</artifactId>
	     	<version>4.2.0.RELEASE</version>
	     </dependency>
	     <dependency>
	     	<groupId>org.springframework</groupId>
	     	<artifactId>spring-context</artifactId>
	     	<version>4.2.0.RELEASE</version>
	     </dependency>
	     <dependency>
	     	<groupId>org.springframework</groupId>
	     	<artifactId>spring-beans</artifactId>
	     	<version>4.2.0.RELEASE</version>
	     </dependency>
	     <!-- jsp显示数据需要的jar包 -->  
	     <dependency>  
	         <groupId>jstl</groupId>  
	         <artifactId>jstl</artifactId>  
	         <version>1.2</version>  
	     </dependency>  
	     <!--日志 -->  
	     <dependency>  
	         <groupId>log4j</groupId>  
	         <artifactId>log4j</artifactId>  
	         <version>1.2.17</version>  
	     </dependency>  
	     <dependency>  
	         <groupId>org.apache.logging.log4j</groupId>  
	         <artifactId>log4j-core</artifactId>  
	         <version>2.0</version>  
	     </dependency>  
	     <dependency>  
	         <groupId>org.apache.logging.log4j</groupId>  
	         <artifactId>log4j-api</artifactId>  
	         <version>2.0</version>  
	     </dependency>  
	     <!--spring4.0以上json和java对象的转换jackson包 spring4.0以上需要jackson2.6版本 -->  
	     <dependency>  
	         <groupId>com.fasterxml.jackson.core</groupId>  
	         <artifactId>jackson-core</artifactId>  
	         <version>2.6.1</version>  
	     </dependency>  
	     <dependency>  
	         <groupId>com.fasterxml.jackson.core</groupId>  
	         <artifactId>jackson-databind</artifactId>  
	         <version>2.6.1</version>  
	     </dependency>  
	     <dependency>  
	         <groupId>com.fasterxml.jackson.core</groupId>  
	         <artifactId>jackson-annotations</artifactId>  
	         <version>2.6.1</version>  
	     </dependency>  
	     <!--mybatis的包 -->  
	     <dependency>  
	         <groupId>org.mybatis</groupId>  
	         <artifactId>mybatis</artifactId>  
	         <version>3.2.8</version>  
	     </dependency>  
	     <!--mybatis和spring整合包 -->    
	     <!-- 我使用的连接数据的jar包 -->  
	     <dependency>  
	         <groupId>commons-dbcp</groupId>  
	         <artifactId>commons-dbcp</artifactId>  
	         <version>1.4</version>  
	     </dependency>  
	
	     <!--数据库jar包 -->  
	     <dependency>  
	         <groupId>mysql</groupId>  
	         <artifactId>mysql-connector-java</artifactId>  
	         <version>5.1.39</version>  
	     </dependency>  
	     <dependency>  
	         <groupId>commons-io</groupId>  
	         <artifactId>commons-io</artifactId>  
	         <version>2.2</version>  
	     </dependency> 
	     <dependency>
		    <groupId>commons-pool</groupId>
		    <artifactId>commons-pool</artifactId>
		    <version>1.6</version>
		</dependency>
		
		<dependency>
		    <groupId>org.aspectj</groupId>
		    <artifactId>aspectjweaver</artifactId>
		    <version>1.8.9</version>
		</dependency>
		<dependency>
			<groupId>org.mybatis</groupId>
			<artifactId>mybatis-spring</artifactId>
			<version>1.3.1</version>
		</dependency>
		<!-- json -->
		<dependency>
		    <groupId>org.json</groupId>
		    <artifactId>json</artifactId>
		    <version>20160810</version>
		</dependency>
	  </dependencies>  
	  
	</project>
	```
+ 如果在网速不稳定的情况下，下载包很有可能失败，可以试试强制项目重新下载，也可以手动将jar包下载后复制到本地资源库对应路径。
	
	![这里写图片描述](http://img.blog.csdn.net/20170617213406444?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 3. 使用MyBatis完成MySQL数据库访问
+ 创建一个表，这里以user表为例

	```
	DROP TABLE IF EXISTS `user`;
	CREATE TABLE `user` (
	  `id` int(11) NOT NULL AUTO_INCREMENT,
	  `name` varchar(10) NOT NULL,
	  `account` varchar(20) NOT NULL,
	  `phone` varchar(20) NOT NULL,
	  `email` varchar(20) NOT NULL,
	  `address` varchar(50) NOT NULL,
	  PRIMARY KEY (`id`),
	  UNIQUE(`account`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	
	INSERT INTO user(`name`,`account`,`phone`,`email`,`address`) VALUES ('张三','zhangsan','13787878787','zhangsan@qq.com','黑河'),('李四','lisi','13478787878','lisi@qq.com','李村');
	```

+ 新建包com.yc.po，创建java Bean User，get和set方法可通过快捷键ALT+SHIFT+S->Generate getters and setters生成 

	```
	package com.yc.po;
	
	public class User {
		private int id;
		private String name;
		private String account;
		private String phone;
		private String email;
		private String address;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAccount() {
			return account;
		}
		public void setAccount(String account) {
			this.account = account;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	}
	
	```

+ 创建实例与表的映射文件
	
	新建包com.yc.mybatis.mapper，用接口+XML的形式完成
	User数据访问接口UserDAO如下：
	```
	package com.yc.mybatis.mapper;
	
	import java.util.List;
	
	import org.apache.ibatis.annotations.Param;
	import org.springframework.stereotype.Repository;
	
	import com.yc.po.User;
	
	@Repository
	public interface UserDAO {
		//取全部用户 + 分页 + 按条件匹配
		public List<User> getAllUsers(@Param("skip") int skip,@Param("size") int size, 
				@Param("search_name") String search_name, @Param("search_account") String search_account);
		//用户数量
		public int getCount(@Param("search_name") String search_name, @Param("search_account") String search_account); 
		//添加用户
		public int addUser(User user);
	    //更新
		public int updateUser(User user);
	    //删除
		public int deleteUserById(int id);
	}
	```
	UserDAOMapper.xml文件如下：
	
	```
	<?xml version="1.0" encoding="UTF-8" ?>  
	<!DOCTYPE mapper  
	PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"  
	"http://mybatis.org/dtd/mybatis-3-mapper.dtd">  
	<mapper namespace="com.yc.mybatis.mapper.UserDAO">  
		<!-- 用户总数 + 账号和名称匹配 -->
	    <select id="getCount" resultType="int">  
	        select count(*) from user where name like #{search_name} and account like #{search_account}
	    </select> 
	    <!-- 查询用户 + 分页 + 按账号和名称匹配 -->
	    <select id="getAllUsers" resultType="com.yc.po.User">  
	        select * from user where name like #{search_name} and account like #{search_account} limit #{skip},#{size}
	    </select>   
	    <!--新增用户 -->
	    <insert id="addUser" parameterType="User">
	        insert into user(name,account,phone,email,address) values(#{name},#{account},#{phone},#{email},#{address});
	    </insert>
	    <!-- 更新用户 -->
	    <update id="updateUser" parameterType="User">
	        update user set name=#{name},account=#{account},phone=#{phone},email=#{email},address=#{address} where id=#{id}
	    </update>
	    <!--删除用户 -->
	    <delete id="deleteUserById" parameterType="int">
	    	 delete from user where id=#{id}
	    </delete>
	</mapper>  
	```
+ 在src/main/resources创建config/mybatis/mybatisconfig.xml文件,用于配置MyBatis的运行环境

	```
	<?xml version="1.0" encoding="UTF-8"?>
	<!DOCTYPE configuration
	  PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	  "http://mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
	    <!-- 指定数据库连接信息的位置 -->
	    <properties resource="db.properties"></properties>
	    <!--类型别名，默认引入com.yc.po下的所有类 -->
	    <typeAliases>
	        <package name="com.yc.po"/>
	    </typeAliases>
	    <environments default="development">
	        <environment id="development">
	            <transactionManager type="JDBC" />
	            <dataSource type="POOLED">
	                <property name="driver" value="${jdbc.driver}" />
	                <property name="url" value="${jdbc.url}" />
	                <property name="username" value="${jdbc.username}" />
	                <property name="password" value="${jdbc.password}" />
	            </dataSource>
	        </environment>
	    </environments>
	    <mappers>
	        <!--引入映射文件 -->
	        <mapper resource="com/yc/mybatis/mapper/UserDAOMapper.xml" />
	    </mappers>
	</configuration>
	```
	因为配置中依赖了db.properties文件，该文件用于指定数据库的连接信息，内容如下：
	```
	jdbc.driver=com.mysql.jdbc.Driver
	jdbc.url=jdbc:mysql://localhost:3306/test
	jdbc.username=root
	jdbc.password=root
	```

+ 实现数据访问功能
	为了更加方便的复用MyBatis实现数据访问不需要频繁的创建SQLSessionFactory和SQLSession对象，在src/test/java下新建包com.yc.test, 封装一个MyBatisUtil工具类如下：
	```
	package com.yc.test;
	
	import java.io.InputStream;
	
	import org.apache.ibatis.session.SqlSession;
	import org.apache.ibatis.session.SqlSessionFactory;
	import org.apache.ibatis.session.SqlSessionFactoryBuilder;
	
	public abstract class MyBatisUtil {
	    private static SqlSessionFactory factory=null;
	    public static SqlSessionFactory getSqlSessionFactory(){
	        if(factory==null){
		        // 获得环境配置文件流
		        InputStream config = MyBatisUtil.class.getClassLoader().getResourceAsStream("/config/mybatis/mybatisconfig.xml");
		        // 创建sql会话工厂
		        factory = new SqlSessionFactoryBuilder().build(config);
	        }
	        return factory;
	    }
	    
	    //获得会话
	    public static SqlSession getSession(){
	        return getSqlSessionFactory().openSession(true);
	    }
	    
	    /**
	     * 获得得sql会话
	     * @param isAutoCommit 是否自动提交，如果为false则需要sqlSession.commit();rollback();
	     * @return sql会话
	     */
	    public static SqlSession getSession(boolean isAutoCommit){
	        return getSqlSessionFactory().openSession(isAutoCommit);
	    }
	    
	}
	
	```

+ 使用JUnit进行单元测试
	新建测试用例UserTest.java
	```
	package com.yc.test;
	
	import static org.junit.Assert.*;
	
	import java.util.List;
	
	import org.apache.ibatis.session.SqlSession;
	import org.junit.Test;
	
	import com.yc.mybatis.mapper.UserDAO;
	import com.yc.po.User;
	
	import junit.framework.Assert;
	
	public class UserTest{
		
	    @Test
	    public void insertTest() {
	        SqlSession session=MyBatisUtil.getSession();
	        try {
	            User entity=new User();
	            entity.setName("王五");
	            entity.setAccount("wangwu");
	            entity.setPhone("13566666666");
	            entity.setEmail("wangwu@163.com");
	            entity.setAddress("黑河");
	            UserDAO userdao=session.getMapper(UserDAO.class);
	            Assert.assertEquals(1, userdao.addUser(entity));
	        } finally {
	            session.close();
	        }
	    }
	    
	    @Test
	    public void getCountTest(){
	        SqlSession session=MyBatisUtil.getSession();
	        try {
	            UserDAO userdao=session.getMapper(UserDAO.class);
	            System.out.println(userdao.getCount("%%", "%%"));
	        } finally {
	            session.close();
	        }
	    }
	
		@Test
	    public void getUserTest(){
	        SqlSession session = MyBatisUtil.getSession();
	        try {
	            UserDAO userdao=session.getMapper(UserDAO.class);
	            //%% 查询条件为空
	            List<User> users=userdao.getAllUsers(0, 10, "%%", "%%");
	            for(User user : users){
	            	System.out.println(user.getId() + " " + user.getName() + " "
	            			+ user.getAccount() + " " + user.getPhone() + " " 
	            			+ user.getEmail() + " " + user.getAddress());
	            }
	            assertNotNull(users);
	        } finally {
	            session.close();
	        }
	    }
	
	    @Test
	    public void updateTest(){
	        SqlSession session=MyBatisUtil.getSession();
	        try {
	            UserDAO userdao=session.getMapper(UserDAO.class);
	            User edituser = userdao.getAllUsers(0, 10, "%%", "%%").get(0);
	            edituser.setAddress("红山");
	            Assert.assertEquals(1, userdao.updateUser(edituser));
	        } finally {
	            session.close();
	        }
	    }
	    
	    @Test
	    public void deleteTest(){
	        SqlSession session=MyBatisUtil.getSession();
	        try {
	            UserDAO userdao=session.getMapper(UserDAO.class);
	            Assert.assertEquals(1, userdao.deleteUserById(3));
	        } finally {
	            session.close();
	        }
	    }
	}
	
	```
	运行测试，一切正常，测试结果如下：
	![这里写图片描述](http://img.blog.csdn.net/20170618015539108?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 4. 完成Spring整合MyBatis配置

+ 在src/main/resources下新建文件config/spring/spring-dao.xml文件，用于整合MyBatis与Spring

	```
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans 
			http://www.springframework.org/schema/beans/spring-beans-4.2.xsd 
			http://www.springframework.org/schema/mvc 
			http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd 
			http://www.springframework.org/schema/context 
			http://www.springframework.org/schema/context/spring-context-4.2.xsd 
			http://www.springframework.org/schema/aop 
			http://www.springframework.org/schema/aop/spring-aop-4.2.xsd 
			http://www.springframework.org/schema/tx 
			http://www.springframework.org/schema/tx/spring-tx-4.2.xsd ">
	    <!--配置数据库连接属性-->
	    <!--配置数据库连接属性加载db.properties的数据库连接信息文件-->
	    <context:property-placeholder location="classpath:db.properties"></context:property-placeholder>
	    <bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
	        <property name="driverClassName" value="${jdbc.driver}"/>  
	        <property name="url" value="${jdbc.url}"/>  
	        <property name="username" value="${jdbc.username}"/>  
	        <property name="password" value="${jdbc.password}"/>  
	        <property name="maxActive" value="30"/>  
	        <property name="maxIdle" value="5"/> 
	    </bean>
	
	    <!-- 让spring管理sqlsessionfactory 使用mybatis和spring整合包中的 -->
	    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
	        <!--注入数据库连接对象-->
	        <property name="dataSource" ref="dataSource"/>
	        <!--加载mybatis配置文件 这里mybatis配置文件的工作都在spring中配置了所以mybatis只是配置别名就可以-->
	        <property name="configLocation" value="classpath:/config/mybatis/mybatisconfig.xml"/>
	        <!--指定sql映射xml文件的路径 -->
	        <property name="mapperLocations"
	            value="classpath:com/yc/mybatis/mapper/*Mapper.xml"></property>
	    </bean>
	    
	    <!-- mapper扫描器 -->
	    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	        <!-- 扫描的包，如果要扫描多个，中间用,隔开 -->
	        <property name="basePackage" value="com.yc.mybatis.mapper"></property>
	        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
	    </bean>
	    
	    <!--定义事物管理器，由spring管理事务 -->
	    <bean id="transactionManager"
	        class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	        <property name="dataSource" ref="dataSource"></property>
	    </bean>
	</beans>
	```
+ 修改mybatisconfig.xml文件内容如下

	```
	<?xml version="1.0" encoding="UTF-8" ?>
	<!DOCTYPE configuration
	PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
	"http://www.mybatis.org/dtd/mybatis-3-config.dtd">
	<configuration>
	    <typeAliases>  
	        <typeAlias type="com.yc.po.User" alias="user"/>  
	    </typeAliases>
	
	</configuration>
	```
## 5. 配置web.xml加载Spring容器与MVC

+ 修改web.xml文件，注册加载Spring容器所需的监听器，注册Spring MVC前置控制器Servlet，添加了一个全局的编码过滤器。

	```
	<?xml version="1.0" encoding="UTF-8"?>
	<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
			 xmlns="http://java.sun.com/xml/ns/javaee" 
			 xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" 
			 id="WebApp_ID" version="3.0">
			 
	    <welcome-file-list>
	        <welcome-file>index.jsp</welcome-file>
	    </welcome-file-list>
	    
	    <listener>
	        <description>Spring容器加载监听器</description>
	        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	    </listener>
	    
	    <context-param>
	        <description>设置Spring加载时的配置文件位置，默认位置在WEB-INF/lib目录下</description>
	        <param-name>contextConfigLocation</param-name>
	        <param-value>classpath*:config/spring/spring-dao.xml</param-value>
	    </context-param>
		
		<!-- 加载spring配置文件 -->  
	    <servlet>  
	        <servlet-name>springmvc</servlet-name>  
	        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>  
	        <init-param>  
	            <param-name>contextConfigLocation</param-name>  
	            <param-value>classpath:config/spring/spring-mvc.xml</param-value>  
	        </init-param>  
	        <load-on-startup>1</load-on-startup>  
	    </servlet>  
	  
	    <!-- 设置url匹配模式 -->  
	    <servlet-mapping>  
	        <servlet-name>springmvc</servlet-name>  
	        <url-pattern>/</url-pattern>  
	    </servlet-mapping>  
	      
	    <!-- 编码过滤器 -->  
	    <filter>  
	        <filter-name>encodingFilter</filter-name>  
	        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>  
	        <init-param>  
	            <param-name>encoding</param-name>  
	            <param-value>utf-8</param-value>  
	        </init-param>  
	        <init-param>  
	            <param-name>forceEncoding</param-name>  
	            <param-value>true</param-value>  
	        </init-param>  
	    </filter> 
	    
	    <!-- 路径映射 --> 
	    <filter-mapping>  
	        <filter-name>encodingFilter</filter-name>  
	        <url-pattern>/*</url-pattern>  
	    </filter-mapping> 
	</web-app>  
	```

+ 在src/main/resources下添加Spring MVC配置文件config/spring/spring-mvc.xml

	```
	<beans xmlns="http://www.springframework.org/schema/beans"
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
		xmlns:context="http://www.springframework.org/schema/context"
		xmlns:aop="http://www.springframework.org/schema/aop" xmlns:tx="http://www.springframework.org/schema/tx"
		xsi:schemaLocation="http://www.springframework.org/schema/beans 
			http://www.springframework.org/schema/beans/spring-beans-4.2.xsd 
			http://www.springframework.org/schema/mvc 
			http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd 
			http://www.springframework.org/schema/context 
			http://www.springframework.org/schema/context/spring-context-4.2.xsd 
			http://www.springframework.org/schema/aop 
			http://www.springframework.org/schema/aop/spring-aop-4.2.xsd 
			http://www.springframework.org/schema/tx 
			http://www.springframework.org/schema/tx/spring-tx-4.2.xsd ">
		<!--打开注解 -->
		<mvc:annotation-driven/>
		<!--可以访问静态文件 -->
		<mvc:default-servlet-handler/>
		<!--配置扫描包 -->
		<context:component-scan base-package="com.yc"/>
		
		<!--内部视图解析器，JSP与JSTL模板 -->
		<bean
			class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<!--指定视图渲染类 -->
			<property name="viewClass"
				value="org.springframework.web.servlet.view.JstlView" />
			<!--自动添加到路径中的前缀 -->
			<property name="prefix" value="/WEB-INF/jsp/" />
			<!--自动添加到路径中的后缀 -->
			<property name="suffix" value=".jsp" />
			<!--设置所有视图的内容类型，如果视图本身设置内容类型视图类可以忽略 -->
	        <property name="contentType" value="text/html;charset=UTF-8" />
		</bean>
		
	</beans>
	```

## 6. 创建服务层 

+ 在包com.yc.service下添加UserService.java文件，该文件是一个服务接口，内容如下
	
	```
	package com.yc.service;
	
	import java.util.List;
	
	import com.yc.po.User;
	
	public interface UserService {  
		/**
		 * 获取用户 + 分页 + 筛选
		 * @param pageNo 页码
		 * @param size 页的大小
		 * @param search_name 按姓名匹配
		 * @param search_account 按账号匹配
		 * @return
		 */
		public List<User> getAllUsers(int pageNo, int size, String search_name, String search_account);
		/**
		 * 用户数量
		 * @return
		 */
		public int getCount(String search_name, String search_account);
		/**
		 * 新增用户
		 * @param user
		 * @return
		 */
		public int addUser(User user);
		/**
		 * 更新用户
		 * @param user
		 * @return
		 */
		public int updateUser(User user);
		/**
		 * 删除用户
		 * @param id
		 * @return
		 */
		public int deleteUserById(int id);
	}  
	
	```

+ 在包com.yc.serviceImpl下添加类UserServiceImpl.java，实现接口UserService，用于完成用户业务逻辑。使用了两个注解，一个是**@Service**，用于提供给需要服务的类自动装配，当Spring IOC容器启动时被扫描到该类型会自动添加实例到Spring容器中；另一个注解是**@Autowired**用于完成自动装配UserDAO类型的对象，代码如下：

	```
	package com.yc.serviceImpl;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	
	import com.yc.mybatis.mapper.UserDAO;
	import com.yc.po.User;
	import com.yc.service.UserService;
	
	@Service
	public class UserServiceImpl implements UserService{
		@Autowired
	    private UserDAO userDao;  
		//获取用户数量 + 按账号姓名匹配
		public int getCount(String search_name, String search_account) {
			// TODO Auto-generated method stub
			return userDao.getCount("%"+search_name+"%", "%"+search_account+"%");
		}
		//获取用户 + 分页 + 按账号姓名匹配
		public List<User> getAllUsers(int pageNo, int size, String search_name, String search_account) {
			// TODO Auto-generated method stub
			return userDao.getAllUsers((pageNo-1)*size, size, "%"+search_name+"%", "%"+search_account+"%");
		}
		//添加用户
		public int addUser(User user) {
			// TODO Auto-generated method stub
			return userDao.addUser(user);
		}
		//更新用户
		public int updateUser(User user) {
			// TODO Auto-generated method stub
			return userDao.updateUser(user);
		}
		//删除指定id用户
		public int deleteUserById(int id) {
			// TODO Auto-generated method stub
			return userDao.deleteUserById(id);
		}
	}
	```

## 7. 完成用户管理功能

+ 查询用户 + 分页 + 按账号姓名筛选
	定义UserController控制器，映射访问路径，需要使用到的服务使用自动装配完成
	
	```
	package com.yc.controller;
	
	import java.io.IOException;
	import java.util.List;
	
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import org.json.JSONArray;
	import org.json.JSONObject;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestMapping;
	import com.yc.po.User;
	import com.yc.serviceImpl.UserServiceImpl;
	
	
	@Controller  
	public class UserController {  
	    @Autowired  
	    private UserServiceImpl userInfoServiceImpl; 
	    
	    /*
	     * 获取用户 + 分页 + 按账号姓名筛选
	     */
	    @RequestMapping(value="/getUsers")  
	    public String getAllUsers(HttpServletRequest request, 
	    		HttpServletResponse response) throws IOException{
	    	//分页,easyui-datagrid会自动传递页码page和页长size
	    	int page = request.getParameter("page") == null ?
	    			1 : Integer.parseInt(request.getParameter("page"));
	    	int rows = request.getParameter("rows") == null ? 
	    			10 : Integer.parseInt(request.getParameter("rows"));
	    	//筛选条件
	    	String search_name = request.getParameter("search_name") == null ? 
	    			"" : request.getParameter("search_name");
	    	String search_account = request.getParameter("search_account") == null ? 
	    			"" : request.getParameter("search_account");
	        //调用服务
	    	List<User> users = userInfoServiceImpl.getAllUsers(
	    			page, rows, search_name, search_account); 
	        //封装json数据,total存放数据总数,rows存放数据数组，以提供给easyui的datagrid
	        JSONObject json = new JSONObject();
	        //筛选后的总数
	        json.put("total", userInfoServiceImpl.getCount(search_name, search_account));
	        JSONArray row = new JSONArray();
	        for(User info : users){
	        	JSONObject jo = new JSONObject();
	            jo.put("id", info.getId());
	            jo.put("account", info.getAccount());
	            jo.put("name", info.getName());
	            jo.put("phone", info.getPhone());
	            jo.put("email", info.getEmail());
	            jo.put("address", info.getAddress());
	            row.put(jo);
	        }
	        json.put("rows", row);
	        System.out.println(json.toString());
	        //写入响应
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(json.toString());
	        //没有对应jsp文件，故直接返回null
	        return null;  
	    }
	```
	
	运行结果如下：

	![这里写图片描述](http://img.blog.csdn.net/20170618192246719?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 新增、修改、删除用户的功能
	
	```
	    /*
	     * 新增用户
	     */
	    @RequestMapping(value="/add")  
	    public String addUser(HttpServletRequest request, 
	    		HttpServletResponse response) throws IOException{  
	    	User newuser = new User();
	    	newuser.setName(request.getParameter("name"));
	    	newuser.setAccount(request.getParameter("account"));
	    	newuser.setPhone(request.getParameter("phone"));
	    	newuser.setEmail(request.getParameter("email"));
	    	newuser.setAddress(request.getParameter("address"));
	    	//封装操作结果，包括success是否成功和msg消息提示
	    	JSONObject result = new JSONObject();
	    	try{
	    		userInfoServiceImpl.addUser(newuser);
	    		result.put("success", true);
	    		result.put("msg", "添加成功！");
	    	}catch(Exception e){
	    		result.put("success", false);
	    		result.put("msg", "账号已被占用！");
	    	}
	    	//写入响应
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(result.toString());
	        return null;
	    }
	    /*
	     * 更新指定id的用户
	     */
	    @RequestMapping(value="/update/{id}")  
	    public String updateUser(@PathVariable int id, HttpServletRequest request, 
	    		HttpServletResponse response) throws IOException{  
	    	User newuser = new User();
	    	newuser.setId(id);
	    	newuser.setName(request.getParameter("name"));
	    	newuser.setAccount(request.getParameter("account"));
	    	newuser.setPhone(request.getParameter("phone"));
	    	newuser.setEmail(request.getParameter("email"));
	    	newuser.setAddress(request.getParameter("address"));
	    	//封装操作结果，包括success是否成功和msg消息提示
	    	JSONObject result = new JSONObject();
	    	try{
	    		userInfoServiceImpl.updateUser(newuser);
	    		result.put("success", true);
	    		result.put("msg", "修改成功！");
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    		result.put("success", false);
	    		result.put("msg", "账号已被占用！");
	    	}
	    	//写入响应
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(result.toString());
	        return null;
	    } 
	    /*
	     * 删除指定id用户
	     */
	    @RequestMapping(value="/delete")  
	    public String deleteUser(HttpServletRequest request, 
	    		HttpServletResponse response) throws IOException{  
	    	//封装操作结果，包括success是否成功和msg消息提示
	    	JSONObject result = new JSONObject();
	    	try{
	    		userInfoServiceImpl.deleteUserById(Integer.parseInt(request.getParameter("id")));
	    		result.put("success", true);
	    		result.put("msg", "删除成功！");
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    		result.put("success", false);
	    		result.put("msg", "删除失败！");
	    	}
	    	//写入响应
	        response.setContentType("text/html;charset=utf-8");
	        response.getWriter().print(result.toString());
	        return null;
	    } 
	```
	测试结果如下:
	增加用户
	![这里写图片描述](http://img.blog.csdn.net/20170618211416981?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	重复添加
	![这里写图片描述](http://img.blog.csdn.net/20170618211511075?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	修改用户
	![这里写图片描述](http://img.blog.csdn.net/20170618211852935?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	删除用户
	![这里写图片描述](http://img.blog.csdn.net/20170618212233915?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

+ 界面
	在WEB-INF下新建jsp/list.jsp，使用easyui的datagrid来显示用户数据，通过url指定数据来源，通过load和reload加载和刷新，具体使用详见http://www.jeasyui.net/plugins/183.html,内容如下

	```
	<%@ page language="java" contentType="text/html; charset=UTF-8"  
	    pageEncoding="UTF-8"%>
	<!DOCTYPE HTML>  
	<html>  
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>用户管理</title>
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="http://www.jeasyui.net/Public/js/easyui/demo/demo.css">
		<style type="text/css">
			#fm{
				margin:0;
				padding:10px 30px;
			}
			.ftitle{
				font-size:14px;
				font-weight:bold;
				color:#666;
				padding:5px 0;
				margin-bottom:10px;
				border-bottom:1px solid #ccc;
			}
			.fitem{
				margin-bottom:5px;
			}
			.fitem label{
				display:inline-block;
				width:80px;
			}
		</style>
		<script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
		<script type="text/javascript" src="http://www.jeasyui.net/Public/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="datagrid-filter.js"></script>
		<script type="text/javascript">
			var url;
			//新增用户，打开对话框，指定url为add
			function newUser(){
				$('#dlg').dialog('open').dialog('setTitle','新增用户');
				$('#fm').form('clear');
				url = 'add';
			}
			//修改选中行，打开对话框，指定url为update加上对应id
			function editUser(){
				var row = $('#dg').datagrid('getSelected');
				if (row){
					$('#dlg').dialog('open').dialog('setTitle','更新用户');
					//将选中行的数据加载到表单
					$('#fm').form('load',row);
					url = 'update/' + row.id;
				}
			}
			//提交表单到对应url
			function saveUser(){
				$('#fm').form('submit',{
					url: url,
					success: function(result){
						//json字符串转对象
						var res = eval('('+result+')');
						//成功则关闭对话框并刷新数据
						if (res.success){
							$('#dlg').dialog('close');
							$('#dg').datagrid('reload');
						} 
						//提示
						$.messager.show({
							title: '提示',
							msg: res.msg
						});
					}
				});
			}
			//移除选中行
			function removeUser(){
				var row = $('#dg').datagrid('getSelected');
				if(row){
					//消息框
					$.messager.confirm('Confirm','Are you sure you want to remove this user?',function(r){
						//点击确认
						if(r){
							$.post('delete',{id:row.id},function(result){
								var res = eval('('+result+')');
								if (res.success){
									//重新加载该页数据
									$('#dg').datagrid('reload');
								}
								$.messager.show({
									title: '提示',
									msg: res.msg
								});
							});
						}
					});
				}
			}
			//按条件筛选
			function searchFilter(){
				var search_account = $('#search_account').val();
				var search_name = $('#search_name').val();
				//传递筛选条件重新加载
				$('#dg').datagrid('load',{
					search_name: search_name,
					search_account: search_account
				});
	        }
			
		</script>
	</head>
	<body>
		<h2>用户管理系统</h2>
		<!-- datagrid，通过url指定数据来源，toolbar指定头部工具栏，pagination显示分页工具栏-->
		<table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:400px;"
				url="getUsers"
				toolbar="#toolbar" pagination="true"
				rownumbers="true" fitColumns="true" singleSelect="true">
			<thead>
				<tr>
					<th field="id" width="50">ID</th>
					<th field="account" width="50">账号</th>
					<th field="name" width="50">姓名</th>
					<th field="phone" width="50">手机</th>
					<th field="email" width="50">邮箱</th>
					<th field="address" width="50">地址</th>
				</tr>
			</thead>
		</table>
		<div id="toolbar">
			<!-- 增、改、删按钮 -->
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeUser()">移除</a>
			<!-- 筛选工具栏 -->
			<div>
				<label>账号</label> 
				<input id="search_account" class="easyui-textbox" label="Search:" labelPosition="left">&nbsp;
				<label>姓名</label>
				<input id="search_name" class="easyui-textbox" label="Search:" labelPosition="left">&nbsp;
				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="searchFilter()">筛选</a>
			</div>
		</div>
		<!-- 对话框，用来填写用户信息和提交，buttons指定按钮组 -->
		<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"
				closed="true" buttons="#dlg-buttons">
			<div class="ftitle">User Information</div>
			<form id="fm" method="post">
				<div class="fitem">
					<label>账号:</label>
					<input name="account" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>姓名:</label>
					<input name="name" class="easyui-validatebox" required="true">
				</div>
				<div class="fitem">
					<label>手机:</label>
					<input name="phone" class="easyui-validatebox">
				</div>
				<div class="fitem">
					<label>邮箱:</label>
					<input name="email" class="easyui-validatebox" validType="email">
				</div>
				<div class="fitem">
					<label>住址:</label>
					<input name="address">
				</div>
			</form>
		</div>
		<!-- 提交和取消按钮 -->
		<div id="dlg-buttons">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">Save</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">Cancel</a>
		</div>
	</body>
	</html> 
	```
	
	在UserController中添加映射
	
	```
	    /*
	     * 用户管理界面
	     */
	    @RequestMapping(value="/list")  
	    public String showAllUsers(HttpServletRequest request,
	    		HttpServletResponse response){  
	        return "list";  
	    }   
	```
	
	效果如下：
	![这里写图片描述](http://img.blog.csdn.net/20170618220705195?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	新增
	![这里写图片描述](http://img.blog.csdn.net/20170618222755720?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	![这里写图片描述](http://img.blog.csdn.net/20170618220929398?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	![这里写图片描述](http://img.blog.csdn.net/20170618221018559?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	更新
	![这里写图片描述](http://img.blog.csdn.net/20170618221118561?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	![这里写图片描述](http://img.blog.csdn.net/20170618221201171?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	删除
	![这里写图片描述](http://img.blog.csdn.net/20170618221255375?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	![这里写图片描述](http://img.blog.csdn.net/20170618221327713?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
	筛选
	![这里写图片描述](http://img.blog.csdn.net/20170618221439784?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

## 8. 常见问题解决

出现 java.lang.ClassNotFoundException: org.springframework.web.context.ContextLoaderListener等明明在maven添加依赖却找不到类的错误

可以查看一下{eclipse:workspace目录}\ .metadata\ .plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\ {项目名称}\WEB-INF\lib下是否导入了包，没有说明是tomcat在发布项目的时候没有同时发布maven依赖所添加的jar包

解决：设置一下eclipse：项目 —> Properties -> Deployment Assembly -> Add -> Java Build Path Entries -> 选择Maven Dependencies -> Finish -> OK

## 9. 项目最终框架
![这里写图片描述](http://img.blog.csdn.net/20170619002152748?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)
![这里写图片描述](http://img.blog.csdn.net/20170619002229123?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvcWF6d3lj/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/SouthEast)

