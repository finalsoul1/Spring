"# spring-boot-mybatis-board" 
# 작업순서

## SQL 쿼리를 로그로 출력하는 설정

### pom.xml
```
<!-- Need this to compile JSP -->
		<dependency>
			<groupId>org.apache.tomcat.embed</groupId>
			<artifactId>tomcat-embed-jasper</artifactId>
			<scope>provided</scope>
		</dependency>
		
		<dependency>
			<groupId>org.bgee.log4jdbc-log4j2</groupId>
			<artifactId>log4jdbc-log4j2-jdbc4.1</artifactId>
			<version>1.16</version>
		</dependency>
```


* 커넥션 객체와 대화하는 driver를 포장 -> DriverSpy
DriverSpy가 디비에 쿼리를 보내며 로그를 찍는 일까지 수행

### application.properties
```
spring.datasource.driver-class-name=net.sf.log4jdbc.sql.jdbcapi.DriverSpy
spring.datasource.url=jdbc:log4jdbc:h2:mem:TESTDB;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
logging.config=classpath:logback-spring.xml
```

### logback-spring.xml
```
<logger name="jdbc" level="OFF" />
	<logger name="jdbc.sqlonly" level="DEBUG" additivity="false">
		<appender-ref ref="STDOUT" />
		<appender-ref ref="FILE" />
	</logger>
	<logger name="jdbc.resultsettable" level="DEBUG" additivity="false">
		<appender-ref ref="STDOUT" />
		<appender-ref ref="FILE" />
	</logger>
```

### log4jdbc.log4j2.properties
```
log4jdbc.spylogdelegator.name=net.sf.log4jdbc.log.slf4j.Slf4jSpyLogDelegator
```

# 첫 화면 처리순서

## LOGIN