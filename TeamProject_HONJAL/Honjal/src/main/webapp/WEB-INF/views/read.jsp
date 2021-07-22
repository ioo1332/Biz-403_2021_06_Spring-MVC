<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<div class="main_box read_box">

		<div class="ud_box">
		<c:if test="${CONTENT.member_num == MEMBER.member_num}">
	        <button class="btn_update">수정</button>
	        <button class="btn_delete">삭제</button>
		</c:if>
		</div>
		<!-- 작성자에게만 수정,삭제 버튼 보이게 -->
      
      <section class="content_box">
        <h3 class="content_title">${CONTENT.content_title}</h3>
        <div class="content_w_box">
          <p class="content_date">${CONTENT.content_date} ${CONTENT.content_time}</p>
          <div class="content_member">
            <p>${CONTENT.member_nname}</p>
            <img src="${rootPath}/static/images/user.png" class="member_img" />
          </div>
        </div>
        <div class="content_text">
          <p>${CONTENT.content_text}</p>
        </div>
        <div class="content_bottom">
        	<c:if test="${MENU == 'TIP' || MENU == 'INT' || MENU == 'REV'}">
        		<c:choose>
        			<c:when test="${GOOD == 1}">
        				<img src="${rootPath}/static/images/img_good2.png" id="good" />
        			</c:when>
        			<c:otherwise>
        				<img src="${rootPath}/static/images/img_good1.png" id="good" />
        			</c:otherwise>
        		</c:choose>
        		
        	</c:if>
        </div>
      </section>
      
    <section class="comment_box">
      <p>댓글 2</p>
      <hr />
      <c:forEach items="${COMMENT}" var="COMMENT">

         <table id="tb_comment_list">
            <tr>
               <td width="5%" class="cm_img"><img
                  src="${rootPath}/static/images/user.png" /></td>
               <td width="10%" class="cm_name">${COMMENT.comment_writer}</td>
               <td width="70%" class="cm_cm">${COMMENT.comment_text}<span>${COMMENT.comment_time}</span>
               </td>
               <td width="7%" class="cm_btn">
                  <button class="update">수정</button>
               </td>
               <td width="7%" class="cm_btn1">
                  <button class="delete">삭제</button>
               </td>
            </tr>
         </table>
      </c:forEach>
   </section>

   <form id="comment_form" method="POST">
      <section class="comment_box">
         <table id="tb_comment">
            <tr>
               <td width="5%" class="cm_img"><img
                  src="${rootPath}/static/images/user.png" /></td>
               <td width="10%" class="cm_name">
               <c:if test="${not empty MEMBER}">
                   ${MEMBER.member_nname}
                  </c:if></td>
               <td width="70%"><textarea name="comment_text" placeholder="댓글 내용을 입력하세요"></textarea>
               </td>
               <td width="15%" class="cm_btn">
                  <button class="insert">등록</button>
               </td>
            </tr>
         </table>
      </section>
   </form>
      
</div>

<script>

let update_button = document.querySelector(".btn_update")
let delete_button = document.querySelector(".btn_delete")
let rootPath = "${rootPath}/board"

if(update_button) {
	update_button.addEventListener("click",(e)=>{
		location.href = rootPath + "/update?content_num=${CONTENT.content_num}"
	})
}

if(delete_button) {
	delete_button.addEventListener("click",(e)=>{
		let menu = "${CONTENT.board_code}".substr(0,3).toLowerCase()

		if(confirm("글을 삭제하시겠습니까?")) {
			location.replace(rootPath + "/" + menu + "/delete?content_num=${CONTENT.content_num}")
		}
	})
}


let button_good = document.getElementById("good")
if(button_good) {
	button_good.addEventListener("click", (e)=>{
		if(!"${MEMBER}" ) {
			if(confirm("로그인 후 이용 가능합니다")) {
				location.href = "${rootPath}"
			}
		} else {
			fetch("${rootPath}/board/good/${CONTENT.content_num}")
			.then(response=>response.text())
			.then(result=>{
				if(result === "INSERT") {
					alert("추천하셨습니다")
					button_good.src = "${rootPath}/static/images/img_good2.png"
				} else if(result === "DELETE") {
					alert("추천이 취소되었습니다")
					button_good.src = "${rootPath}/static/images/img_good1.png"
				}
			})
		}
	})
}

document.querySelector(".insert").addEventListener("click",(e)=>{
	fetch("${rootPath}/board/read/comment?content_num=${CONTENT.content_num}")
	
	.then(response=>response.text())
	.then(result=>{
		if(result === "COMMENT_OK"){
			document.querySelector("form").submit()	
		}
	})
})

</script>