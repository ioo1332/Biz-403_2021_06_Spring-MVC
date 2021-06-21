#Spring No Qualifying Bean 오류 찾기  
### 원인  
* 클래스를 컴파일하여 객체로 준비하지 못하였다  
* bean으로 설정된 부분에 문제가 있다  
* @Controller(controller.service,Repository)설정 문제  

### 해결방법  
* -content.xml 파일에 사용하고자 하는 클래스를 bean으로 설정했는가 확인  
각 클래스마다 bean설정 방법에 따라 정확히 문법이 구현되었는가  
* web.xml에서 해당 -context.xml파일을 잘 읽고 있는가 appServlet/*-content.xml 설정으로 해결가능  
* servlet-context.xml의 component-scan base-package 항목의 package설정이 잘되었지 확인  
* 각 component 클래스의 component annotation이 잘 설정되었는지 확인  
* 한개의 interface를 상속받은 클래스가 다수 있을때 사용하고자 하는 클래스를 잘 지정했는가  

