# web에서 Server에 요청하기  

## Request로 요청하고 Response로 받기  
* server의 controller에게 요청을하고 이때 데이터도 보낼수 있다  
* server에게 요청을 하면 server는 web에게 보여줄 데이터를 준비하고 데이터를 가공하여 
	보기좋게 ui까지 구성하여 response한다
* 전통적인 client/server web app의 흐름이다  
* 어떤 방식으로 server에게 요청을 하든 서버는 결국 자신의 view와 데이터를 결합하여  
	사용하게 html의 결과를 response한다.  

##	Ajax(fetch)로 요청하고 response로 받기  
* web의 script에서 server의 controller에게 요청을 하고 이때 데이터도 보낼수 있다  
* Ajax로 요청을 할때는 server가 형식이 갖추어진 데이터를 응답하고 뒷일은 web의 script에서 처리한다라는 무언의 약속이 있다  
* web에서 요청을 할때 단순한 요청 (delete)을 하면 요청한 데이터에 따라 server에서 처리를 수행하고 응답은 성공,실패 또는 기타 등의단순한 메시지만
보내게 된다  
* web에서는 단순한 응답을 받고 script를 사용하여 다른일들을 수행한다  
* ajax로 요청을 한다는것은 서버로부터 단순한 응답을 받을것을 기대하고 요청을하게된다

