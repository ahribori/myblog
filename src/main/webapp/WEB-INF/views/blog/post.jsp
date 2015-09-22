<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 	<hr>
	${post.content}
	</div>
</div>