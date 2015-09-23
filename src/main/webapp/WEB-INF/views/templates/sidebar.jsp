<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- sidebar -->
<div class="column col-sm-2 col-xs-1 sidebar-offcanvas" id="sidebar">
  
  	<ul class="nav">
	<li><a href="#" data-toggle="offcanvas" class="visible-xs text-center"><i class="glyphicon glyphicon-chevron-right"></i></a></li>
	</ul>
   
    <ul class="nav hidden-xs" id="lg-menu">
    <c:forEach var="category" items="${categories}">
        <li><a href="#featured"><i class="glyphicon glyphicon-${category.glyphicon}"></i> ${category.name}</a></li>
    </c:forEach>
        <li><a href="#stories"><i class="glyphicon glyphicon-list"></i> Stories</a></li>
        <li><a href="#"><i class="glyphicon glyphicon-paperclip"></i> Saved</a></li>
        <li><a href="#"><i class="glyphicon glyphicon-refresh"></i> Refresh</a></li>
    </ul>
    <ul class="list-unstyled hidden-xs" id="sidebar-footer">
        <li>
          <a href="${initParam.root}"><h3>아리보리's 블로그</h3> <i class="glyphicon glyphicon-heart-empty"></i> aribori.com</a>
        </li>
    </ul>
  
  	<!-- tiny only nav-->
  	<ul class="nav visible-xs" id="xs-menu">
  	<c:forEach var="category" items="${categories}">
      	<li><a href="#featured" class="text-center"><i class="glyphicon glyphicon-${category.glyphicon}"></i></a></li>
  	</c:forEach>
        <li><a href="#stories" class="text-center"><i class="glyphicon glyphicon-list"></i></a></li>
      	<li><a href="#" class="text-center"><i class="glyphicon glyphicon-paperclip"></i></a></li>
        <li><a href="#" class="text-center"><i class="glyphicon glyphicon-refresh"></i></a></li>
    </ul>
  
</div>
<!-- /sidebar -->