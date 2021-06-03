# WAS(Web Application Service ,Web Application  server:tomcat 에서 HTTP status

## 정상적인 request와 response가 이루어졌을때  
*200:가장완벽한상태  
*300:redirection이 되거나 이전 응답과 동일한 결과일때  

## Request가 잘못되었을때  
*404:uri를 잘못요청했을때  
tomcat server의 method에서 rending할 jsp파일을 못찾았을때  
405:requset한 uri의 mapping을 찾을수 있으나 requestMethod가 해당하는 항목이 없을때  
400:서버에 데이터를 전송했을때 데이터 type이 잘못되었을경우
java method의 매개변수가 숫자형인데 전송하는 데이터의 공백 문자열 null값이 포함되어있을 경우

##서버 내부 오류
*500 내부에서 코드가 실행되는동안 exception이 발생하는경우 오류메시지를 검토하여 잘 찾아야한다
개발자가 만든 코드 메시지 찾기,exception 종류 이해하기