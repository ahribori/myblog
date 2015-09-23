<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<div class="col-sm-8">
	<div class="panel panel-default">
	<div class="panel-heading"><h4><i class="glyphicon glyphicon-list"></i> 카테고리 관리</h4></div>
	<div class="panel-body">
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th>#</th>
					<th>카테고리명</th>
					<th>순서</th>
					<th>게시물 수</th>
					<th>아이콘</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="category" items="${categories}">
				<tr>
					<td>
						<form:form id="category_${category.categoryId}_up" action="${initParam.root}category/up" method="PUT">
							<input type="hidden" name="categoryId" value="${category.categoryId}">
						</form:form>
						<form:form id="category_${category.categoryId}_down" action="${initParam.root}category/down" method="PUT">
							<input type="hidden" name="categoryId" value="${category.categoryId}">
						</form:form>
						<button onclick="javascript:document.getElementById('category_${category.categoryId}_down').submit()"><i class="glyphicon glyphicon-arrow-up"></i></button>
						<button onclick="javascript:document.getElementById('category_${category.categoryId}_up').submit()"><i class="glyphicon glyphicon-arrow-down"></i></button>
					</td>
					<td>${category.categoryId}</td>
					<td>${category.name}</td>
					<td>${category.priority}</td>
					<td><span style="color:white;background-color:black;" class="badge">${category.postCount}</span></td>
					<td><i class="glyphicon glyphicon-${category.glyphicon}"></i></td>
					<td>
						<button onclick="category_delete_confirm(${category.categoryId});" 
						class="btn btn-xs btn-danger">삭제</button>
						<form:form id="category_${category.categoryId}_delete" action="${initParam.root}category/${category.categoryId}" method="delete"></form:form>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	</div>
</div>

<script type="text/javascript">
	function category_delete_confirm(category_id) {
		var flag = confirm('카테고리를 삭제하면 해당 카테고리의 게시물도 같이 삭제됩니다. 정말 삭제하시겠습니까?');
		if (flag)
			document.getElementById('category_'+ category_id+'_delete').submit();
		return flag;
	}
</script>
	
<div class="col-sm-4">
	<div class="panel panel-default">
	<div class="panel-heading"><h4><i class="glyphicon glyphicon-list"></i> 카테고리 만들기</h4></div>
	<div class="panel-body">
		<form:form action="${initParam.root}/category" method="post">
			<label>카테고리명</label>
			<input type="text" name="name" class="form-control" placeholder="카테고리명을 입력하세요"><br>
			<label>아이콘 (추후에 iconpicker로 변경예정)</label>
			<li>
	          <span class="glyphicon glyphicon-asterisk" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-asterisk</span>
			  <input type="radio" name="glyphicon" value="asterisk" checked="checked">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-plus</span>
			  <input type="radio" name="glyphicon" value="plus">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-euro" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-euro</span>
			  <input type="radio" name="glyphicon" value="euro">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-minus" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-minus</span>
			  <input type="radio" name="glyphicon" value="minus">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-cloud" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-cloud</span>
			  <input type="radio" name="glyphicon" value="cloud">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-envelope</span>
			  <input type="radio" name="glyphicon" value=envelope"">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-pencil</span>
			  <input type="radio" name="glyphicon" value="pencil">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-glass" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-glass</span>
			  <input type="radio" name="glyphicon" value="glass">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-music" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-music</span>
			  <input type="radio" name="glyphicon" value="music">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-search</span>
			  <input type="radio" name="glyphicon" value="search">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-heart" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-heart</span>
			  <input type="radio" name="glyphicon" value="heart">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-star</span>
			  <input type="radio" name="glyphicon" value="star">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-star-empty</span>
			  <input type="radio" name="glyphicon" value="star-empty">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-user</span>
			  <input type="radio" name="glyphicon" value="user">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-film" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-film</span>
			  <input type="radio" name="glyphicon" value="film">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-th-large" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-th-large</span>
			  <input type="radio" name="glyphicon" value="th-large">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-th" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-th</span>
			  <input type="radio" name="glyphicon" value="th">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-th-list</span>
			  <input type="radio" name="glyphicon" value="th-list">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-ok</span>
			  <input type="radio" name="glyphicon" value="ok">
	        </li>
	        <li>
	          <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
	          <span class="glyphicon-class">glyphicon glyphicon-remove</span>
			  <input type="radio" name="glyphicon" value="remove">
	        </li>
	        <label></label>
	        <button type="submit" class="btn btn-primary btn-block">만들기</button>
		</form:form>	
	</div>
	</div>
</div>
