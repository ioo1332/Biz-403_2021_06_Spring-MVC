# spring file upload project
* web client에서 file을 선택하여 서버에 upload하기
* 이미지 게시판, 이미지 갤러리 등을 만들때 사용한다

## 필요한 dependency

		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.10.0</version>
		</dependency>
		
		<dependency>
			<groupId>commons-fileupload</groupId>
			<artifactId>commons-fileupload</artifactId>
			<version>1.4</version>
		</dependency>
		
## root-context.xml에 file up설정
	
	<!-- file upload와 관련한 bean을 설정하기 -->
	<!-- 단위 0:개..
		000:k
		000,000:m
		000,000,000:g
		000,000,000,000:t
		 
	 -->
	<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
		<property name="maxUploadSize" value="35000000"/>
		<property name="maxInMemorySizePerFile" value="3500000"/>
	</bean>	
	
* maxInMemorySizePerFile:	
