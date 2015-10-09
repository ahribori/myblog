<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<script src="<c:url value='/resources/js/prism.js'/>"></script>
<link href="<c:url value='/resources/css/prism.css'/>" rel="stylesheet">
<div class="panel panel-default">
  <div class="panel-heading"><h4>${post.title}</h4>
	<a href="${initParam.root}category/${post.categoryId}"><span class="label label-success">${post.category.name}</span></a> 
	<c:forEach var="tag" items="${post.tags}">
	<a href="${initParam.root}tag/${tag.name}"><span class="label label-info">#${tag.name}</span></a>
	</c:forEach>
  </div>
 	<div class="panel-body">
 	<i class="glyphicon glyphicon glyphicon-eye-open"></i> ${post.hits}
    <i class="glyphicon glyphicon glyphicon glyphicon-comment"></i>
    <i class="glyphicon glyphicon glyphicon glyphicon-time"></i> ${post.calculatedRegDate}
    <sec:authorize access="isAuthenticated()">
    <button class="btn btn-danger btn-xs pull-right" onclick="remove_post()">삭제</button> 
    <button class="btn btn-warning btn-xs pull-right" onclick="javascript:document.update.submit()">수정</button>
    <form:form name="remove" action="${initParam.root}post/${post.postId}" method="delete"></form:form>
    <form:form name="update" action="${initParam.root}post/update" method="put">
    	<input type="hidden" name="postId" value="${post.postId}">
    </form:form>
    </sec:authorize>
 	<hr>
	${post.content}
	
	<hr>
	<!-- Comment -->
	
	<c:forEach var="comment" items="${comments}">
	<c:choose>
		<c:when test="${comment.isChild==true}">
		<div style="margin-left: 64px;margin-top: 15px">
		<div class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="pull-left" src="/blog/resources/images/user/default.jpg" style="margin-right:10px;width: 64px;height: 64px" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <strong style="font-size: 16px">${comment.writer}</strong> 
		    <font style="color: #A4A4A4; font-size: 12px">
		    ${comment.calculatedRegDate} | [${comment.ipAddr}] | 
		    <i class="glyphicon glyphicon-pencil"></i>
		  	<i class="glyphicon glyphicon-remove"></i>
		    </font>
		    <div>${comment.comment}</div>
		  </div>
		</div>
		</div>
		</c:when>
		<c:when test="${comment.isSecret==true}">
		<sec:authorize access="isAuthenticated()">
		<div class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="pull-left" src="/blog/resources/images/user/default.jpg" style="margin-right:10px;width: 64px;height: 64px" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <strong style="font-size: 16px">${comment.writer}</strong> 
		    <font style="color: #A4A4A4; font-size: 12px">
		    ${comment.calculatedRegDate} | [${comment.ipAddr}] | 
		    <i class="glyphicon glyphicon-pencil"></i>
		  	<i class="glyphicon glyphicon-remove"></i>
		    </font>
		    <div>${comment.comment}</div>
		  </div>
		</div>
		</sec:authorize>
		<sec:authorize access="!isAuthenticated()">
		<div class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="pull-left" src="/blog/resources/images/user/default.jpg" style="margin-right:10px;width: 64px;height: 64px" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <strong style="font-size: 16px">${comment.writer}</strong> 
		    <font style="color: #A4A4A4; font-size: 12px">
		    ${comment.calculatedRegDate} | [${comment.ipAddr}] | 
		    <i class="glyphicon glyphicon-pencil"></i>
		  	<i class="glyphicon glyphicon-remove"></i>
		    </font>
		    <div style="color: red">관리자만 볼 수 있는 비밀댓글입니다.</div>
		  </div>
		</div>
		</sec:authorize>
		</c:when>
		<c:otherwise>
		<div class="media">
		  <div class="media-left">
		    <a href="#">
		      <img class="pull-left" src="/blog/resources/images/user/default.jpg" style="margin-right:10px;width: 64px;height: 64px" alt="...">
		    </a>
		  </div>
		  <div class="media-body">
		    <strong style="font-size: 16px">${comment.writer}</strong> 
		    <font style="color: #A4A4A4; font-size: 12px">
		    ${comment.calculatedRegDate} | [${comment.ipAddr}] | <a href="#" onclick="open_recomment_form(${comment.commentId})">댓글 달기</a> |
		    <i class="glyphicon glyphicon-pencil"></i>
		  	<i class="glyphicon glyphicon-remove"></i>
		    </font>
		    <div>${comment.comment}</div>
		  </div>
		</div>
		<!-- 댓글의 댓글 Form -->
		<div id="recommentFormDiv_${comment.commentId}" class="recommentFormDiv" style="margin-left: 64px;"><hr>
		<form:form name="commentForm" action="${initParam.root}post/${post.postId}/comment" method="post" commandName="comment" class="form-inline">
		<input type="hidden" name="refId" value="${comment.commentId}">
		<div class="form-group">
			<form:input type="text" path="writer" name="writer" class="form-control" placeholder="작성자" />
		</div>
		<font color="red"><form:errors path="writer"></form:errors></font>
		<div class="form-group">
			<form:input type="password" path="passwd" name="passwd" class="form-control" placeholder="비밀번호" />
		</div>
		<font color="red"><form:errors path="passwd"></form:errors></font>
		<form:textarea name="comment" path="comment" style="margin-top: 20px; margin-bottom: 20px;" class="form-control" rows="4" cols="5"
		placeholder="내용을 입력하세요"/>
		<div style="margin-bottom: 10px">
		<font color="red"><form:errors path="comment"></form:errors></font>
		</div>
		<button type="submit" class="btn btn-success">댓글 달기</button>
		</form:form>
		<hr>
		</div>
		<!-- //댓글의 댓글 Form -->
		</c:otherwise>
	</c:choose>
	</c:forEach>
	<!-- //Comment -->
	
	<hr>
	
	<form:form name="commentForm" action="${initParam.root}post/${post.postId}/comment" method="post" commandName="comment" class="form-inline">
		<div class="form-group">
			<form:input type="text" path="writer" name="writer" class="form-control" placeholder="작성자" />
		</div>
		<font color="red"><form:errors path="writer"></form:errors></font>
		<div class="form-group">
			<form:input type="password" path="passwd" name="passwd" class="form-control" placeholder="비밀번호" />
		</div>
		<font color="red"><form:errors path="passwd"></form:errors></font>
		<div class="checkbox">
			<label> <input type="checkbox" name="secret"> 비밀글 </label>
		</div>
		<form:textarea name="comment" path="comment" style="margin-top: 20px; margin-bottom: 20px;" class="form-control" rows="4" cols="5"
		placeholder="내용을 입력하세요"/>
		<div style="margin-bottom: 10px">
		<font color="red"><form:errors path="comment"></form:errors></font>
		</div>
		<button type="submit" class="btn btn-success">댓글 달기</button>
	</form:form>


	</div>
