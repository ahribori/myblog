<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<div class="col-lg-6 col-md-8 col-sm-12">
<div class="panel panel-primary">
	<div class="panel-heading">
	Spring security Login
	</div>
	<div class="panel-body">
	
	<form action="${initParam.root}login" method="post">
	  <div class="form-group">
	    <label>Username</label>
	    <input type="text" class="form-control" name="username" id="username" placeholder="Input your username">
	  </div>
	  <div class="form-group">
	    <label>Password</label>
	    <input type="password" class="form-control" name="password" id="passsword" placeholder="Input your password">
	  </div>
	  <button type="submit" class="btn btn-primary">Request</button>
	</form>			
	
	
	</div>
</div>
</div>

<script>
	$(function(){
		
		$('#username').focus();
		
		if('${param.error}'=='true') {
			alert('로그인 실패');
		}
	});
</script>