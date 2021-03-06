#Spring MyBatis Project  

#### Dependency 설정  
* mybatis : 최신버전  
* mybatis spring : 최신버전  
* commons-dbcp2 : 최신버전 (commons-dbcp와 다름)  

### commons-dbcp2  
* apach 재단에서 만든 DB Connection도구  
* DB연결을 pool을 상요하여 많은 동시 접속을 효율적으로 처리  
* 기본적으로 DB연결 Connection 미리 다수(10개) 를 만들어두고 연결요청이 오면 그중 1개를 연결하는 통로를 제공한다  

### mybatis  
* mybatis 는 DB연동과 관련된 상당히 많은 부분의 코드를 직접작성하지않고 수행할수 있도록 도와주는 DB연결 Library  
* 현재 진행형의 DB연동이 이루어지는 Spring Project에서는 거의 mybatis를 활용한 DB연결이 이루어진다.  

# Spring DB연동 project 작성  
1. 기본 Spring MVC 프로젝트 생성  
2. pom.xml 에 관련된 기본 Dependency설정  
3. mybatis 관련 Dependency 설정  
4. 여기까지 기본 프로젝트가 정상적으로 구동되는지 확인하기  
5. mybatis-context.xml을 작성하기  
6. DBMS에 table 생성하기, 테스트용 데이터 insert  
7. model class (VO,DTO) 생성하기  
8. DAO 생성하기 , Service 생성하기, Controller 생성하기  
9. Client에서 Request하여 Controller에 요청하고 데이터가 정상적으로 select되는지 log를 통해서 확인