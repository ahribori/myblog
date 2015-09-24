<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<div class="col-sm-12">
<form action="${initParam.root}post/write" method="post">
	<input type="hidden" name="categoryId" value="${category.categoryId}">
	<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon glyphicon-pencil"></i> 여기에 글 쓰기</button>
</form>
<h2><span class="label label-success">${category.name}</span></h2>
<hr style="border:0px">
<!-- Post -->

<c:if test="${empty listContainer.list}">
<div style="margin-top: 30px; margin-bottom: 30px;">
	<h2>카테고리가 비어있습니다.</h2>
</div>
<hr>
</c:if>


<c:forEach var="post" items="${listContainer.list}">
    <div class="panel panel-default">
      	<div class="panel-heading"><a href="#" class="pull-right">View all</a> 
      	<h4><a href="${initParam.root}post/${post.postId}">#${post.postId}. ${post.title}</a></h4> 
		<a href="${initParam.root}category/${post.categoryId}/page/1"><span class="label label-success">${post.category.name}</span></a> 
		<c:forEach var="tag" items="${post.tags}">
		<span class="label label-info">#${tag.name}</span> 
		</c:forEach>
    </div>
       <div class="panel-body">
         <p><img src="//placehold.it/150x150" class="img-circle pull-right"> <a href="${initParam.root}post/${post.postId}">${post.content}</a></p>
         <div class="clearfix"></div>
         <hr>
         <i class="glyphicon glyphicon glyphicon-eye-open"></i> ${post.hits}
         <i class="glyphicon glyphicon glyphicon glyphicon-comment"></i>
         <i class="glyphicon glyphicon glyphicon glyphicon-time"></i> ${post.regDate}
       </div>
    </div>
</c:forEach>
<!-- /Post -->
<!-- Pagination -->
<c:set var="page" value="${listContainer.page}"/>
<c:if test="${!empty listContainer.list}">
<nav>
  <ul class="pagination">
    
    <c:choose>
    	<c:when test="${page.currentPage==1}">
	    <li class="disabled">
	      <a href="#" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
    	</c:when>
    	<c:otherwise>
	    <li>
	      <a href="${initParam.root}category/${category.categoryId}/page/${page.currentPage-1}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
    	</c:otherwise>
    </c:choose>
    
    <c:if test="${page.firstPageGroup==false}">
    <li><a href="${initParam.root}category/${category.categoryId}/page/1">1</a></li>
    <li><a href="#">...</a></li>
    </c:if>
    
    <c:forEach var="p" begin="${page.beginPage}" end="${page.endPage}">
		<c:choose>
			<c:when test="${page.currentPage==p}">
    		<li class="active"><a href="#">${p}</a></li>
			</c:when>
			<c:otherwise>
    		<li><a href="${initParam.root}category/${category.categoryId}/page/${p}">${p}</a></li>
			</c:otherwise>
		</c:choose>
    </c:forEach>
  
  	<c:if test="${page.lastPageGroup==false}">
    <li><a href="#">...</a></li>
    <li><a href="#">${page.pageCount}</a></li>
  	</c:if>
  	
  	<c:choose>
  		<c:when test="${page.currentPage==page.pageCount}">
	    <li class="disabled">
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
  		</c:when>
  		<c:otherwise>
	    <li>
	      <a href="#" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
  		</c:otherwise>
  	</c:choose>
  </ul>
</nav>
</c:if>
<!-- /Pagination -->

</div>