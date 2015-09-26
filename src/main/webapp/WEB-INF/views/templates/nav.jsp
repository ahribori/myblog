<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<!-- top nav -->
	<div class="navbar navbar-blue navbar-static-top">  
      <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="sr-only">Toggle</span>
          <span class="icon-bar"></span>
<span class="icon-bar"></span>
<span class="icon-bar"></span>
        </button>
        <a style="width: 145px" href="${initParam.root}" class="navbar-brand logo">ARIBORI.COM</a>
    	</div>
    	<nav class="collapse navbar-collapse" role="navigation">
      <form class="navbar-form navbar-left">
          <div class="input-group input-group-sm" style="max-width:360px;">
          <input type="text" class="form-control" placeholder="검색" name="srch-term" id="srch-term">
          <div class="input-group-btn">
            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
          </div>
        </div>
    </form>
    <ul class="nav navbar-nav">
      <li>
        <a href="${initParam.root}"><i class="glyphicon glyphicon-home"></i> 홈</a>
      </li>
      <li>
        <!--<a href="#postModal" role="button" data-toggle="modal"><i class="glyphicon glyphicon-plus"></i> Post</a>-->
        <a href="javascript:document.write.submit()" role="button" data-toggle="modal"><i class="glyphicon glyphicon-pencil"></i> 새 글 쓰기</a>
        <form name="write" action="${initParam.root}post/write" method="post"></form>
      </li>
      <li>
      	<a href="${initParam.root}category/config"><i class="glyphicon glyphicon-list"></i> 카테고리 관리</a>
      </li>
      <li>
        <!-- <a href="#"><span class="badge">badge</span></a> -->
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="glyphicon glyphicon-user"></i></a>
        <ul class="dropdown-menu">
		  <sec:authorize access="!isAuthenticated()">       
          <li><a href="${initParam.root}user/login_form">로그인</a></li>
          </sec:authorize>
		  <sec:authorize access="isAuthenticated()">
          <li><a href="${initParam.root}user/logout">로그아웃</a></li>
		  </sec:authorize>       
        </ul>
      </li>
    </ul>
  	</nav>
</div>
<!-- /top nav -->
	
<!--post modal-->
<div id="postModal" class="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
  <div class="modal-content">
      <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
			Update Status
      </div>
      <div class="modal-body">
          <form class="form center-block">
            <div class="form-group">
              <textarea class="form-control input-lg" autofocus="" placeholder="What do you want to share?"></textarea>
            </div>
          </form>
      </div>
      <div class="modal-footer">
          <div>
          <button class="btn btn-primary btn-sm" data-dismiss="modal" aria-hidden="true">Post</button>
            <ul class="pull-left list-inline"><li><a href=""><i class="glyphicon glyphicon-upload"></i></a></li><li><a href=""><i class="glyphicon glyphicon-camera"></i></a></li><li><a href=""><i class="glyphicon glyphicon-map-marker"></i></a></li></ul>
		  </div>	
      </div>
  </div>
  </div>
</div>