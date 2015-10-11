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
					<td><span style="color:white;background-color:black;" class="badge">${category.postCount}</span></td>
					<td><i class="glyphicon glyphicon-${category.glyphicon}"></i></td>
					<td>
						<button onclick="show_category_update_form('${category.categoryId}','${category.name}','${category.priority}','${category.glyphicon}')" class="btn btn-xs btn-warning">수정</button>
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
	$(function(){
		$('#category_update_div').hide();
	});

	function category_delete_confirm(category_id) {
		var flag = confirm('카테고리를 삭제하면 해당 카테고리의 게시물도 같이 삭제됩니다. 정말 삭제하시겠습니까?');
		if (flag)
			document.getElementById('category_'+ category_id+'_delete').submit();
		return flag;
	}
	
	function show_category_update_form (categoryId,name,priority,glyphicon) {
		$('#category_update_div').show();
		
		var frm = document.forms["category_update_form"];
		frm[1].value = name;
		frm[2].value = glyphicon;
		frm[3].value = categoryId;
		frm[4].value = priority;
		
	}
	
</script>
	
<div class="col-sm-4">
	<div id="category_update_div" class="panel panel-default">
	<div class="panel-heading"><h4><i class="glyphicon glyphicon-wrench"></i> 카테고리 수정</h4></div>
	<div class="panel-body">
		<form:form name="category_update_form" action="${initParam.root}/category" method="put" commandName="category">
			<label>카테고리명</label>
			<form:input type="text" name="name" path="name" class="form-control" placeholder="카테고리명을 입력하세요"/>
		 	<font color="red"><form:errors path="name"/></font>
			<br>
			<label>아이콘</label>
			<input type="text" name="glyphicon" class="icon-picker" />
	        <label></label>
	        <input type="hidden" name="categoryId" value="">
	        <input type="hidden" name="priority" value="">
	        <button type="submit" class="btn btn-warning btn-block"><i class="glyphicon glyphicon-wrench"></i> 수정</button>
		</form:form>	
	</div>
	</div>

	<div class="panel panel-default">
	<div class="panel-heading"><h4><i class="glyphicon glyphicon-list"></i> 카테고리 만들기</h4></div>
	<div class="panel-body">
		<form:form action="${initParam.root}/category" method="post" commandName="category">
			<label>카테고리명</label>
			<form:input type="text" name="name" path="name" class="form-control" placeholder="카테고리명을 입력하세요"/>
		 	<font color="red"><form:errors path="name"/></font>
			<br>
			<label>아이콘</label>
			<input type="text" name="glyphicon" class="icon-picker" />
	        <label></label>
	        <button type="submit" class="btn btn-primary btn-block"><i class="glyphicon glyphicon-list"></i> 만들기</button>
		</form:form>	
	</div>
	</div>
</div>


<!-- Bootstrap-Iconpicker -->
<link rel="stylesheet" href="${initParam.root}resources/css/icon-picker.min.css"/>
<!-- Bootstrap-Iconpicker -->
<script type="text/javascript" src="${initParam.root}resources/js/iconPicker.min.js"></script>

<script type="text/javascript">
        $(function () {
            $(".icon-picker").iconPicker();
        });
</script>
