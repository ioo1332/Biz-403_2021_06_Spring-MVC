# pagination  
* 많은 데이터 list가 select 되었을때 전체 list를 한 화면에 보여주면 보는데 상당히 에러사항이 있을것이다  
* 한 화면에 일정 list의 분량만 보여주고  
* list하단에 page navigation을 표현하여  
* page num을 클릭하면 이후 list를 조회하여 보여주는 방식  

## pagination 설계할때 요구사항  
* 한 화면에 몇개의 list를 보여줄것인가 : 보통 10개  
* page navigation 개수는 몇개 : 5개또는 10개정도 표현 
* 처음으로 가기 : 1 page list 보기  
* 끝으로 가기 : 제일 마지막 list중에 보이기  
* 이전으로가기,이후로 가기 : 현재 보고있는 page에서 앞,뒤로 가기

* 보고있는 화면에서 page nav 번호를 클릭했을때 controller에 전달하는값
page num만 전달하기 검색어와 함께 전달하기 ,검색어 정렬기준과 함께 전달하기

## 이 프로젝트에서 pagination 구현하기  
* sql의 select는 표준 sql select만 사용하기  
* java코드에서 pagination구현하기  
* 1.8미만에서 사용하는 코드 1.8이상에서 구현하는코드  
* 1.8 이상의 코드 : Lambda,Stream(List데이터에 대한)




