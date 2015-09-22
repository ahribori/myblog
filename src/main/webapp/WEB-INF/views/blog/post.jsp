<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<div class="panel panel-default">
  <div class="panel-heading"><h4>#${post.postId}. ${post.title}</h4>
	<span class="label label-default">#태그1</span> 
	<span class="label label-primary">#태그2</span> 
	<span class="label label-success">#태그3</span> 
	<span class="label label-info">#태그4</span> 
	<span class="label label-warning">#태그5</span> 
	<span class="label label-danger">#태그6</span>
  </div>
 	<div class="panel-body">
 	<i class="glyphicon glyphicon glyphicon-eye-open"></i> ${post.hits}
    <i class="glyphicon glyphicon glyphicon glyphicon-comment"></i>
    <i class="glyphicon glyphicon glyphicon glyphicon-time"></i> ${post.regDate}
    <button class="btn btn-danger btn-xs pull-right" onclick="remove_post()">삭제</button> 
    <button class="btn btn-warning btn-xs pull-right" onclick="javascript:document.update.submit()">수정</button>
    <form:form name="remove" action="${initParam.root}post/${post.postId}" method="delete"></form:form>
    <form:form name="update" action="${initParam.root}post/update" method="put">
    	<input type="hidden" name="postId" value="${post.postId}">
    </form:form>
 	<hr>
	${post.content}
	</div>
</div>
<script type="text/javascript">
	function remove_post() {
		var flag = confirm('정말 삭제하시겠습니까?');
		if(flag) document.remove.submit();
	}
</script>