</div>
<script src="${initParam.root}resources/js/application.js"></script>
<script type="text/javascript">
	$(function(){
		$('pre').addClass('line-numbers');
		$('.recommentFormDiv').hide();
		
		$('form[name=commentForm]').submit(function(){
			return validForm(this);
		});
	})
	
	function validForm(form){
		if(form.writer.value=="") {
			alert('작성자를 입력하세요');
			return false;
		} else if (form.passwd.value=="") {
			alert('비밀번호를 입력하세요')
			return false;
		} else if (form.passwd.value.length<4 || form.passwd.value.length>20) {
			alert('비밀번호는 4자 이상 20자 이하만 가능합니다');
			return false;
		} else if (form.comment.value=="") {
			alert('내용을 입력하세요');
			return false;
		}
	}
	
	var open_recomment_form_no = 0;
	
	function open_recomment_form(commentNo) {
		if(open_recomment_form_no != commentNo) {
			$('.recommentFormDiv').hide();
			$('#recommentFormDiv_'+commentNo).show(100);
			open_recomment_form_no = commentNo;
		} else {
			$('.recommentFormDiv').hide(100);
			open_recomment_form_no = 0;
		}
	}

	function remove_post() {
		var flag = confirm('정말 삭제하시겠습니까?');
		if(flag) document.remove.submit();
	}
</script>