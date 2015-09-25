<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<div class="col-sm-12">
<c:if test="${category!=null}">
<form action="${initParam.root}post/write" method="post">
	<input type="hidden" name="categoryId" value="${category.categoryId}">
	<button type="submit" class="btn btn-primary"><i class="glyphicon glyphicon glyphicon-pencil"></i> ${category.name}에 글 쓰기</button>
</form>
</c:if>
<h2><span class="label label-success">${category.name}</span></h2>
<c:if test="${tag!=null}">
<h2><span class="label label-info">#${tag}</span></h2>
</c:if>
<hr style="border:0px">
<!-- Post -->

<c:choose>
	<c:when test="${empty listContainer.list && category!=null}">
	<div style="margin-top: 30px; margin-bottom: 30px;">
	<h2>카테고리가 비어있습니다.</h2>
	</div>
	<hr>
	</c:when>
	<c:when test="${empty listContainer.list}">
	<div style="margin-top: 30px; margin-bottom: 30px;">
	<h2>이 태그를 단 게시물이 존재하지 않습니다.</h2>
	</div>
	<hr>
	</c:when>
</c:choose>


<c:forEach var="post" items="${listContainer.list}">
    <div class="panel panel-default">
      	<div class="panel-heading"><a href="${initParam.root}post/${post.postId}" class="pull-right">View all</a> 
      	<h4><a href="${initParam.root}post/${post.postId}">#${post.postId}. ${post.title}</a></h4> 
		<a href="${initParam.root}category/${post.categoryId}"><span class="label label-success">${post.category.name}</span></a> 
		<c:forEach var="tag" items="${post.tags}">
		<a href="${initParam.root}tag/${tag.name}"><span class="label label-info">#${tag.name}</span></a>
		</c:forEach>
    </div>
     	<div class="panel-body">
        	<p><a href="${initParam.root}post/${post.postId}">
			<c:if test="${!empty post.thumbnailImagePathList}">
	        <p><img src="${post.thumbnailImagePathList[0]}" style="max-width:300px;max-height: 120px" class="img-thumbnail img-responsive pull-right"></p>
	        </c:if>
	        ${post.content}
	        </a></p>
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

<c:choose>
<c:when test="${category!=null}">

<!-- if category -->
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
    <li><a href="${initParam.root}category/${category.categoryId}/page/${page.pageCount}">${page.pageCount}</a></li>
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
	      <a href="${initParam.root}category/${category.categoryId}/page/${page.currentPage+1}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
  		</c:otherwise>
  	</c:choose>
  </ul>
</nav>
<!-- /if category -->
</c:when>
<c:otherwise>
<!-- if tag -->
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
	      <a href="${initParam.root}tag/${tag}/page/${page.currentPage-1}" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
    	</c:otherwise>
    </c:choose>
    
    <c:if test="${page.firstPageGroup==false}">
    <li><a href="${initParam.root}tag/${tag}/page/1">1</a></li>
    <li><a href="#">...</a></li>
    </c:if>
    
    <c:forEach var="p" begin="${page.beginPage}" end="${page.endPage}">
		<c:choose>
			<c:when test="${page.currentPage==p}">
    		<li class="active"><a href="#">${p}</a></li>
			</c:when>
			<c:otherwise>
    		<li><a href="${initParam.root}tag/${tag}/page/${p}">${p}</a></li>
			</c:otherwise>
		</c:choose>
    </c:forEach>
  
  	<c:if test="${page.lastPageGroup==false}">
    <li><a href="#">...</a></li>
    <li><a href="${initParam.root}tag/${tag}/page/${page.pageCount}">${page.pageCount}</a></li>
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
	      <a href="${initParam.root}tag/${tag}/page/${page.currentPage+1}" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
  		</c:otherwise>
  	</c:choose>
  </ul>
</nav>
<!-- /if tag -->
</c:otherwise>
</c:choose>


</c:if>
<!-- /Pagination -->

</div>