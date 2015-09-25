<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<script src="${initParam.root}resources/ckeditor/ckeditor.js"></script>

<script src="${initParam.root}resources/tagsinput/bootstrap-tagsinput.min.js"></script>
<link href="${initParam.root}resources/tagsinput/bootstrap-tagsinput.css" rel="stylesheet">
<script type="text/javascript">
	$(function(){
		$('#tagString').tagsinput({
		  confirmKeys: [13, 32, 44]
		});
	});
	
	function setTags(tag) {
		$('#tagString').tagsinput('add', tag);
	}
</script>

<form:form id="post_update_form" action="${initParam.root}post/${post.postId}" method="put" commandName="post">
	
	<label>카테고리</label>
	<form:select name="categoryId" path="categoryId" class="form-control">
		<c:forEach var="category" items="${categories}">
			<c:choose>
				<c:when test="${category.categoryId==post.categoryId}">
				<option selected="selected" value="${category.categoryId}">${category.name}</option>
				</c:when>
				<c:otherwise>
				<option value="${category.categoryId}">${category.name}</option>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</form:select>
	<font color="red"><form:errors path="categoryId"></form:errors></font><br>
	
	<label>제목</label>
	<form:input type="text" name="title" path="title" value="${post.title}" class="form-control" placeholder="제목을 입력하세요"/>
	<font color="red"><form:errors path="title"></form:errors></font><br>

	<label>#태그</label>
	<input type="text" name="tagString" id="tagString" class="form-control" placeholder="Enter, 콤마(,)로 구분하여 여러개의 태그를 등록하세요)" style="display: none;"><br>
	
	<c:forEach var="tag" items="${post.tags}">
		<script>setTags('${tag.name}')</script>
		<script>setTags('${tag.name}')</script>
	</c:forEach>
	
    <form:textarea name="content" path="content" id="editor1" rows="10" cols="80"></form:textarea>
    <font color="red"><form:errors path="content"></form:errors></font><br>

    <label></label>
    <button class="btn btn-lg btn-warning btn-block" type="submit">Update</button>
    <label></label>
    
</form:form>


<script>
	//Replace the <textarea id="editor1"> with a CKEditor
	// instance, using default configuration.
	CKEDITOR.replace( 'editor1',{
		height:'400px',
		'filebrowserImageUploadUrl':'/blog/post/imageUpload'
	});
	
	CKEDITOR.on('dialogDefinition', function( ev ){
	    var dialogName = ev.data.name;
	    var dialogDefinition = ev.data.definition;
	  
	    switch (dialogName) {
	        case 'image': //Image Properties dialog
	            //dialogDefinition.removeContents('info');
	            dialogDefinition.removeContents('Link');
	            dialogDefinition.removeContents('advanced');
	            break;
	    }
	});
</script>
